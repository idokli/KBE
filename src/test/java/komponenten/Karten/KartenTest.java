package komponenten.Karten;

import datenmodel.Spielkarte;
import komponenten.Karten.export.IKarten;
import komponenten.Karten.impl.KartenImpl;
import datenmodel.Enum.SpielTyp;
import datenmodel.Exceptions.MauMauException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class KartenTest {

    private static IKarten kartenService;

    @BeforeClass
    public static void initialize() {
        kartenService = new KartenImpl();
    }

    /**
     * Test für den erfolgreichen Bau des Kartenstapels
     * @throws MauMauException
     */
    @Test
    public void testBaueStapelSuccess() throws MauMauException {

        // MauMau-Typ
        SpielTyp spielTyp = SpielTyp.MauMau;

        List<Spielkarte> kartenStapel = kartenService.baueStapel(spielTyp);

        // Der Stapel sollte nicht null sein
        assertNotNull(kartenStapel);

        // Der Stapel sollte 56 Spielkarten haben (also inklusive 4 Joker)
        assertEquals( 56, kartenStapel.size());

    }

    /**
     * Test für den gescheiterten Bau des Kartenstapels
     * @throws MauMauException
     */
    @Test(expected = MauMauException.class)
    public void testBaueStapelFailed() throws MauMauException {

        // Leerer Typ
        SpielTyp spielTyp = null;

        // Sollte MauMauException werfen
        kartenService.baueStapel(spielTyp);

    }
}
