package Komponenten.SpielKomponent.impl;

import Komponenten.SpielKomponent.export.ISpielKomponent;
import datenmodel.*;

import java.util.List;

public class SpielKomponentImpl implements ISpielKomponent {

    public Spiel starteNeuesSpiel(List<Spieler> spieler) {
        return null;
    }

    public boolean spieleKarte(Spieler spieler, Spielkarte spielkarte) {
        return false;
    }

    public boolean checkZuziehndenKarten(Spielrunde spielrunde) {
        return false;
    }

    public boolean sollMauAufgerufen(Spieler spieler) {
        return false;
    }

    public List<Spielkarte> zieheKartenVomStapel(Spieler spieler, int anzahlKarten) {
        return null;
    }

    public Spiel beendeSpiel(Spiel spiel) {
        return null;
    }

    /**
     * Erstellt im Spiel eine Spielrunde
     *
     * @param Spiel
     */
    private Spiel erstelleRunde(Spiel Spiel) {
      return null;
    }

    /**
     Registriert Spieler auf der Spielrunde
     * @param spieler
     * @param spielrunde
     */
    private Spielrunde registriereSpieler(Spieler spieler, Spielrunde spielrunde) {
      return null;
    }

    private Spielrunde erstellverdeckteStapel(Spielrunde spielrunde){
        return null;
    }

    /**
     * Verteilt initiale Spielkarten an den Spieler bzw. erstellt die Kartenhand
     * @param spielerListe
     * @param spielrunde
     * @return List<Spieler>;
     */
    private List<Spieler> kartenverteilen(List<Spieler> spielerListe, Spielrunde spielrunde){
        return null;
    }

    /**
     * Sucht sich einen Spieler random aus. "spielend" wird auf true gesetzt
     * @param spielerliste
     */
    private Spieler waehleErsterSpieler(List<Spieler> spielerliste){
        return null;
    }

    private Spielrunde legErsteKarteAuf(Spielrunde spielrunde){
        return null;
    }

    /**
     * Prüft ob eine Spielkarte abgelegt werden kann
     * @param spielkarte
     * @param aufgelegteKarten
     * @return boolean
     */
    private boolean pruefeObKarteAblegbar(Spielkarte spielkarte, KartenStapel aufgelegteKarten){
        return false;
    }

    /**
     * Berechnet aus der Kartenhand jedes Spielers die Punkte und setzte den Gewinnername
     * @param spielrunde
     */
    private Spielrunde berechneErgebnisse(Spielrunde spielrunde){
        return null;
    }




}