package de.vkb.komposit.platform.api.events;

import de.vkb.komposit.platform.api.model.Produkt;
import lombok.Value;

@Value
public class ProduktErstellt {

    private String id;
    private Produkt produkt;

}
