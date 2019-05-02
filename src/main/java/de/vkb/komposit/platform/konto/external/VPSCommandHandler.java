package de.vkb.komposit.platform.konto.external;

import de.vkb.komposit.platform.konto.ereignisse.KontoAngelegt;
import org.axonframework.eventhandling.EventHandler;

public class VPSCommandHandler {

    @EventHandler
    public void on(KontoAngelegt kontoAngelegt) {
        //TODO Rufe VPS-SVC xy auf

        //Ertelle Event VPS-aktualisert
    }

}
