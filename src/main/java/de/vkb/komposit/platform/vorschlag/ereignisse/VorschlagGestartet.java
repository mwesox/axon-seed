package de.vkb.komposit.platform.vorschlag.ereignisse;

import com.fasterxml.jackson.annotation.JsonCreator;
import de.vkb.komposit.platform.vorschlag.model.Kanal;
import de.vkb.komposit.platform.vorschlag.model.VorschlagId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Builder
public class VorschlagGestartet {
    private VorschlagId vorschlagId;
    private Kanal kanal;
}
