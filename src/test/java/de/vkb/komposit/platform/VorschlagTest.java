package de.vkb.komposit.platform;

import de.vkb.komposit.platform.vorschlag.Vorschlag;
import de.vkb.komposit.platform.vorschlag.aktionen.RisikodatenEingeben;
import de.vkb.komposit.platform.vorschlag.aktionen.VorschlagAnnehmen;
import de.vkb.komposit.platform.vorschlag.aktionen.VorschlagStarten;
import de.vkb.komposit.platform.vorschlag.ereignisse.VorschlagAngenommen;
import de.vkb.komposit.platform.vorschlag.ereignisse.VorschlagGestartet;
import de.vkb.komposit.platform.vorschlag.model.VorschlagId;
import de.vkb.komposit.platform.vorschlag.model.objekt.*;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
public class VorschlagTest {

    private FixtureConfiguration<Vorschlag> fixture;

    @Before
    public void setUp() {
        fixture = new AggregateTestFixture<>(Vorschlag.class);
    }

    @Test
    public void vorschlagStarten() {
        VorschlagId vorschlagId = VorschlagId.builder().id(UUID.randomUUID()).build();
        String produktId = UUID.randomUUID().toString();
        VorschlagGestartet expectedEvent = new VorschlagGestartet(vorschlagId);

        fixture
                .givenNoPriorActivity()
                .when(new VorschlagStarten(vorschlagId))
                .expectSuccessfulHandlerExecution()
                .expectEvents(expectedEvent);
    }

    @Test
    public void vorschlagAnnehmen() {
        VorschlagId vorschlagId = VorschlagId.builder().id(UUID.randomUUID()).build();

        fixture
                .given(new VorschlagGestartet(vorschlagId))
                .when(new VorschlagAnnehmen(vorschlagId))
                .expectSuccessfulHandlerExecution()
                .expectEvents(new VorschlagAngenommen(vorschlagId));
    }

    public RisikodatenEingeben createRisikodaten() {
        return RisikodatenEingeben.builder()
                .objekt(Objekt.builder()
                        .anschrift(Anschrift.builder()
                                .hausnummer("31a")
                                .postleitzahl("82110")
                                .strasse("Münchner Str. 22a")
                                .build())
                        .anzahlObergeschosse(new AnzahlObergeschosse(3))
                        .bauart(Bauart.MASSIV)
                        .baujahr(1990)
                        .fertighaus(false)
                        .objektTyp(ObjektTyp.EINFAMILIENHAUS)
                        .vermietung(Vermietung.NEIN)
                        .sanierung(List.of(
                                new Sanierung(Sanierungstyp.DACHBEDECKUNG, 2000),
                                new Sanierung(Sanierungstyp.DACHSTUHL, 1999)
                        ))
                        .build())
                .vorschlagId(VorschlagId.builder().id(UUID.randomUUID()).build())
                .build();
    }
    
}
