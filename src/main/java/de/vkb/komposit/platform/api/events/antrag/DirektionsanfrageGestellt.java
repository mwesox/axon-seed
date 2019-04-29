package de.vkb.komposit.platform.api.events.antrag;

import com.fasterxml.jackson.annotation.JsonCreator;
import de.vkb.komposit.platform.api.commands.antrag.DirektionsAnfrageErstellen;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Builder
public class DirektionsanfrageGestellt {
    private String antragId;

    private String anfrageText;


    public static DirektionsanfrageGestellt of(DirektionsAnfrageErstellen cmd) {
        return DirektionsanfrageGestellt.builder()
                .anfrageText(cmd.getAnfrageText())
                .antragId(cmd.getAntragId())
                .build();
    }
}
