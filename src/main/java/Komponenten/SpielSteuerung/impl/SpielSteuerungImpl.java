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
    }

    public int checkZuZiehendenKarten(Spielrunde spielrunde) {
        return 0;
    }

    public boolean spieleKarte(Spieler spieler, Spielkarte spielkarte) {
        return false;
    }

    public boolean sollMauMauAufrufen(Spieler spieler) {
        return false;
    }

    public boolean pruefeObWuenscher(Spielkarte spielkarte) {
        return false;
    }

    public void bestimmeBlatttyp(Blatttyp blatttyp) { }

    public Spieler zieheKartenVomStapel(Spieler spieler, int anzahlKarten) {
        return null;
    }
}
