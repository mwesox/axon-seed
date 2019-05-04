package de.vkb.komposit.platform.vorschlag;

import de.vkb.komposit.platform.vorschlag.aktionen.*;
import de.vkb.komposit.platform.vorschlag.ereignisse.*;
import de.vkb.komposit.platform.vorschlag.model.VorschlagId;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class Vorschlag {

    @AggregateIdentifier
    VorschlagId vorschlagId;

    @CommandHandler
    public Vorschlag(VorschlagStarten vorschlagStarten) {
        apply(new VorschlagGestartet(vorschlagStarten.getVorschlagId()));
    }

    @CommandHandler
    public void risikodatenEingeben(RisikodatenEingeben risikodatenEingeben) {

        apply(new RisikodatenEingegeben(risikodatenEingeben.getVorschlagId(), risikodatenEingeben.getObjekt()));
    }

    @CommandHandler
    public void variantenErzeugen(VariantenErzeugen variantenErzeugen) {
        apply(new VariantenErzeugt(variantenErzeugen.getVorschlagId()));
    }

    @CommandHandler
    public void varianteWählen(VarianteWählen varianteWaehlen) {
        apply(new VarianteAusgewählt(varianteWaehlen.getVorschlagId()));
    }

    @CommandHandler
    public void vorschlagAnnehmen(VorschlagAnnehmen vorschlagAnnehmen) {
        apply(new VorschlagAngenommen(vorschlagAnnehmen.getVorschlagId()));
    }

    @CommandHandler
    public void vorschlagAblehnen(VorschlagAblehnen vorschlagAblehnen) {
        apply(new VorschlagAbgelehnt(vorschlagAblehnen.getVorschlagId()));
    }

    @EventSourcingHandler
    public void on(VorschlagGestartet vorschlagGestartet) {
        this.vorschlagId = vorschlagGestartet.getVorschlagId();
    }

    @EventSourcingHandler
    public void on(VariantenErzeugt variantenErzeugt) {

    }

    @EventSourcingHandler
    public void on(VarianteAusgewählt varianteAusgewählt) {

    }

    @EventSourcingHandler
    public void on(VorschlagAngenommen vorschlagAngenommen) {

    }

    @EventSourcingHandler
    public void on(VorschlagAbgelehnt vorschlagAbgelehnt) {

    }



}
