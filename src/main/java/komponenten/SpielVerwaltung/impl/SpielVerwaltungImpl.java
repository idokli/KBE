package komponenten.SpielVerwaltung.impl;

import komponenten.Karten.export.IKarten;
import komponenten.SpielVerwaltung.export.ISpielVerwaltung;
import datenmodel.Enum.RegelKompTyp;
import datenmodel.Enum.SpielTyp;
import datenmodel.Ergebnis;
import datenmodel.Exceptions.MauMauException;
import datenmodel.Spiel;
import datenmodel.Spieler;
import datenmodel.Spielrunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Komponent, der ein Spiel verwaltet bzw. einzelne Spielrunde erstellt
 */
@Service
public class SpielVerwaltungImpl implements ISpielVerwaltung {

    @Autowired
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

    public List<Ergebnis> beendeSpielrunde(Spielrunde spielrunde) throws MauMauException {
        return null;
    }

    public Spiel beendeSpiel(Spiel spiel) throws MauMauException {
        return null;
    }


}
