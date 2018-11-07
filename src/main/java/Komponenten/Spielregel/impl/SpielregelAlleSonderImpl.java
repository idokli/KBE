package Komponenten.Spielregel.impl;

import Komponenten.Spielregel.export.ISpielregel;
import datenmodel.Enum.Regel;
import datenmodel.Spielkarte;

public class SpielregelAlleSonderImpl implements ISpielregel {

    public Regel getRegelFuerKarte(Spielkarte spielkarte) {
        switch (spielkarte.getBlattwert()){
            case Acht:
                return Regel.AUSSETZEN;
            case Sieben:
                return Regel.ZWEI_ZIEHEN;
            case Bube:
                return Regel.WUENSCHER;
            case Neun:
                return Regel.RICHTUNGSWECHSEL;
            case Ass:
                return Regel.STOPPER;
            case Zehn:
                return Regel.ALLESLEGER;
            default:
                return Regel.KEIN;
        }    }

    public boolean istKarteAuflegbar(Spielkarte vorherigeSpielkarte, Spielkarte aktuelleSpielkarte) {
        return false;
    }
}
