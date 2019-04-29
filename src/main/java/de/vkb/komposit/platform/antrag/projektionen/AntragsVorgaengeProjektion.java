package de.vkb.komposit.platform.antrag.projektionen;

import de.vkb.komposit.platform.api.events.antrag.AntragsVorgangGestartet;
import de.vkb.komposit.platform.api.events.antrag.DirektionsanfrageGestellt;
import de.vkb.komposit.platform.api.model.antrag.Direktionsanfrage;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
public class AntragsVorgaengeProjektion {

    private final AntragsVorgaengeRepository repository;

    public AntragsVorgaengeProjektion(AntragsVorgaengeRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(AntragsVorgangGestartet evt) {
        this.repository.save(new AntragsVorgang(evt.getAntragId(), "offen", null));

    }

    @EventHandler
    public void on(DirektionsanfrageGestellt evt) {
        this.repository.findById(evt.getAntragId()).ifPresent(v -> {
            v.setDirektionsanfrage(new Direktionsanfrage(evt.getAnfrageText()));
            v.setStatus("direktionsanfrage_gestellt");
            this.repository.save(v);
        });

    }

}
