package de.vkb.komposit.platform.vorschlag.projections;

import de.vkb.komposit.platform.api.model.Produkt;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder(toBuilder = true)
public class VorschlagEntity {

    @Id
    private String id;

    private Produkt produkt;

}
