package komponenten.Spielregel;


import komponenten.Spielregel.export.ISpielregel;
import komponenten.Spielregel.impl.SpielregelOhneSonderImpl;
import datenmodel.Enum.Blatttyp;
import datenmodel.Enum.Blattwert;
import datenmodel.Exceptions.MauMauException;
import datenmodel.Spielkarte;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SpielRegelOhneSonderTest {

    private static ISpielregel spielRegelService;

    @BeforeClass
    public static void initialize() {

        spielRegelService = new SpielregelOhneSonderImpl();
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = {{new Spielkarte(Blattwert.Acht, Blatttyp.Herz), new Spielkarte(Blattwert.Bube, Blatttyp.Herz), true},
                {new Spielkarte(Blattwert.Acht, Blatttyp.Herz), new Spielkarte(Blattwert.Acht, Blatttyp.Pik), true},
                {new Spielkarte(Blattwert.Acht, Blatttyp.Herz), new Spielkarte(Blattwert.Sieben, Blatttyp.Karo), false},
                {new Spielkarte(Blattwert.Zehn, Blatttyp.Kreuz), new Spielkarte(Blattwert.Dame, Blatttyp.Herz), false}};
        return Arrays.asList(data);
    }

    private Spielkarte beforeSpielkarte;
    private Spielkarte afterSpielkarte;
    private boolean istAuflegbar;

    public SpielRegelOhneSonderTest(Spielkarte beforeSpielkarte, Spielkarte afterSpielkarte, boolean istAuflegbar) {
        super();
        this.beforeSpielkarte = beforeSpielkarte;
        this.afterSpielkarte = afterSpielkarte;
        this.istAuflegbar = istAuflegbar;
    }

    /**
     * Testet ob die obigen Kombinationen das erwartete Ergebnis liefern
     * @throws MauMauException
     */
    @Test
    public void testIstKarteAuflegbarSuccess() throws MauMauException {

        Spielkarte davor = beforeSpielkarte;
        Spielkarte danach = afterSpielkarte;

        boolean antwort = spielRegelService.istKarteLegbar(davor, danach, null);

        assertEquals(istAuflegbar, antwort);
    }

    /**
     * Test für die gescheiterte Prüfung
     * @throws MauMauException
     */
    @Test(expected = MauMauException.class)
    public void testIstKarteAuflegbarFailed() throws MauMauException {

        Spielkarte davor = new Spielkarte(Blattwert.Bube, Blatttyp.Herz);
        Spielkarte danach = null;

        spielRegelService.istKarteLegbar(davor, danach, null);

    }




}
