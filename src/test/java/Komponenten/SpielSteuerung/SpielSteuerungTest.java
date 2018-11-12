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


    @Test
    public void testSollMauMauAufrufenLetzteKarte() {

        //Spieler hat nur noch eine Karte im Hand
        assertEquals(1, spieler1.getHand().size());

        assertTrue(spielSteuerung.sollMauMauAufrufen(spieler1));
    }

    @Test
    public void testSollMauMauAufrufenMehrAlsEineKarteImHand() {

        //Fügt eine neue Karte zum Hand
        spieler1.getHand().add(new Spielkarte(Blattwert.Fuenf, Blatttyp.Herz));

        //Checkt ob der Hand mehr als eine Karte hat
        assertTrue(spieler1.getHand().size() > 1);

        assertFalse(spielSteuerung.sollMauMauAufrufen(spieler1));
    }

    @Test
    public void testCheckZuziehendenKarten() {
        int anzahlZuZiehendeKarten = 0;

        spielrunde.setZuZiehnKartenAnzahl(anzahlZuZiehendeKarten);

        assertEquals(anzahlZuZiehendeKarten, spielSteuerung.checkZuZiehendenKarten(spielrunde));
    }

    @Test(expected = MauMauException.class)
    public void testfragWerDaranIstNurEinSpieler() {

        spielSteuerung.fragWerDaranIst();
    }

    @Test
    public void testfragWerDaranIstSpieler1Daran() {

        Spieler spieler2 = new Spieler(Collections.<Spielkarte>emptyList() , "spieler2", false);

        spielrunde.getSpielerListe().add(spieler2);

        assertEquals(spieler1, spielSteuerung.fragWerDaranIst());
    }

    @Test
    public void testSpieleKarteErlaubteKarte() throws MauMauException {

        Spielkarte aktuelleKarte = new Spielkarte(Blattwert.Fuenf, Blatttyp.Karo);

        Mockito.when(spielregel.istKarteLegbar(vorherigeKarte,aktuelleKarte, Mockito.any(Blatttyp.class))).thenReturn(true);

        assertTrue(spielSteuerung.spieleKarte(spieler1, aktuelleKarte));
    }

    @Test
    public void testSpieleKarteUnerlaubteKarte() throws MauMauException {

        Spielkarte aktuelleKarte = new Spielkarte(Blattwert.Sieben, Blatttyp.Karo);

        Mockito.when(spielregel.istKarteLegbar(vorherigeKarte,aktuelleKarte, Mockito.any(Blatttyp.class))).thenReturn(false);

        assertFalse(spielSteuerung.spieleKarte(spieler1, aktuelleKarte));
    }

    @Test
    public void testBestimmeBlatttyp() {

        Blatttyp gewuenschteBlatttyp = Blatttyp.Herz;

        assertNotEquals(gewuenschteBlatttyp, spielrunde.getRundeFarbe());

        spielSteuerung.bestimmeBlatttyp(gewuenschteBlatttyp);

        assertEquals(gewuenschteBlatttyp, spielrunde.getRundeFarbe());
    }

    @Test
    public void testZieheKartenVomStapel() {

        int anzahlZuZiehendeKarten = 2;

        int anzahlKartenImHand = spieler1.getHand().size();

        int anzahlKartenImVerdeckteStapel = spielrunde.getVerdeckteStapel().getStapel().size();

        assertEquals(anzahlKartenImHand + anzahlZuZiehendeKarten,
                spielSteuerung.zieheKartenVomStapel(spieler1, anzahlZuZiehendeKarten).getHand().size());

        assertEquals(anzahlKartenImVerdeckteStapel-anzahlZuZiehendeKarten,
                spielrunde.getVerdeckteStapel().getStapel().size());
    }


}
