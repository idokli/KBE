package komponenten.spielSteuerung.export;

import datenmodel.Enum.Blatttyp;
import datenmodel.Exceptions.MauMauException;
import datenmodel.Spieler;
import datenmodel.Spielkarte;
import datenmodel.Spielrunde;
import komponenten.spielregel.export.ISpielregel;

import java.util.List;


public interface ISpielSteuerung {

    /**
     * Gibt den Spieler, der in der Spielrunde dran ist (Spielend true)
     * @param spielerListe - Spielerliste der Spielrunde
     * @return Spieler - der Spieler, der dran ist.
     * @throws MauMauException - wenn die Spielerliste weniger als 2 Spieler enthält, oder wenn mehr als
     * ein Spieler die Attribute 'Spielend' true hat.
     */
    Spieler fragWerDranIst(List<Spieler> spielerListe) throws MauMauException;

    /**
     * Prüft, ob der Spieler, der dran ist, karten zu ziehen hat (wenn im Zug davor ein ZWEI_ZIEHEN gespielt wurde)
     *
     * @param spielrunde - jeweilige Spielrunde
     * @return - int - Anzahl der karten, die zu ziehen sind
     * @throws MauMauException - wenn Spielrunde nicht gesetzt wird
     */
    int checkZuZiehendenKarten(Spielrunde spielrunde) throws MauMauException;

    /**
     * Prüft ob Spielkarte auflegbar ist
     * Wenn ja, wird die Karte von der Hand des Spielers auf den Aufgelegten Stapel gelegt und die Spielrundefarbe
     * wird neu gesetzt.
     * Wenn die Karte eine Sonderfunktion hat, werden die Spielerliste und die Anzahl der zu ziehenden karten
     * in der Spielrunde aktualisiert.
     * @param spieler - der Spieler, der den Zug spielt
     * @param spielkarte - die gespielte Karte
     * @param spielrunde - die Spielrunde, in der der Zug gespielt wird
     * @param selectedSpielRegel - die vom Benutzer gewählte Spielregelkomponente Implementierung
     * @return boolean - Wenn die Karte spielbar ist, wird true zurückgegeben, wenn nicht dann false
     * @throws MauMauException - Wenn Spieler oder Spielershand oder Spielkarte oder Spielrunde oder die ausgewählte
     * Rundenfarbe oder Aufgelegter Stapel oder Spielregelkomponente null sind, wird die Exception geworfen.
     */
    boolean spieleKarte(Spieler spieler, Spielkarte spielkarte, Spielrunde spielrunde, ISpielregel selectedSpielRegel) throws MauMauException;

    /**
     * Prüft, ob der Spieler MauMau aufrufen sollte
     *
     * @param spieler - Spieler, der dran ist
     * @return - boolean - True, wenn der Spieler MauMau aufrufen sollte, sonst false.
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
     * Der Spieler zieht karten vom verdeckten Stapel
     * Falls verdeckter Stapel nicht genug karten enthält, wird der verdeckte Stapel mit den karten vom
     * aufgelegten Stapel befüllt.
     * @param spieler - der Spieler, der karten zieht
     * @param anzahlKarten - Anzahl der karten, die gezogen werden sollen.
     * @param spielrunde - die gespielte Spielrunde
     * @return Spieler - der Spieler mit der aktualisierten Hand.
     * @throws MauMauException - Wenn Spieler oder Spielershand oder Spielrunde oder verdeckter und aufgelegter Stapel
     * null sind, wird die Exception geworfen.
     */
    Spieler zieheKartenVomStapel(Spieler spieler, int anzahlKarten, Spielrunde spielrunde) throws MauMauException;

}
