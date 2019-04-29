package de.vkb.komposit.platform.api.commands;

import com.fasterxml.jackson.annotation.JsonCreator;
import de.vkb.komposit.platform.api.model.Produkt;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class ErstelleProdukt {

    @TargetAggregateIdentifier
    private String id = UUID.randomUUID().toString();

    private Produkt produkt;

}
