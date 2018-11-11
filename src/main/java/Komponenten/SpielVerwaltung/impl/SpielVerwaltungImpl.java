package Komponenten.SpielVerwaltung.impl;

import Komponenten.Karten.export.IKarten;
import Komponenten.SpielVerwaltung.export.ISpielVerwaltung;
import datenmodel.Enum.RegelKompTyp;
import datenmodel.Enum.SpielTyp;
import datenmodel.Exceptions.MauMauException;
import datenmodel.Spiel;
import datenmodel.Spieler;
import datenmodel.Spielrunde;


import java.util.List;

/**
 * Komponent, der ein Spiel verwaltet bzw. einzelne Spielrunde erstellt
 */
public class SpielVerwaltungImpl implements ISpielVerwaltung {

    private IKarten kartenService;

    public SpielVerwaltungImpl(IKarten kartenService) {
        super();
        this.kartenService = kartenService;
    }

    public Spiel starteNeuesSpiel(SpielTyp spielTyp, RegelKompTyp regelKompTyp) throws MauMauException {
        return null;
    }

    public Spielrunde starteSpielrunde(List<Spieler> spielerListe, Spiel spiel) throws MauMauException {
        return null;
    }

    public Spiel beendeSpiel(Spiel spiel) throws MauMauException {
        return null;
    }


}
