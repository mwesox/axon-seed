package de.vkb.komposit.platform;

import de.vkb.komposit.platform.api.model.ProduktBaustein;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.math.BigDecimal;

@SpringBootApplication
@EnableSwagger2
public class PlatformApplication implements ApplicationRunner {

    private final CommandGateway commandGateway;

    public PlatformApplication(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }


    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

/*        String id = (String) this.commandGateway.send(new ErstelleProdukt(
                Produkt.builder()
                        .tarif("Wohngebäude-2019")
                        .aktiv(true)
                        .id(UUID.randomUUID().toString())
                        .tarifBeschreibung("Wohngebäudeversicherung")
                        .bausteine(List.of(
                                erstelleProduktBaustein("1", "Feuer", 23.00),
                                erstelleProduktBaustein("1", "Hagel", 10.00),
                                erstelleProduktBaustein("1", "Wasser", 34.00)
                        ))
                        .build()
        )).get();*/


    }

    private ProduktBaustein erstelleProduktBaustein(String id, String name, Double preis) {
        return ProduktBaustein.builder()
                .id(id)
                .name(name)
                .preis(BigDecimal.valueOf(preis))
                .build();
    }
}
