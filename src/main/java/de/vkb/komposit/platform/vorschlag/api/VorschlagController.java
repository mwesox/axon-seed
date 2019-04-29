package de.vkb.komposit.platform.vorschlag.api;

import de.vkb.komposit.platform.api.commands.vorschlag.InitialisiereVorschlag;
import de.vkb.komposit.platform.vorschlag.projections.VorschlagEntity;
import de.vkb.komposit.platform.vorschlag.projections.VorschlagProjection;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/vorschlag")
public class VorschlagController {

    private final CommandGateway commandGateway;
    private final VorschlagProjection vorschlagProjection;

    public VorschlagController(CommandGateway commandGateway, VorschlagProjection vorschlagProjection) {
        this.commandGateway = commandGateway;
        this.vorschlagProjection = vorschlagProjection;
    }

    @PostMapping
    public CompletableFuture<String> erstelleVorschlag(@RequestBody InitialisiereVorschlag cmd) {

        return commandGateway.send(cmd);
    }

    @PostMapping("temp")
    public CompletableFuture<String> fuegeVersichertesObjektHinzu(@RequestBody InitialisiereVorschlag cmd) {

        return commandGateway.send(cmd);
    }

    @GetMapping("/{id}")
    public BigDecimal berechneVorschlag(@PathVariable String id) {
        return vorschlagProjection.berechneBeitrag(id);
    }

    @GetMapping
    public List<VorschlagEntity> loadAll() {
        return this.vorschlagProjection.getAll();
    }
}
