package de.vkb.komposit.platform.vorschlag.ereignisse;

import com.fasterxml.jackson.annotation.JsonCreator;
import de.vkb.komposit.platform.vorschlag.model.VorschlagId;
import de.vkb.komposit.platform.vorschlag.model.objekt.Objekt;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Builder(toBuilder = true)
public class RisikodatenEingegeben {

    @TargetAggregateIdentifier
    private VorschlagId vorschlagId;

    private Objekt objekt;
}
