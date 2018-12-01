package komponenten.Karten;

import datenmodel.Enum.Blatttyp;
import datenmodel.Enum.Blattwert;
import datenmodel.Spielkarte;
import komponenten.Karten.export.IKarten;
import komponenten.Karten.impl.KartenImpl;
import datenmodel.Enum.SpielTyp;
import datenmodel.Exceptions.MauMauException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class KartenTest {

    private static IKarten kartenService;

    @BeforeClass
    public static void initialize() {
        kartenService = new KartenImpl();
    }

    /**
     * Test für den erfolgreichen Bau des Kartenstapels
     *
     * @throws MauMauException
     */
    @Test
    public void testBaueStapelSuccess() throws MauMauException {

        // MauMau-Typ
        SpielTyp spielTyp = SpielTyp.MauMau;
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
