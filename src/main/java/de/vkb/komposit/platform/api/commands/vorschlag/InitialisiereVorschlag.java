package de.vkb.komposit.platform.api.commands.vorschlag;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class InitialisiereVorschlag {

    @TargetAggregateIdentifier
    private String id = UUID.randomUUID().toString();

}
