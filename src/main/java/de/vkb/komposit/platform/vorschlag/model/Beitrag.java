package de.vkb.komposit.platform.vorschlag.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Builder
public class Beitrag {

    private static int scale = 2;

    private BigDecimal betragNetto;

    public BigDecimal getBetragNetto() {
        this.betragNetto.setScale(scale);
        return this.betragNetto;
    }

}
