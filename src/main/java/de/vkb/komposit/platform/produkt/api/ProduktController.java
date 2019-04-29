package de.vkb.komposit.platform.produkt.api;

import de.vkb.komposit.platform.api.commands.ErstelleProdukt;
import de.vkb.komposit.platform.produkt.projections.ProduktEntity;
import de.vkb.komposit.platform.produkt.projections.ProduktProjection;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/produkt")
public class ProduktController {

    private final ProduktProjection produktProjection;
    private final CommandGateway commandGateway;

    public ProduktController(ProduktProjection produktProjection, CommandGateway commandGateway) {
        this.produktProjection = produktProjection;
        this.commandGateway = commandGateway;
    }

    @GetMapping
    public List<ProduktEntity> loadAll() {
        return this.produktProjection.findAll();
    }

    @PostMapping
    public CompletableFuture<Object> createProduct(@RequestBody ErstelleProdukt erstelleProdukt) {
        return this.commandGateway.send(erstelleProdukt);
    }

}
