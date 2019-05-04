package de.vkb.komposit.platform.vorschlag.aktionen;

import com.fasterxml.jackson.annotation.JsonCreator;
import de.vkb.komposit.platform.vorschlag.model.VorschlagId;
import de.vkb.komposit.platform.vorschlag.model.objekt.Objekt;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Builder
public class RisikodatenEingeben {

    @TargetAggregateIdentifier
    private VorschlagId vorschlagId;
    private Objekt objekt;

}
