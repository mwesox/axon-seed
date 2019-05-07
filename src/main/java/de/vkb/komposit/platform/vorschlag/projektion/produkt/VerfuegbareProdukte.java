package de.vkb.komposit.platform.vorschlag.projektion.produkt;

import de.vkb.komposit.platform.vorschlag.model.produkt.Produkt;
import de.vkb.komposit.platform.vorschlag.model.produkt.Produktbaustein;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerfuegbareProdukte {

    public List<Produkt> leseVerfuegbareProdukte() {
        return List.of(
                Produkt.builder()
                .id("p-1")
                .name("VGV-Vario-2017")
                .produktbaustein(
                        List.of(
                                Produktbaustein.builder()
                                        .name("Feuer")
                                        .build(),
                                Produktbaustein.builder()
                                        .name("Sturm")
                                        .build()
                        )
                )
                .build(),

                Produkt.builder()
                        .id("p-1")
                        .name("VGV-Vario-2018")
                        .produktbaustein(
                                List.of(
                                        Produktbaustein.builder()
                                                .name("Feuer")
                                                .build(),
                                        Produktbaustein.builder()
                                                .name("Sturm")
                                                .build()
                                )
                        )
                        .build()
        );
    }




}
