package Komponenten.SpielregelKomponent.impl;

import Komponenten.SpielregelKomponent.export.ISpielregel;
import datenmodel.Enum.Regel;
import datenmodel.Spielkarte;

public class SpielregelBasicSonderImpl implements ISpielregel {
    public Regel getRegelFuerKarte(Spielkarte spielkarte) {
        switch (spielkarte.getBlattwert()){
            case Acht:
                return Regel.AUSSETZEN;
            case Sieben:
                return Regel.ZWEI_ZIEHEN;
            case Bube:
                return Regel.WUENSCHER;
            default:
                return Regel.KEIN;
        }
    }

    public boolean istKarteAuflegbar(Spielkarte vorherigeSpielkarte, Spielkarte aktuelleSpielkarte) {
        return false;
    }
}
