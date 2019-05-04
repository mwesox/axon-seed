package de.vkb.komposit.platform.vorschlag.projektion.vorschlag;

import de.vkb.komposit.platform.vorschlag.model.Kanal;
import de.vkb.komposit.platform.vorschlag.model.VorschlagId;
import de.vkb.komposit.platform.vorschlag.model.objekt.Objekt;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class VorschlagDocument {

    @Id
    private String vorschlagId;

    private Objekt objekt;

    private Kanal kanal;

}
