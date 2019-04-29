package de.vkb.komposit.platform.antrag.api;

import de.vkb.komposit.platform.antrag.projektionen.AntragsVorgaengeProjektion;
import de.vkb.komposit.platform.api.commands.antrag.DirektionsAnfrageErstellen;
import de.vkb.komposit.platform.api.commands.antrag.StarteAntragsVorgang;
import de.vkb.komposit.platform.api.model.antrag.Direktionsanfrage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/antraege")
public class AntragsController {

    private final AntragsVorgaengeProjektion antragsVorgaengeProjektion;
    private final CommandGateway commandGateway;

    public AntragsController(AntragsVorgaengeProjektion antragsVorgaengeProjektion, CommandGateway commandGateway) {
        this.antragsVorgaengeProjektion = antragsVorgaengeProjektion;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public CompletableFuture<String> starteVorgang() {
        return this.commandGateway.send(new StarteAntragsVorgang(UUID.randomUUID().toString()));
    }

    @PostMapping("{antragsId}/direktionsanfrage")
    public CompletableFuture<String> erstelleDirektionsanfrage(
            @PathVariable String antragsId,
            @RequestBody Direktionsanfrage direktionsanfrage) throws ExecutionException, InterruptedException {

        return this.commandGateway
                .send(new DirektionsAnfrageErstellen(antragsId, direktionsanfrage.getAnfrageText()));
    }

}
