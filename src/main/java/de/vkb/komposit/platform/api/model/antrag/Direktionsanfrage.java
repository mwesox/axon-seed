package de.vkb.komposit.platform.api.model.antrag;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class Direktionsanfrage {

    private String anfrageText;
}
