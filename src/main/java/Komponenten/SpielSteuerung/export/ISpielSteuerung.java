package Komponenten.SpielSteuerung.export;

import datenmodel.Enum.Blatttyp;
import datenmodel.Spieler;
import datenmodel.Spielkarte;
import datenmodel.Spielrunde;

import java.util.List;

public interface ISpielSteuerung {

    /**
     * Um bei der Spielsteuerung zu fragen, welcher Spieler daran ist
     * @return
     */
    Spieler fragWerDaranIst();

    /**
     * Prüft, ob der Spieler, der daran ist, Karten zu ziehen hat
     * @param spielrunde
     * @return
     */
    int checkZuziehendenKarten(Spielrunde spielrunde);

    /**
     * Prüft ob Spielkarte auflegbar ist
     * @param spieler
     * @param spielkarte
     * @return
     */
    boolean spieleKarte(Spieler spieler, Spielkarte spielkarte);

    /**
     * Prüft ob der Spieler, der daran ist, Mau Mau aufrufen sollte
     * @param spieler
     * @return
     */
    boolean sollMauMauAufrufen(Spieler spieler);


    /**
     * Prüft, ob der Spieler, der daran ist, sich einen Blatttyp aussuchen kann (wegen Regel "Wünscher")
     * @return
     */
    boolean pruefeObWuenscher(Spielkarte spielkarte);

    /**
     * Der Spielerwünsch wird übergeben
     * @param blatttyp
     */
    Spielrunde bestimmeBlatttyp(Blatttyp blatttyp);

    /**
     * Spielsteuerung zieht eine Spielkarte vom Kartenstapel
     * @param spieler
     * @param anzahlKarten
     * @return List<Spielkarte>
     */
    Spieler zieheKartenVomStapel(Spieler spieler, int anzahlKarten);

}
