package de.vkb.komposit.platform.konto.web;

import de.vkb.komposit.platform.konto.aktionen.KontoAnlegen;
import lombok.extern.java.Log;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
@Log
public class KontoController {

    @Autowired
    private final CommandGateway commandGateway;

    public KontoController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("konten")
    public CompletableFuture<String> kontoAnlegen() {
        log.info("REST: kontoAnlegen");
        String kontoNr = UUID.randomUUID().toString();
        KontoAnlegen kontoAnlegen = new KontoAnlegen(kontoNr);

        return commandGateway.send(kontoAnlegen);
    }

}
