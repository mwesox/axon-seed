package de.vkb.komposit.platform.konto.aktionen;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class KontoAnlegen {

    @TargetAggregateIdentifier
    private String kontoNr;

}
