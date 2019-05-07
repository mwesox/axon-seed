package de.vkb.komposit.platform.vorschlag.service;

import de.vkb.komposit.platform.vorschlag.Variante;
import de.vkb.komposit.platform.vorschlag.model.Beitrag;
import de.vkb.komposit.platform.vorschlag.projektion.produkt.VerfuegbareProdukte;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VariantenBerechnungsService {
    private final VerfuegbareProdukte verfuegbareProdukte;

    public VariantenBerechnungsService(VerfuegbareProdukte verfuegbareProdukte) {
        this.verfuegbareProdukte = verfuegbareProdukte;
    }

    public List<Variante> berechne() {

        Variante v1 = new Variante();
        v1.setBeitrag(new Beitrag(BigDecimal.valueOf(112.55)));
        // TODO
        v1.setProdukt(verfuegbareProdukte.leseVerfuegbareProdukte().get(0));

        Variante v2 = new Variante();
        v2.setBeitrag(new Beitrag(BigDecimal.valueOf(99.55)));
        // TODO
        v2.setProdukt(verfuegbareProdukte.leseVerfuegbareProdukte().get(1));

        return List.of(v1, v2);
    }

}
