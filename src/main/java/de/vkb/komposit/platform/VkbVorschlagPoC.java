package de.vkb.komposit.platform;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class VkbVorschlagPoC implements ApplicationRunner {

    private final CommandGateway commandGateway;

    public VkbVorschlagPoC(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }


    public static void main(String[] args) {
        SpringApplication.run(VkbVorschlagPoC.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

}
