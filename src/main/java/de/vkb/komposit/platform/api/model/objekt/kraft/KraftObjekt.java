package de.vkb.komposit.platform.api.model.objekt.kraft;

import de.vkb.komposit.platform.api.model.objekt.VersichertesObjekt;
import lombok.Data;

@Data
public class KraftObjekt implements VersichertesObjekt {

    private Versicherungsnehmer versicherungsnehmer;
    private Fahrzeug fahrzeug;

    @Override
    public String sparte() {
        return "Kraftfahrt";
    }
}
