package Komponenten.SpielSteuerung.impl;

import Komponenten.SpielSteuerung.export.ISpielSteuerung;
import datenmodel.*;
import datenmodel.Enum.Blatttyp;

/**
 * Komponent, der eine Spielrunde steuert
 */
public class SpielSteuerungImpl implements ISpielSteuerung {

    private Spielrunde spielrunde;

    public SpielSteuerungImpl(Spielrunde spielrunde){
        this.spielrunde = spielrunde;
    }

    public Spieler fragWerDaranIst() {
        return null;
    } //V

    public int checkZuZiehendenKarten(Spielrunde spielrunde) {
        return 0;
    } // V

    public boolean spieleKarte(Spieler spieler, Spielkarte spielkarte) {
        return false;
    } //V

    public boolean sollMauMauAufrufen(Spieler spieler) {
        return false;
    }  // V

    //eine neue Methode in Spielregel ist nötig
    public boolean pruefeObWuenscher(Spielkarte spielkarte) {
        return false;
    }

    //Signatur geändert
    public void bestimmeBlatttyp(Blatttyp blatttyp) { } // V

    public Spieler zieheKartenVomStapel(Spieler spieler, int anzahlKarten) {
        return null;
    }
}
