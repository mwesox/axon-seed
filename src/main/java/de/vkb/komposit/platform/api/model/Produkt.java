package de.vkb.komposit.platform.api.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder(toBuilder = true)
public class Produkt {
    private String id;
    private List<ProduktBaustein> bausteine;
    private boolean aktiv;
    private String tarif;
    private String tarifBeschreibung;
}
