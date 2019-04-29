package de.vkb.komposit.platform.api.commands;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class DeaktiviereProdukt {
    @TargetAggregateIdentifier
    private String id;
}
