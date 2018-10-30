package components;

import datenmodel.Ergebnis;
import datenmodel.Spiel;
import datenmodel.Spieler;
import datenmodel.Spielrunde;

import java.util.List;

public interface ISpielMgmt {

    /**
     * Holt ein neues Spiel
     * @return
     */
    Spiel getNeuesSpiel();

    /**
     * Neue Runde wird erstellt
     * @return
     */
    Spielrunde starteNeueRunde();

    /**
     * Spieler werden in der Runde registriert (da in jeder Runde Spieler aussteigen können)
     * @param spielrunde
     * @param spielerListe
     */
    void registriereSpielerInRunde(Spielrunde spielrunde, List<Spieler> spielerListe);


    /**
     * Spiel wählt random einen Spieler
     * @param spielerListe
     * @return
     */
    Spieler waehleErsterSpieler(List<Spieler> spielerListe);


    /**
     * Ergebnisse werden aus den Handkarten der Spieler berechnet
     * @param spielers
     * @return
     */
    List<Ergebnis> berechneErgebnisRunde(List<Spieler> spielers);


    /**
     * Spielrune wird beendet
     * @param spielrunde
     */
    void beendeRunde(Spielrunde spielrunde);
}
