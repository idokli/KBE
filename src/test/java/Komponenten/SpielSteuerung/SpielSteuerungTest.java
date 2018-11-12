package Komponenten.SpielSteuerung;

import Komponenten.SpielSteuerung.export.ISpielSteuerung;
import Komponenten.SpielSteuerung.impl.SpielSteuerungImpl;
import Komponenten.Spielregel.export.ISpielregel;
import datenmodel.Enum.Blatttyp;
import datenmodel.Enum.Blattwert;
import datenmodel.Exceptions.MauMauException;
import datenmodel.KartenStapel;
import datenmodel.Spieler;
import datenmodel.Spielkarte;
import datenmodel.Spielrunde;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SpielSteuerungTest {

    private static ISpielSteuerung spielSteuerung;
    private static Spieler spieler1;
    private static Spielrunde spielrunde;
    private static Spielkarte vorherigeKarte;

    @Mock
    private ISpielregel spielregel;


    @BeforeClass
    public static void initialize() {
        spielSteuerung = new SpielSteuerungImpl(spielrunde);

        List<Spielkarte> hand = Arrays.asList(new Spielkarte(Blattwert.Drei, Blatttyp.Herz));
        spieler1 = new Spieler(hand, "spieler1", true);

        spielrunde = new Spielrunde();
        spielrunde.setSpielerListe(Arrays.asList(spieler1));
        spielrunde.setRundeFarbe(Blatttyp.Pik);

        vorherigeKarte = new Spielkarte(Blattwert.Fuenf, Blatttyp.Herz);

        KartenStapel verdeckterStapel = new KartenStapel();
        verdeckterStapel.setStapel(Arrays.asList(new Spielkarte(Blattwert.Drei, Blatttyp.Herz),
                new Spielkarte(Blattwert.Fuenf, Blatttyp.Karo), new Spielkarte(Blattwert.Dame, Blatttyp.Karo)));

        spielrunde.setVerdeckteStapel(verdeckterStapel);


    }

    /**
     * Wenn ein Spieler eine Karte im Hand hat soll MauMau aufgerufen werden
     * @throws MauMauException
     */
    @Test
    public void testSollMauMauAufrufenLetzteKarte() throws MauMauException {

        //Spieler hat nur noch eine Karte im Hand
        assertEquals(1, spieler1.getHand().size());

        assertTrue(spielSteuerung.sollMauMauAufrufen(spieler1));
    }

    /**
     * Wenn ein Spieler mehr als eine Karte im Hand hat soll MauMau nicht aufgerufen werden
     * @throws MauMauException
     */
    @Test
    public void testSollMauMauAufrufenMehrAlsEineKarteImHand() throws MauMauException {

        //Fügt eine neue Karte zum Hand
        spieler1.getHand().add(new Spielkarte(Blattwert.Fuenf, Blatttyp.Herz));

        //Checkt ob der Hand mehr als eine Karte hat
        assertTrue(spieler1.getHand().size() > 1);

        assertFalse(spielSteuerung.sollMauMauAufrufen(spieler1));
    }

    /**
     * Check wie viele Karten soll vom verdeckten Stapel gezogen werden
     * @throws MauMauException
     */
    @Test
    public void testCheckZuziehendenKarten() throws MauMauException {
        int anzahlZuZiehendeKarten = 0;

        spielrunde.setZuZiehnKartenAnzahl(anzahlZuZiehendeKarten);

        assertEquals(anzahlZuZiehendeKarten, spielSteuerung.checkZuZiehendenKarten(spielrunde));
    }

    /**
     * Wenn keiner oder nur ein Spieler in einer Spielrunde angemeldet ist, soll die Methode Exception werfen
     * @throws MauMauException
     */
    @Test(expected = MauMauException.class)
    public void testfragWerDaranIstNurEinSpieler() throws MauMauException {

        spielSteuerung.fragWerDaranIst();
    }

    /**
     * Wenn zwei Spieler oder mehr sind in einer Spielrunde angemeldet, soll den Spieler zurück gegeben werden,
     * der gerade daran ist.
     * @throws MauMauException
     */
    @Test
    public void testfragWerDaranIstSpieler1Daran() throws MauMauException {

        Spieler spieler2 = new Spieler(Collections.<Spielkarte>emptyList() , "spieler2", false);

        spielrunde.getSpielerListe().add(spieler2);

        assertEquals(spieler1, spielSteuerung.fragWerDaranIst());
    }

    /**
     * test ob die gespielte Karte anlegbar ist.
     * @throws MauMauException
     */
    @Test
    public void testSpieleKarteErlaubteKarte() throws MauMauException {

        Spielkarte aktuelleKarte = new Spielkarte(Blattwert.Fuenf, Blatttyp.Karo);

        Mockito.when(spielregel.istKarteLegbar(vorherigeKarte,aktuelleKarte, Mockito.any(Blatttyp.class))).thenReturn(true);

        assertTrue(spielSteuerung.spieleKarte(spieler1, aktuelleKarte));
    }

    /**
     * test ob die gespielte Karte anlegbar ist.
     * @throws MauMauException
     */
    @Test
    public void testSpieleKarteUnerlaubteKarte() throws MauMauException {

        Spielkarte aktuelleKarte = new Spielkarte(Blattwert.Sieben, Blatttyp.Karo);

        Mockito.when(spielregel.istKarteLegbar(vorherigeKarte,aktuelleKarte, Mockito.any(Blatttyp.class))).thenReturn(false);

        assertFalse(spielSteuerung.spieleKarte(spieler1, aktuelleKarte));
    }

    /**
     * test ob eine gewuenschte Blatttyp in der Spielrunde aktualisiert ist
     * @throws MauMauException
     */
    @Test
    public void testBestimmeBlatttyp() throws MauMauException {

        Blatttyp gewuenschteBlatttyp = Blatttyp.Herz;

        assertNotEquals(gewuenschteBlatttyp, spielrunde.getRundeFarbe());

        spielSteuerung.bestimmeBlatttyp(gewuenschteBlatttyp);

        assertEquals(gewuenschteBlatttyp, spielrunde.getRundeFarbe());
    }

    /**
     * test das Ziehen-Prozess vom verdeckten Stapel in den Hand
     * @throws MauMauException
     */
    @Test
    public void testZieheKartenVomStapel() throws MauMauException {

        int anzahlZuZiehendeKarten = 2;

        int anzahlKartenImHand = spieler1.getHand().size();

        int anzahlKartenImVerdeckteStapel = spielrunde.getVerdeckteStapel().getStapel().size();

        assertEquals(anzahlKartenImHand + anzahlZuZiehendeKarten,
                spielSteuerung.zieheKartenVomStapel(spieler1, anzahlZuZiehendeKarten).getHand().size());

        assertEquals(anzahlKartenImVerdeckteStapel-anzahlZuZiehendeKarten,
                spielrunde.getVerdeckteStapel().getStapel().size());
    }

    /**
     * test ob eine Karte ein Wuenscher ist
     * @throws MauMauException
     */
    @Test
    public void testPruefeObWuenscher() throws MauMauException {

        Mockito.when(spielregel.pruefeObWuenscher(Mockito.any(Spielkarte.class))).thenReturn(true);

        Spielkarte spielkarte = new Spielkarte(Blattwert.Bube, Blatttyp.Karo);

        boolean isWuenscher = spielSteuerung.pruefeObWuenscher(spielkarte);

        assertTrue(isWuenscher);
    }

    /**
     * test ob eine Karte ein Wuenscher ist
     * @throws MauMauException
     */
    @Test
    public void testPruefeObWuenscherNotWuenscher() throws MauMauException {

        Mockito.when(spielregel.pruefeObWuenscher(Mockito.any(Spielkarte.class))).thenReturn(false);

        Spielkarte spielkarte = new Spielkarte(Blattwert.Acht, Blatttyp.Karo);

        boolean isWuenscher = spielSteuerung.pruefeObWuenscher(spielkarte);

        assertFalse(isWuenscher);
    }


}
