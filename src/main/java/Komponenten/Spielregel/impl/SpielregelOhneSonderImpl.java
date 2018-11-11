package Komponenten.Spielregel.impl;

import Komponenten.Spielregel.export.ISpielregel;
import datenmodel.Enum.Regel;
import datenmodel.HilfKlassen.RegelComponentUtil;
import datenmodel.Spieler;
import datenmodel.Spielkarte;

import java.util.List;

public class SpielregelOhneSonderImpl implements ISpielregel {


    public boolean istKarteLegbar(Spielkarte vorherigeSpielkarte, Spielkarte aktuelleSpielkarte) {
        return false;
    }

    public RegelComponentUtil holeAuswirkungVonKarte(Spielkarte aktuelleSpielkarte, List<Spieler> spielerListe) {
        return null;
    }
}
