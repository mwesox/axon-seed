package de.vkb.komposit.platform.produkt.projections;

import de.vkb.komposit.platform.api.model.Produkt;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class ProduktEntity {

    @Id
    private String id;
    private Produkt produkt;




}
