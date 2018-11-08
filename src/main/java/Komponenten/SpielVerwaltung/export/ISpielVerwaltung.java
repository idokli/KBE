package Komponenten.SpielVerwaltung.export;

import datenmodel.Enum.SpielTyp;
import datenmodel.Enum.RegelKompTyp;
import datenmodel.Spiel;
import datenmodel.Spieler;

import java.util.List;

public interface ISpielVerwaltung {

    /**
     * Erstellt ein neues Spiel
     *
     * @return
     */
    Spiel starteNeuesSpiel(List<Spieler> spieler, SpielTyp spielTyp, RegelKompTyp regelKompTyp);

    /**
     * Berechnet Dauer des Spiels
     * @param spiel
     */
    Spiel beendeSpiel(Spiel spiel);
}
