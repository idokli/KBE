package komponenten.SpielSteuerung.export;

import datenmodel.Enum.Blatttyp;
import datenmodel.Exceptions.MauMauException;
import datenmodel.Spieler;
import datenmodel.Spielkarte;
import datenmodel.Spielrunde;
import komponenten.Spielregel.export.ISpielregel;

import java.util.List;


public interface ISpielSteuerung {

    /**
     * Gibt den Spieler, der in der Spielrunde daran ist (Spielend true)
     * @param spielerListe - Spielerliste von der Spielrunde
     * @return Spieler - der Spieler, der dran ist.
     * @throws MauMauException - wenn die Spielerliste weniger als 2 Spieler enthält oder wenn mehr als
     * ein Spieler die Attribute 'Spielend' true hat.
     */
    Spieler fragWerDaranIst(List<Spieler> spielerListe) throws MauMauException;

    /**
     * Prüft, ob der Spieler, der daran ist, Karten zu ziehen hat (wenn im Zug davor ein ZWEI_ZIEHEN gespielt wurde)
     *
     * @param spielrunde - jeweilige Spielrunde
     * @return - int - Anzhal der Karten, die zuziehen sind
     * @throws MauMauException - wenn Spielrunde nicht gesetzt wird
     */
    int checkZuZiehendenKarten(Spielrunde spielrunde) throws MauMauException;

    /**
     * Prüft ob Spielkarte auflegbar ist
     * Wenn ja wird die Karte vom Spielershand auf dem Aufgelegten Stapel gelegt und die Spielrundefarbe
     * wird neu gesetzt.
     * Wenn die Karte eine Sonderfunktion hat werden die Spielerliste und die Anzahl der zuzehenden Karten
     * in der Spielrunde aktualisiert.
     * @param spieler - der Spieler, der den Zug spielt
     * @param spielkarte - die gespielte Karte
     * @param spielrunde - die Spielrunde, in der der Zug gespielt wird
     * @param selectedSpielRegel - die vom Benutzer gewählte Spielregelkomponente Implementierung
     * @return boolean - Wenn die Karte legabar ist, wird true zurückgegeben, wenn nicht dann false
     * @throws MauMauException - Wenn Spieler oder Spielershand oder Spilekarte oder Spielrunde oder die ausgewählte
     * Rundefarbe oder Aufgelegter Stapel oder Spielregelkomponente null sind, wird die Exception geworfen.
     */
    boolean spieleKarte(Spieler spieler, Spielkarte spielkarte, Spielrunde spielrunde, ISpielregel selectedSpielRegel) throws MauMauException;

    /**
     * Prüft ob der Spieler MauMau aufrufen sollte
     *
     * @param spieler - Spieler, der daran ist
     * @return - boolean - True wenn der Spieler MauMau aufrufen solltest, sonst false.
     * @throws MauMauException - Wenn Spieler oder Spielershand null sind, oder Spielershand leer ist wird die
     * Exception geworfen werden.
     */
    boolean sollMauMauAufrufen(Spieler spieler) throws MauMauException;


    /**
     * Prüft ob die übergebene Spielkarte die Wünscher-Funktion besitzt
     * @param spielkarte - die gespielte Karte
     * @param selectedSpielRegel - die vom Benutzer gewählte Spielregelkomponente Implementierung
     * @return boolean - Wenn die Karte Wünscher ist, wird true zurückgegeben, sonst false
     * @throws MauMauException - Wenn Spielkarte oder Spielregelkomponente null sind, wird die Exception geworfen.
     */
    boolean pruefeObWuenscher(Spielkarte spielkarte, ISpielregel selectedSpielRegel) throws MauMauException;

    /**
     * Der Spieler wählt einen Blatttyp und es wird in der Spielrunde festgelegt
     * @param blatttyp - vom Benutzer ausgewählter Blatttyp
     * @param spielrunde - die gespielte Spielrunde
     * @throws MauMauException - Wenn Blatttyp oder Spielrunde null sind, wird die Exception geworfen.
     */
    void bestimmeBlatttyp(Blatttyp blatttyp, Spielrunde spielrunde) throws MauMauException;

    /**
     * Der Spieler zieht Karten vom  verdeckten Stapel
     * Falls verdeckter Stapel nicht genug Karten enthält, wird der verdeckte Stapel mit den Karten vom
     * aufgelegten Stapel befüllt.
     * @param spieler - der Spieler, der Karten zieht
     * @param anzahlKarten - Anzahl der Karten, die gezogen werden sollen.
     * @param spielrunde - die gespielte Spielrunde
     * @return Spieler - der Spieler mit dem aktualisierten Hand.
     * @throws MauMauException - Wenn Spieler oder Spielershand oder Spielrunde oder verdeckter und aufgelegter Stapel
     * null sind, wird die Exception geworfen.
     */
    Spieler zieheKartenVomStapel(Spieler spieler, int anzahlKarten, Spielrunde spielrunde) throws MauMauException;

}
