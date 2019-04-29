package de.vkb.komposit.platform.antrag;

import de.vkb.komposit.platform.api.commands.antrag.DirektionsAnfrageErstellen;
import de.vkb.komposit.platform.api.commands.antrag.StarteAntragsVorgang;
import de.vkb.komposit.platform.api.events.antrag.AntragsVorgangGestartet;
import de.vkb.komposit.platform.api.events.antrag.DirektionsanfrageGestellt;
import de.vkb.komposit.platform.api.model.antrag.Direktionsanfrage;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.ArrayList;
import java.util.List;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class AntragAggregate {

    @AggregateIdentifier
    private String id;

    private List<Direktionsanfrage> direktionsanfragen = new ArrayList<>();

    @CommandHandler
    public AntragAggregate(StarteAntragsVorgang starteAntragsVorgang) {
        apply(new AntragsVorgangGestartet(starteAntragsVorgang.getAntragId()));
    }

    @CommandHandler
    public void on(DirektionsAnfrageErstellen cmd) {
        apply(DirektionsanfrageGestellt.of(cmd));
    }

    @EventSourcingHandler
    public void on(AntragsVorgangGestartet antragsVorgangGestartet) {
        this.id = antragsVorgangGestartet.getAntragId();
    }

    @EventSourcingHandler
    public void on(DirektionsanfrageGestellt evt) {
        this.direktionsanfragen.add(new Direktionsanfrage(evt.getAnfrageText()));
    }

}
