package de.vkb.komposit.platform.konto;

import de.vkb.komposit.platform.konto.aktionen.GeldAbheben;
import de.vkb.komposit.platform.konto.aktionen.KontoAnlegen;
import de.vkb.komposit.platform.konto.ereignisse.GeldAbgehoben;
import de.vkb.komposit.platform.konto.ereignisse.KontoAngelegt;
import lombok.extern.java.Log;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@Log
public class KontoAggregate {

    @AggregateIdentifier
    private String kontoNr;

    private double kontostand = 0;

    @CommandHandler
    public KontoAggregate(KontoAnlegen kontoAnlegen) {
        log.info("Konto anlegen: " + kontoAnlegen.getKontoNr());
        apply(new KontoAngelegt(kontoAnlegen.getKontoNr()));
    }

    @CommandHandler
    public void geldAbheben(GeldAbheben geldAbheben) {
        if(kontostand - geldAbheben.getAbhebeBetrag() > 0) {
            apply(new GeldAbgehoben(geldAbheben.getAbhebeBetrag()));
        }else {
            // Event GeldAbheben fehlgeschlagen
        }
    }

    @EventSourcingHandler
    public void on(KontoAngelegt kontoAngelegt) {
        log.info("Konto angelegt: " + kontoAngelegt.getKontoNr());
        this.kontoNr = kontoAngelegt.getKontoNr();
    }

    @EventSourcingHandler
    public void on(GeldAbgehoben geldAbgehoben) {
        this.kontostand -= geldAbgehoben.getAbhebeBetrag();
    }

}
