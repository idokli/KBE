package Komponenten.SpielSteuerung.export;

import datenmodel.Enum.Blatttyp;
import datenmodel.Spieler;
import datenmodel.Spielkarte;
import datenmodel.Spielrunde;


public interface ISpielSteuerung {

    /**
     * Gibt den Spieler, der in der Spielrunde daran ist
     *
     * @return
     */
    Spieler fragWerDaranIst();

    /**
     * Prüft, ob der Spieler, der daran ist, Karten zu ziehen hat (wenn im Zug davor ein ZWEI_ZIEHEN gespielt wurde)
     *
     * @param spielrunde
     * @return
     */
    int checkZuZiehendenKarten(Spielrunde spielrunde);

    /**
     * Prüft ob Spielkarte auflegbar ist
     *
     * @param spieler
     * @param spielkarte
     * @return
     */
    boolean spieleKarte(Spieler spieler, Spielkarte spielkarte);

    /**
     * Prüft ob der Spieler, der daran ist, MauMau aufrufen sollte
     *
     * @param spieler
     * @return
     */
    boolean sollMauMauAufrufen(Spieler spieler);


    /**
     * Prüft ob die übergebene Spielkarte die Wünscher-Funktion besitzt
     *
     * @return
     */
    boolean pruefeObWuenscher(Spielkarte spielkarte);

    /**
     * Der Spieler wählt einen Blatttyp und wird in der Spielrunde festgelegt
     *
     * @param blatttyp
     */
    void bestimmeBlatttyp(Blatttyp blatttyp);

    /**
     * Der Spieler zieht Karten vom Stapel
     * @param spieler
     * @param anzahlKarten
     * @return
     */
    Spieler zieheKartenVomStapel(Spieler spieler, int anzahlKarten);

}
