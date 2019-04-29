package de.vkb.komposit.platform.api.commands.vorschlag;

import com.fasterxml.jackson.annotation.JsonCreator;
import de.vkb.komposit.platform.api.model.objekt.VersichertesObjekt;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value()
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Builder
public class FuegeVersichertesObjektHinzu {

    private String id;
    private VersichertesObjekt objekt;

}
