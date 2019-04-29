package de.vkb.komposit.platform.produkt.api;

import de.vkb.komposit.platform.produkt.projections.ProduktProjection;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class Tarifrechner {

    private final ProduktProjection produktProjection;

    public Tarifrechner(ProduktProjection produktProjection) {
        this.produktProjection = produktProjection;
    }


    public BigDecimal berechneTarif(String produktId) {
        this.produktProjection.findById(produktId);

        return BigDecimal.valueOf(1234.33);
    }


}
