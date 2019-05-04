package de.vkb.komposit.platform.vorschlag.web;

import com.google.common.collect.Lists;
import de.vkb.komposit.platform.vorschlag.aktionen.RisikodatenEingeben;
import de.vkb.komposit.platform.vorschlag.aktionen.VorschlagStarten;
import de.vkb.komposit.platform.vorschlag.ereignisse.RisikodatenEingegeben;
import de.vkb.komposit.platform.vorschlag.model.VorschlagId;
import de.vkb.komposit.platform.vorschlag.model.objekt.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/vorschlaege")
public class VorschlagController {

    private final CommandGateway commandGateway;

    public VorschlagController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("")
    public CompletableFuture<String> starteVorschlag() {
        return this.commandGateway.send(new VorschlagStarten(VorschlagId
                .builder()
                .id(UUID.randomUUID())
                .build())
        );
    }

    @PostMapping("{vorschlagId}/risikodaten")
    public CompletableFuture<Object> risikodatenEingeben(@PathVariable String vorschlagId, @RequestBody RisikodatenEingegeben risikodatenEingegeben) {
        //TODO create DTO for risikodatenEingeben without vorschlagID
        return this.commandGateway.send(risikodatenEingegeben.toBuilder()
                .vorschlagId(new VorschlagId(UUID.fromString(vorschlagId)))
                .build());
    }

    @GetMapping("/beispiel_rd")
    public RisikodatenEingeben generate() {
        return RisikodatenEingeben.builder()
                .objekt(Objekt.builder()
                        .anschrift(Anschrift.builder()
                                .hausnummer("31a")
                                .postleitzahl("82110")
                                .strasse("Münchner Str. 22a")
                                .build())
                        .anzahlObergeschosse(new AnzahlObergeschosse(3))
                        .bauart(Bauart.MASSIV)
                        .baujahr(1990)
                        .fertighaus(false)
                        .objektTyp(ObjektTyp.EINFAMILIENHAUS)
                        .vermietung(Vermietung.NEIN)
                        .sanierung(List.of(
                                new Sanierung(Sanierungstyp.DACHBEDECKUNG, 2000),
                                new Sanierung(Sanierungstyp.DACHSTUHL, 1999)
                        ))
                        .build())
                .vorschlagId(VorschlagId.builder().id(UUID.randomUUID()).build())
                .build();
    }

}
