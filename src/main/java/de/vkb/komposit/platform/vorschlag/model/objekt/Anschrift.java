package de.vkb.komposit.platform.vorschlag.model.objekt;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Builder
public class Anschrift {

    String strasse;
    String postleitzahl;
    String hausnummer;

}
