package komponenten.spielregel;

import datenmodel.Enum.Blatttyp;
import datenmodel.Enum.Blattwert;
import datenmodel.Exceptions.MauMauException;
import datenmodel.HilfKlassen.RegelComponentUtil;
import datenmodel.Spieler;
import datenmodel.Spielkarte;
import komponenten.spielregel.export.ISpielregel;
import komponenten.spielregel.impl.SpielregelAlleSonderImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class SpielRegelAlleSonderTest extends SpielRegelTestBase {

    private static ISpielregel spielRegelService;

    @BeforeClass
    public static void initialize() {
        spielRegelService = new SpielregelAlleSonderImpl();
    }

    @RunWith(Parameterized.class)
    public static class ParmeterizedPart {
        @Parameters
        public static Collection<Object[]> data() {
            return getDataAlleSonder();
        }

        private Spielkarte beforeSpielkarte;
        private Spielkarte afterSpielkarte;
        private boolean istAuflegbar;
        private Blatttyp blatttyp;

        public ParmeterizedPart(Spielkarte beforeSpielkarte, Spielkarte afterSpielkarte, boolean istAuflegbar, Blatttyp blatttyp) {
            super();
            this.beforeSpielkarte = beforeSpielkarte;
            this.afterSpielkarte = afterSpielkarte;
            this.istAuflegbar = istAuflegbar;
            this.blatttyp = blatttyp;
        }

        /**
         * Testet ob die obigen Kombinationen das erwartete Ergebnis liefern
         *
         * @throws MauMauException
         */
        @Test
        public void testIstKarteAuflegbarSuccess() throws MauMauException {
            boolean legbar = istKarteLegbar(spielRegelService, beforeSpielkarte, afterSpielkarte, blatttyp);
            assertEquals(istAuflegbar,legbar);
        }
    }

    public static class NotParameteriedPart {

        @Test
        public void testPruefeObWuenscherTrue() throws MauMauException {
            boolean istWuenscher = istKarteWuenscher(spielRegelService, new Spielkarte(Blattwert.Bube, Blatttyp.Herz));
            assertTrue(istWuenscher);
        }

        @Test
        public void testPruefeObWuenscherFalse() throws MauMauException {
            boolean istWuenscher = istKarteWuenscher(spielRegelService, new Spielkarte(Blattwert.Sechs, Blatttyp.Herz));
            assertFalse(istWuenscher);
        }

        @Test(expected = MauMauException.class)
        public void testPruefeObWuenscherFailed() throws MauMauException {
            istKarteWuenscher(spielRegelService, null);
        }

        @Test(expected = MauMauException.class)
        public void testIstKarteAuflegbarFailed() throws MauMauException {
            istKarteLegbar(spielRegelService, null, null, null);
        }

        @Test(expected = MauMauException.class)
        public void testHoleAuswirkungFailed() throws MauMauException {
            holeAuswirkungenFailed(spielRegelService);
        }


        /**
         * Test für den Fall von ein 9 bzw. Richtungswechsel-Regel
         *
         * @throws MauMauException
         */
        @Test
        public void testHoleAuswirkungenRichtungswechsel() throws MauMauException {
            List<Spieler> spielerListe = getDefaultSpielerListe();
            Spielkarte spielkarte = new Spielkarte(Blattwert.Neun, Blatttyp.Herz);
            RegelComponentUtil util = spielRegelService.holeAuswirkungVonKarte(spielkarte, spielerListe);
            assertNotNull(util);
            assertEquals(0, util.getAnzahlKartenZuZiehen());
            assertTrue(util.getSpielerListe().get(spielerListe.size()-1).isSpielend());
        }

        /**
         * Test für den Fall von ein 8 bzw. Stopper-Regel
         *
         * @throws MauMauException
         */
        @Test
        public void testHoleAuswirkungenStopper() throws MauMauException {
            List<Spieler> spielerListe = getDefaultSpielerListe();
            Spielkarte spielkarte = new Spielkarte(Blattwert.Acht, Blatttyp.Herz);
            RegelComponentUtil util = spielRegelService.holeAuswirkungVonKarte(spielkarte, spielerListe);
            assertNotNull(util);
            assertEquals(0, util.getAnzahlKartenZuZiehen());
            assertTrue(util.getSpielerListe().get(1).isSpielend());
        }

        /**
         * Test für den Fall von ein 10 bzw. Allesleger-Regel
         *
         * @throws MauMauException
         */
        @Test
        public void testHoleAuswirkungenAllesleger() throws MauMauException {
            List<Spieler> spielerListe = getDefaultSpielerListe();
            Spielkarte spielkarte = new Spielkarte(Blattwert.Zehn, Blatttyp.Herz);
            RegelComponentUtil util = spielRegelService.holeAuswirkungVonKarte(spielkarte, spielerListe);
            assertNotNull(util);
            assertEquals(0, util.getAnzahlKartenZuZiehen());
            assertTrue(util.getSpielerListe().get(1).isSpielend());
        }
    }
}
