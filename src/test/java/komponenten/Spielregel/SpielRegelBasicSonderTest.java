package komponenten.Spielregel;

import komponenten.Spielregel.export.ISpielregel;
import komponenten.Spielregel.impl.SpielregelBasicSonderImpl;

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
public class SpielRegelBasicSonderTest {

    private static ISpielregel spielRegelService;

    @BeforeClass
    public static void initialize() {
        spielRegelService = new SpielregelBasicSonderImpl();
    }

    @Parameters
    public static Collection<Object[]> data() {
                // STANDARD REGEL
        Object[][] data = {{new Spielkarte(Blattwert.Acht, Blatttyp.Herz), new Spielkarte(Blattwert.Bube, Blatttyp.Herz), true},
                {new Spielkarte(Blattwert.Acht, Blatttyp.Herz), new Spielkarte(Blattwert.Acht, Blatttyp.Pik), true},
                {new Spielkarte(Blattwert.Acht, Blatttyp.Herz), new Spielkarte(Blattwert.Sieben, Blatttyp.Karo), false},
                {new Spielkarte(Blattwert.Zehn, Blatttyp.Kreuz), new Spielkarte(Blattwert.Dame, Blatttyp.Herz), false},

                // BASIC SONDERREGEL
                // Kombination ALLES_ZIEHEN --> true
                {new Spielkarte(Blattwert.Sieben, Blatttyp.Herz), new Spielkarte(Blattwert.Sieben, Blatttyp.Herz), true, null},
                // Kombination ZWEI_ZIEHEN --> false
                {new Spielkarte(Blattwert.Sieben, Blatttyp.Herz), new Spielkarte(Blattwert.Acht, Blatttyp.Herz), false, null},
                // Kombination ZWEI_ZIEHEN --> true
                {new Spielkarte(Blattwert.Sieben, Blatttyp.Herz), new Spielkarte(Blattwert.Sieben, Blatttyp.Herz), false, null},
                // Kombination AUSSETZEN --> immer false
                {new Spielkarte(Blattwert.Ass, Blatttyp.Herz), new Spielkarte(Blattwert.Zehn, Blatttyp.Herz), false, null},
                // Kombination WUENSCHER --> true
                {new Spielkarte(Blattwert.Bube, Blatttyp.Kreuz), new Spielkarte(Blattwert.Dame, Blatttyp.Herz), true, Blatttyp.Herz},
                // Kombination WUENSCHER --> false
                {new Spielkarte(Blattwert.Bube, Blatttyp.Kreuz), new Spielkarte(Blattwert.Dame, Blatttyp.Herz), false, Blatttyp.Karo}};
        return Arrays.asList(data);
    }

    private Spielkarte beforeSpielkarte;
    private Spielkarte afterSpielkarte;
    private boolean istAuflegbar;
    private Blatttyp gewuenschterBlatttyp;

    public SpielRegelBasicSonderTest(Spielkarte beforeSpielkarte, Spielkarte afterSpielkarte, boolean istAuflegbar, Blatttyp blatttyp) {
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
