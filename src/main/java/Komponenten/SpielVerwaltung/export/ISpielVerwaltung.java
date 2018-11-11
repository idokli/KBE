package Komponenten.SpielVerwaltung.export;

import datenmodel.Enum.SpielTyp;
import datenmodel.Enum.RegelKompTyp;
import datenmodel.Spiel;
import datenmodel.Spieler;
import datenmodel.Spielrunde;

import java.util.List;

public interface ISpielVerwaltung {

    /**
     * Erstellt ein neues Spiel mit dem übergebenen Spieltyp und Regelkomponententyp
     *
     * @return
     */
    Spiel starteNeuesSpiel(SpielTyp spielTyp, RegelKompTyp regelKompTyp);

    /**
     * Erstelle eine Spielrunde und registriert die Spiele in der Runde
     * @param spielerListe
     * @param spiel
     * @return
     */
    Spielrunde starteSpielrunde(List<Spieler> spielerListe, Spiel spiel);

    /**
     * Beende ein Spiel und berechnet Dauer des Spiels
     * @param spiel
     */
    Spiel beendeSpiel(Spiel spiel);
}
