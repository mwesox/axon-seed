package de.vkb.komposit.platform.konto.projektion;

import de.vkb.komposit.platform.konto.ereignisse.KontoAngelegt;
import lombok.extern.java.Log;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class KontoService {

    private final KontoRepository kontoRepository;

    public KontoService(KontoRepository kontoRepository) {
        this.kontoRepository = kontoRepository;
    }

    public List<KontoDokument> leseAlleKonten() {
        return kontoRepository.findAll();
    }

    @EventHandler
    public void on(KontoAngelegt kontoAngelegt) {
        KontoDokument dokument = new KontoDokument();
        dokument.setKontoNr(kontoAngelegt.getKontoNr());
        kontoRepository.save(dokument);

        log.info("Konto wurde im QUERY-Modell gespeichert");
    }

}
