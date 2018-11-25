package komponenten.SpielVerwaltung.export;

import datenmodel.Enum.SpielTyp;
import datenmodel.Enum.RegelKompTyp;
import datenmodel.Ergebnis;
import datenmodel.Exceptions.MauMauException;
import datenmodel.Spiel;
import datenmodel.Spieler;
import datenmodel.Spielrunde;

import java.util.List;

public interface ISpielVerwaltung {

    /**
     * Erstellt ein neues Spiel mit dem übergebenen Spieltyp und Regelkomponententyp
     * @param spielTyp
     * @param regelKompTyp
     * @return
     * @throws MauMauException
     */
    Spiel starteNeuesSpiel(SpielTyp spielTyp, RegelKompTyp regelKompTyp) throws MauMauException;

    /**
     * Erstellt eine Spielrunde und registriert die Spieler in der Spielrunde
     * @param spielerListe
     * @param spiel
     * @return
     * @throws MauMauException
     */
    Spielrunde starteSpielrunde(List<Spieler> spielerListe, Spiel spiel) throws MauMauException;


    /**
     * Beendet eine Spielrunde bzw. berechnet die Ergebnisse aller Spieler je nach Kartenhand
     * @param spielrunde
     * @return
     * @throws MauMauException
     */
    List<Ergebnis> beendeSpielrunde(Spielrunde spielrunde) throws MauMauException;

    /**
     * Beendet ein Spiel und berechnet die Dauer des Spiels
     * @param spiel
     * @return
     * @throws MauMauException
     */
    Spiel beendeSpiel(Spiel spiel) throws MauMauException;
}
