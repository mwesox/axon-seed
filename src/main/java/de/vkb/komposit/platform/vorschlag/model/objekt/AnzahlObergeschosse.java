package de.vkb.komposit.platform.vorschlag.model.objekt;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Builder
public class AnzahlObergeschosse {

    public static int MIN = 0;
    public static int MAX = 10;

    private int anzahl;

    public boolean isValid() {
        if(anzahl>MIN && anzahl < MAX) {
            return true;
        }else{
            return false;
        }
    }

}
