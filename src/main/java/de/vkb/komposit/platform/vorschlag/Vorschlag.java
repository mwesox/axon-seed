package de.vkb.komposit.platform.vorschlag;

import de.vkb.komposit.platform.vorschlag.aktionen.*;
import de.vkb.komposit.platform.vorschlag.ereignisse.*;
import de.vkb.komposit.platform.vorschlag.model.Beitrag;
import de.vkb.komposit.platform.vorschlag.model.VorschlagId;
import de.vkb.komposit.platform.vorschlag.model.objekt.Objekt;
import de.vkb.komposit.platform.vorschlag.projektion.produkt.VerfuegbareProdukte;
import de.vkb.komposit.platform.vorschlag.service.VariantenBerechnungsService;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class Vorschlag {

    @AggregateIdentifier
    private VorschlagId vorschlagId;

    private Objekt objekt;

    @AggregateMember
    private List<Variante> varianten;

    private VariantenBerechnungsService variantenBerechnungsService;

    @Autowired
    public void setVariantenBerechnungsService(VariantenBerechnungsService variantenBerechnungsService) {
        this.variantenBerechnungsService = variantenBerechnungsService;
    }

    @CommandHandler
    public Vorschlag(VorschlagStarten vorschlagStarten) {
        apply(new VorschlagGestartet(vorschlagStarten.getVorschlagId(), vorschlagStarten.getKanal()));
    }

    @CommandHandler
    public void risikodatenEingeben(RisikodatenEingeben risikodatenEingeben) {

        apply(new RisikodatenEingegeben(risikodatenEingeben.getVorschlagId(), risikodatenEingeben.getObjekt()));
    }

    @CommandHandler
    public void variantenErzeugen(VariantenErzeugen variantenErzeugen) {
        if(varianten.size()>0){
            throw new IllegalArgumentException("Varianten existieren bereits");
        }
        apply(new VariantenErzeugt(variantenErzeugen.getVorschlagId(), variantenBerechnungsService.berechne()));
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
    public void on(RisikodatenEingegeben risikodatenEingegeben) {
        this.objekt = risikodatenEingegeben.getObjekt();
    }

    @EventSourcingHandler
    public void on(VariantenErzeugt variantenErzeugt) {
        this.varianten = variantenErzeugt.getVarianten();
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
