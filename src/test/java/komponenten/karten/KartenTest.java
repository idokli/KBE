package komponenten.karten;

import config.AppConfig;
import datenmodel.Enum.Blatttyp;
import datenmodel.Enum.Blattwert;
import datenmodel.Exceptions.MauMauException;
import datenmodel.Spielkarte;
import komponenten.karten.export.IKarten;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
public class KartenTest {

    @Autowired
    private IKarten kartenService;

    /**
     * Test für den erfolgreichen Bau des Kartenstapels
     *
     * @throws MauMauException
     */
    @Test
    public void testBaueStapelSuccess() throws MauMauException {

        // Stapel bauen
        List<Blattwert> blattwertNicht = new ArrayList<>();
        blattwertNicht.add(Blattwert.Joker);
        List<Blatttyp> blatttypNicht = new ArrayList<>();
        List<Spielkarte> kartenStapel = kartenService.baueStapel(blatttypNicht, blattwertNicht);

        // Der Stapel sollte nicht null sein
        assertNotNull(kartenStapel);

        // Der Stapel sollte 56 Spielkarten haben (also inklusive 4 Joker)
        assertEquals(52, kartenStapel.size());

        // Alle Spielkarten prüfen
        List<Spielkarte> richtigerStapel = new ArrayList<>();
        for (Blatttyp blatttyp : Blatttyp.values()) {
            for (Blattwert blattwert : Blattwert.values()) {
                if (blattwert != Blattwert.Joker) {
                    richtigerStapel.add(new Spielkarte(blattwert, blatttyp));
                }
            }
        }

        assertTrue(kartenStapel.containsAll(richtigerStapel));

    }

    /**
     * Test für den gescheiterten Bau des Kartenstapels
     *
     * @throws MauMauException
     */
    @Test(expected = MauMauException.class)
    public void testBaueStapelFailed() throws MauMauException {

        // Beide Listen null
        List<Blattwert> blattwertNicht = null;
        List<Blatttyp> blatttypNicht = null;

        // Sollte MauMauException werfen
        kartenService.baueStapel(blatttypNicht, blattwertNicht);

    }
}
