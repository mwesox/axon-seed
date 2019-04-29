package de.vkb.komposit.platform.vorschlag;

import de.vkb.komposit.platform.api.commands.vorschlag.InitialisiereVorschlag;
import de.vkb.komposit.platform.api.events.VorschlagInitialisiert;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class VorschlagAggregate {

    @AggregateIdentifier
    private String id;

    @CommandHandler
    public VorschlagAggregate(InitialisiereVorschlag berechneVorschlag) {
        apply(new VorschlagInitialisiert(
                berechneVorschlag.getId()
        ));
    }

    @EventSourcingHandler
    public void on(VorschlagInitialisiert evt) {
        this.id = evt.getId();
    }


}
