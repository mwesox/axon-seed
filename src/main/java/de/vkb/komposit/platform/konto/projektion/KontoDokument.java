package de.vkb.komposit.platform.konto.projektion;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class KontoDokument {

    @Id
    private String kontoNr;
}
