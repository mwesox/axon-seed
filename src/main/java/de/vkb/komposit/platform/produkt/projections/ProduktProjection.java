package de.vkb.komposit.platform.produkt.projections;

import de.vkb.komposit.platform.api.events.ProduktDeaktiviert;
import de.vkb.komposit.platform.api.events.ProduktErstellt;
import de.vkb.komposit.platform.api.model.Produkt;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduktProjection {

    private final ProduktEntityRepository repository;

    public ProduktProjection(ProduktEntityRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(ProduktErstellt evt) {
        this.repository.save(ProduktEntity.builder()
                .id(evt.getId())
                .produkt(evt.getProdukt())
                .build());
    }

    @EventHandler
    public void on(ProduktDeaktiviert produktDeaktiviert) {
        this.repository.findById(produktDeaktiviert.getId()).ifPresent(produktEntity -> {
            Produkt produkt = produktEntity.getProdukt();
            produktEntity.setProdukt(produkt.toBuilder().aktiv(false).build());
            this.repository.save(produktEntity);
        });
    }

    public ProduktEntity findById(String produktId) {
        return this.repository.findById(produktId).get();
    }

    public List<ProduktEntity> findAll() {
        return this.repository.findAll();
    }
}
