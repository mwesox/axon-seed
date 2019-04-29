package de.vkb.komposit.platform.api.model.objekt.kraft;

import lombok.Data;

@Data
public class Fahrzeug {

    private HerstellerSN hsn;
    private TypSN tsn;
    private Laufleistung laufleistung;

}
