package de.vkb.komposit.platform.vorschlag;

import de.vkb.komposit.platform.vorschlag.model.produkt.Produkt;
import de.vkb.komposit.platform.vorschlag.model.Beitrag;
import lombok.Data;
import org.axonframework.modelling.command.EntityId;

@Data
public class Variante {

    @EntityId
    private String id;

    private Produkt produkt;
    private Beitrag beitrag;

}
