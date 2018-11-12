package Komponenten.Spielregel.impl;

import Komponenten.Spielregel.export.ISpielregel;
import datenmodel.Enum.Blatttyp;
import datenmodel.Enum.Regel;
import datenmodel.Exceptions.MauMauException;
import datenmodel.HilfKlassen.RegelComponentUtil;
import datenmodel.Spieler;
import datenmodel.Spielkarte;

import java.util.List;

public class SpielregelOhneSonderImpl implements ISpielregel {


    public boolean istKarteLegbar(Spielkarte vorherigeSpielkarte, Spielkarte aktuelleSpielkarte, Blatttyp blatttyp) throws MauMauException {
        return false;
    }

    public RegelComponentUtil holeAuswirkungVonKarte(Spielkarte aktuelleSpielkarte, List<Spieler> spielerListe) throws MauMauException {
        return null;
    }

    public boolean pruefeObWuenscher(Spielkarte spielkarte) {
        return false;
    }
}
