package Komponenten.Spielregel.impl;

import Komponenten.Spielregel.export.ISpielregel;
import datenmodel.Enum.Regel;
import datenmodel.Spielkarte;

public class SpielregelOhneSonderImpl implements ISpielregel {
    public Regel getRegelFuerKarte(Spielkarte spielkarte) {
        return Regel.KEIN;
    }

    public boolean istKarteAuflegbar(Spielkarte vorherigeSpielkarte, Spielkarte aktuelleSpielkarte) {
        return false;
    }
}
