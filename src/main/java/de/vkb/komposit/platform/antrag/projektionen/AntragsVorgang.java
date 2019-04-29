package de.vkb.komposit.platform.antrag.projektionen;

import de.vkb.komposit.platform.api.model.antrag.Direktionsanfrage;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class AntragsVorgang {

    @Id
    private String id;
    private String status;
    private Direktionsanfrage direktionsanfrage;

}
