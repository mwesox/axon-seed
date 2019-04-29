package de.vkb.komposit.platform.api.commands.antrag;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class DirektionsAnfrageErstellen {

    @TargetAggregateIdentifier
    private String antragId;
    private String anfrageText;

}
