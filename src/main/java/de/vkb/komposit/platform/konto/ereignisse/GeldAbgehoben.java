package de.vkb.komposit.platform.konto.ereignisse;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.eventhandling.AllowReplay;

@Data
@AllArgsConstructor
public class GeldAbgehoben {

    double abhebeBetrag;
}
