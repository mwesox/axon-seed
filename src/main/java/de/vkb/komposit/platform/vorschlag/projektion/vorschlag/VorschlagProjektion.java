package de.vkb.komposit.platform.vorschlag.projektion.vorschlag;

import de.vkb.komposit.platform.vorschlag.aktionen.RisikodatenEingeben;
import de.vkb.komposit.platform.vorschlag.ereignisse.RisikodatenEingegeben;
import de.vkb.komposit.platform.vorschlag.ereignisse.VorschlagGestartet;
import lombok.extern.java.Log;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@Log
public class VorschlagProjektion {

    private final VorschlagDocumentRepository vorschlagRepository;

    public VorschlagProjektion(VorschlagDocumentRepository vorschlagRepository) {
        this.vorschlagRepository = vorschlagRepository;
    }

    @EventHandler
    public void on(VorschlagGestartet vorschlagGestartet) {
        VorschlagDocument vorschlagDocument = new VorschlagDocument();
        vorschlagDocument.setVorschlagId(vorschlagGestartet.getVorschlagId().getId().toString());
        vorschlagDocument.setKanal(vorschlagGestartet.getKanal());
        this.vorschlagRepository.save(vorschlagDocument);
    }

    @EventHandler
    public void on(RisikodatenEingegeben risikodatenEingegeben) {
        log.info("Projektion - RisikodatenEingeben");
        vorschlagRepository.findById(risikodatenEingegeben.getVorschlagId().getId().toString()).ifPresent(e -> {
            e.setObjekt(risikodatenEingegeben.getObjekt());
            this.vorschlagRepository.save(e);
        });
    }

}
