package de.vkb.komposit.platform.vorschlag.projections;

import de.vkb.komposit.platform.api.events.VorschlagInitialisiert;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VorschlagProjection {

    private final VorschlagEntityRepository repository;

    public VorschlagProjection(VorschlagEntityRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(VorschlagInitialisiert evt) {
        this.repository.save(VorschlagEntity.builder()
                .id(evt.getId())
                .build());
    }

    public List<VorschlagEntity> getAll() {
        return this.repository.findAll();
    }

    public BigDecimal berechneBeitrag(String id) {
        repository.findById(id);

        return BigDecimal.valueOf(560.55);
    }

}
