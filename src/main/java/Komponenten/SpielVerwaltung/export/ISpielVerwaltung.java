package Komponenten.SpielVerwaltung.export;

import datenmodel.Enum.SpielTyp;
import datenmodel.Enum.Spielregel;
import datenmodel.Spiel;
import datenmodel.Spieler;

import java.util.List;

public interface ISpielVerwaltung {

    /**
     * Erstellt ein neues Spiel
     *
     * @return
     */
    Spiel starteNeuesSpiel(List<Spieler> spieler, SpielTyp spielTyp, Spielregel spielregel);
}
