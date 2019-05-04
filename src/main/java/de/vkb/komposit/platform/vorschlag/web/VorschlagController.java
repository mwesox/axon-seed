package de.vkb.komposit.platform.vorschlag.web;

import com.google.common.collect.Lists;
import de.vkb.komposit.platform.vorschlag.aktionen.RisikodatenEingeben;
import de.vkb.komposit.platform.vorschlag.aktionen.VorschlagStarten;
import de.vkb.komposit.platform.vorschlag.ereignisse.RisikodatenEingegeben;
import de.vkb.komposit.platform.vorschlag.model.Kanal;
import de.vkb.komposit.platform.vorschlag.model.VorschlagId;
import de.vkb.komposit.platform.vorschlag.model.objekt.*;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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

    @ApiResponses(

            @ApiResponse(response = String.class, code = 200, message = "ID des Aggregats")
    )
    @ApiModelProperty(dataType = "string")
    @PostMapping
    public CompletableFuture<String> starteVorschlag() {
        return this.commandGateway.send(new VorschlagStarten(VorschlagId
                .builder()
                .id(UUID.randomUUID())
                .build(), Kanal.KUNDENPORTAL)
        );
    }

    @ApiResponses(
            @ApiResponse(response = String.class, code = 200, message = "Empty response")
    )
    @PostMapping("{vorschlagId}/risikodaten")
    public CompletableFuture<String> risikodatenEingeben(@PathVariable String vorschlagId, @RequestBody RisikodatenEingeben risikodatenEingeben) {
        //TODO create DTO for risikodatenEingeben without vorschlagID
        return this.commandGateway.send(risikodatenEingeben.toBuilder()
                .vorschlagId(new VorschlagId(UUID.fromString(vorschlagId)))
                .build());
    }

    @ApiIgnore
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
