package de.vkb.komposit.platform.api.events.antrag;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class AntragsVorgangGestartet {
    private String antragId;
}
