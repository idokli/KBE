package Komponenten.SpielSteuerung.impl;

import Komponenten.SpielSteuerung.export.ISpielSteuerung;
import Komponenten.SpielVerwaltung.impl.SpielVerwaltungImpl;
import Komponenten.Spielregel.impl.SpielregelOhneSonderImpl;
import datenmodel.*;
import datenmodel.Enum.Blatttyp;

import java.util.List;

/**
 * Komponent, der eine Spielrunde steuert
 */
public class SpielSteuerungImpl implements ISpielSteuerung {

    public Spieler fragWerDaranIst() {
        return null;
    }

    public int checkZuziehendenKarten(Spielrunde spielrunde) {
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

    public void bestimmeBlatttyp(Blatttyp blatttyp) {

    }

    public List<Spielkarte> zieheKartenVomStapel(Spieler spieler, int anzahlKarten) {
        return null;
    }
}
