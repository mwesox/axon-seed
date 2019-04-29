package de.vkb.komposit.platform.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ProduktBaustein {
    private String id;
    private String name;
    private BigDecimal preis;
}
