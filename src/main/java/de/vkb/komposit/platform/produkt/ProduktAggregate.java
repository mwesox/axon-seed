package de.vkb.komposit.platform.produkt;

import de.vkb.komposit.platform.api.commands.AktiviereProdukt;
import de.vkb.komposit.platform.api.commands.DeaktiviereProdukt;
import de.vkb.komposit.platform.api.commands.ErstelleProdukt;
import de.vkb.komposit.platform.api.events.ProduktAktiviert;
import de.vkb.komposit.platform.api.events.ProduktDeaktiviert;
import de.vkb.komposit.platform.api.events.ProduktErstellt;
import de.vkb.komposit.platform.api.model.Produkt;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class ProduktAggregate {

    @AggregateIdentifier
    private String id;

    private Produkt produkt;

    @CommandHandler
    public ProduktAggregate(ErstelleProdukt cmd) {
        apply(new ProduktErstellt(cmd.getId(), cmd.getProdukt()));
    }

    @EventSourcingHandler
    public void on(ProduktErstellt evt) {
        this.id = evt.getId();
        this.produkt = evt.getProdukt();
    }

    @EventSourcingHandler
    public void on(DeaktiviereProdukt evt) {
        this.produkt = this.produkt.toBuilder().aktiv(false).build();
        apply(new ProduktDeaktiviert(evt.getId()));
    }

    @EventSourcingHandler
    public void on(AktiviereProdukt evt) {
        if(!this.produkt.isAktiv()){
            this.produkt = this.produkt.toBuilder().aktiv(true).build();
            apply(new ProduktAktiviert(evt.getId()));
        }

    }

}
