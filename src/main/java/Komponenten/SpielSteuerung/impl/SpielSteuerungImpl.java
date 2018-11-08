package Komponenten.SpielSteuerung.impl;

import Komponenten.SpielSteuerung.export.ISpielSteuerung;
import datenmodel.*;

import java.util.List;

public class SpielSteuerungImpl implements ISpielSteuerung {

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

    /**
     * Erstellt im Spiel eine Spielrunde
     *
     * @param Spiel
     */
    private Spiel erstelleRunde(Spiel Spiel) {
      return null;
    }

    /**
     Registriert SpielVerwaltung auf der Spielrunde
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
     * Verteilt initiale Spielkarten an den SpielVerwaltung bzw. erstellt die Kartenhand
     * @param spielerListe
     * @param spielrunde
     * @return List<SpielVerwaltung>;
     */
    private List<Spieler> kartenverteilen(List<Spieler> spielerListe, Spielrunde spielrunde){
        return null;
    }

    /**
     * Sucht sich einen SpielVerwaltung random aus. "spielend" wird auf true gesetzt
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
