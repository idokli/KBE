package komponenten.Karten;

import komponenten.Karten.export.IKarten;
import komponenten.Karten.impl.KartenImpl;
import datenmodel.Enum.SpielTyp;
import datenmodel.Exceptions.MauMauException;
import datenmodel.KartenStapel;
import org.junit.BeforeClass;
import org.junit.Test;

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

        KartenStapel kartenStapel = kartenService.baueStapel(spielTyp);

        // Der Stapel sollte nicht null sein
        assertNotNull(kartenStapel);

        // Der Stapel sollte 52 Spielkarten haben
        assertEquals( 52, kartenStapel.getStapel().size());

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
