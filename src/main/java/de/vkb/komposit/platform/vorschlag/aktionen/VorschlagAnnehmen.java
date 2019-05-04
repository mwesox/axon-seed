package de.vkb.komposit.platform.vorschlag.aktionen;

import com.fasterxml.jackson.annotation.JsonCreator;
import de.vkb.komposit.platform.vorschlag.model.VorschlagId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Builder
public class VorschlagAnnehmen {

    @TargetAggregateIdentifier
    private VorschlagId vorschlagId;
}
