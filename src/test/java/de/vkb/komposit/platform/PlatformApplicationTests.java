package de.vkb.komposit.platform;

import de.vkb.komposit.platform.api.commands.vorschlag.InitialisiereVorschlag;
import de.vkb.komposit.platform.api.events.VorschlagInitialisiert;
import de.vkb.komposit.platform.vorschlag.VorschlagAggregate;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
public class PlatformApplicationTests {

    private FixtureConfiguration<VorschlagAggregate> fixture;

    @Before
    public void setUp() {
        fixture = new AggregateTestFixture<>(VorschlagAggregate.class);
    }

    @Test
    public void createVorschlag() {
        String vorschlagId = UUID.randomUUID().toString();
        String produktId = UUID.randomUUID().toString();
        VorschlagInitialisiert expectedEvent = new VorschlagInitialisiert(vorschlagId);

        fixture
                .givenNoPriorActivity()
                .when(new InitialisiereVorschlag())
                .expectSuccessfulHandlerExecution()
                .expectEvents(expectedEvent);
    }

}
