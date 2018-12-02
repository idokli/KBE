package komponenten.Spielregel;

import komponenten.Spielregel.export.ISpielregel;
import komponenten.Spielregel.impl.SpielregelAlleSonderImpl;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class SpielRegelAlleSonderTest {

    private static ISpielregel spielRegelService;

    @BeforeClass
    public static void initialize() {
        spielRegelService = new SpielregelAlleSonderImpl();
    }

    @Parameters
    public static Collection<Object[]> data() {
                 // STANDARD REGEL
        Object[][] data = {{new Spielkarte(Blattwert.Acht, Blatttyp.Herz), new Spielkarte(Blattwert.Bube, Blatttyp.Herz), true, null},
                {new Spielkarte(Blattwert.Acht, Blatttyp.Herz), new Spielkarte(Blattwert.Acht, Blatttyp.Pik), true, null},
                {new Spielkarte(Blattwert.Acht, Blatttyp.Herz), new Spielkarte(Blattwert.Sieben, Blatttyp.Karo), false, null},
                {new Spielkarte(Blattwert.Zehn, Blatttyp.Kreuz), new Spielkarte(Blattwert.Dame, Blatttyp.Herz), false, null},

                // BASIC SONDERREGEL
                // Kombination ZWEI_ZIEHEN-ZWEI_ZIEHEN--> true
                {new Spielkarte(Blattwert.Sieben, Blatttyp.Herz), new Spielkarte(Blattwert.Sieben, Blatttyp.Herz), true, null},
                // Kombination ZWEI_ZIEHEN-STOPPER --> true
                {new Spielkarte(Blattwert.Sieben, Blatttyp.Herz), new Spielkarte(Blattwert.Sechs, Blatttyp.Herz), false, null},
                // Kombination ZWEI_ZIEHEN --> true
                {new Spielkarte(Blattwert.Sieben, Blatttyp.Herz), new Spielkarte(Blattwert.Sieben, Blatttyp.Herz), true, null},
                // Kombination AUSSETZEN --> immer false
                {new Spielkarte(Blattwert.Ass, Blatttyp.Herz), new Spielkarte(Blattwert.Zehn, Blatttyp.Herz), false, null},
                // Kombination WUENSCHER --> true
                {new Spielkarte(Blattwert.Bube, Blatttyp.Kreuz), new Spielkarte(Blattwert.Dame, Blatttyp.Herz), true, Blatttyp.Herz},
                // Kombination WUENSCHER --> false
                {new Spielkarte(Blattwert.Bube, Blatttyp.Kreuz), new Spielkarte(Blattwert.Dame, Blatttyp.Herz), false, Blatttyp.Karo},

                // ## NEUE ##
                // Kombination RICHTUNGSWECHSEL (geht immer nach den normalen Regel)
                {new Spielkarte(Blattwert.Dame, Blatttyp.Kreuz), new Spielkarte(Blattwert.Neun, Blatttyp.Kreuz), true, null},
                // Kombination STOPPER --> true (auf ALLES_ZIEHEN)
                {new Spielkarte(Blattwert.Sieben, Blatttyp.Kreuz), new Spielkarte(Blattwert.Acht, Blatttyp.Kreuz), true, null},
                // Kombination STOPPER --> true (auf ALLES_ZIEHEN)
                {new Spielkarte(Blattwert.Sieben, Blatttyp.Kreuz), new Spielkarte(Blattwert.Acht, Blatttyp.Herz), true, null},
                // Kombination ALLESLEGER --> true
                {new Spielkarte(Blattwert.Sechs, Blatttyp.Kreuz), new Spielkarte(Blattwert.Sechs, Blatttyp.Herz), true, null},
                // Kombination ALLESLEGER --> false
                {new Spielkarte(Blattwert.Sieben, Blatttyp.Kreuz), new Spielkarte(Blattwert.Zehn, Blatttyp.Kreuz), false, null}};

        return Arrays.asList(data);
    }

    private Spielkarte beforeSpielkarte;
    private Spielkarte afterSpielkarte;
    private boolean istAuflegbar;
    private Blatttyp gewuenschterBlatttyp;

    public SpielRegelAlleSonderTest(Spielkarte beforeSpielkarte, Spielkarte afterSpielkarte, boolean istAuflegbar, Blatttyp blatttyp) {
        super();
        this.beforeSpielkarte = beforeSpielkarte;
        this.afterSpielkarte = afterSpielkarte;
        this.istAuflegbar = istAuflegbar;
        this.gewuenschterBlatttyp = blatttyp;
    }

    /**
     * Testet ob die obigen Kombinationen das erwartete Ergebnis liefern
     *
     * @throws MauMauException
     */
    @Test
    public void testIstKarteAuflegbarSuccess() throws MauMauException {

        Spielkarte davor = beforeSpielkarte;
        Spielkarte danach = afterSpielkarte;
        Blatttyp bt = gewuenschterBlatttyp;

        boolean antwort = spielRegelService.istKarteLegbar(davor, danach, gewuenschterBlatttyp);

        assertEquals(istAuflegbar, antwort);
    }

    /**
     * Test für die gescheiterte Prüfung
     *
     * @throws MauMauException
     */
    @Test(expected = MauMauException.class)
    public void testIstKarteAuflegbarFailed() throws MauMauException {

        Spielkarte davor = new Spielkarte(Blattwert.Bube, Blatttyp.Herz);
        Spielkarte danach = null;

        spielRegelService.istKarteLegbar(davor, danach, null);

    }
}
