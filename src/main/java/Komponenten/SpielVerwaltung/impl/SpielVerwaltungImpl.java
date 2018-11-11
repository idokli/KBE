package Komponenten.SpielVerwaltung.impl;

import Komponenten.SpielVerwaltung.export.ISpielVerwaltung;
import datenmodel.Enum.RegelKompTyp;
import datenmodel.Enum.SpielTyp;
import datenmodel.Spiel;
import datenmodel.Spieler;
import datenmodel.Spielrunde;


import java.util.List;

/**
 * Komponent, der ein Spiel verwaltet bzw. einzelne Spielrunde erstellt
 */
public class SpielVerwaltungImpl implements ISpielVerwaltung {


    public Spiel starteNeuesSpiel(SpielTyp spielTyp, RegelKompTyp regelKompTyp) {
        return null;
    }

    public Spielrunde starteSpielrunde(List<Spieler> spielerListe, Spiel spiel) {
        return null;
    }

    public Spiel beendeSpiel(Spiel spiel) {
        return null;
    }
}
