package de.vkb.komposit.platform.vorschlag.projektion.vorschlag;

import de.vkb.komposit.platform.vorschlag.model.VorschlagId;
import de.vkb.komposit.platform.vorschlag.model.objekt.Objekt;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class VorschlagDocument {

    @Id
    private VorschlagId vorschlagId;

    private Objekt objekt;

}
