package komponenten.SpielSteuerung.export;

import datenmodel.Enum.Blatttyp;
import datenmodel.Exceptions.MauMauException;
import datenmodel.Spieler;
import datenmodel.Spielkarte;
import datenmodel.Spielrunde;
import komponenten.Spielregel.export.ISpielregel;

import java.util.List;


public interface ISpielSteuerung {

    //TODO change Java Doc

    /**
     * Gibt den Spieler, der in der Spielrunde daran ist
     *
     * @return
     * @throws MauMauException
     */
    Spieler fragWerDaranIst(List<Spieler> spielerListe) throws MauMauException;

    /**
     * Prüft, ob der Spieler, der daran ist, Karten zu ziehen hat (wenn im Zug davor ein ZWEI_ZIEHEN gespielt wurde)
     *
     * @param spielrunde
     * @return
     * @throws MauMauException
     */
    int checkZuZiehendenKarten(Spielrunde spielrunde) throws MauMauException;

    /**
     * Prüft ob Spielkarte auflegbar ist
     *
     * @param spieler
     * @param spielkarte
     * @return
     * @throws MauMauException
     */
    boolean spieleKarte(Spieler spieler, Spielkarte spielkarte, Spielrunde spielrunde, ISpielregel selectedSpielRegel) throws MauMauException;

    /**
     * Prüft ob der Spieler, der daran ist, MauMau aufrufen sollte
     *
     * @param spieler
     * @return
     * @throws MauMauException
     */
    boolean sollMauMauAufrufen(Spieler spieler) throws MauMauException;


    /**
     * Prüft ob die übergebene Spielkarte die Wünscher-Funktion besitzt
     *
     * @return
     * @throws MauMauException
     */
    boolean pruefeObWuenscher(Spielkarte spielkarte, ISpielregel selectedSpielRegel) throws MauMauException;

    /**
     * Der Spieler wählt einen Blatttyp und wird in der Spielrunde festgelegt
     *
     * @param blatttyp
     * @throws MauMauException
     */
    void bestimmeBlatttyp(Blatttyp blatttyp, Spielrunde spielrunde) throws MauMauException;

    /**
     * Der Spieler zieht Karten vom Stapel
     * @param spieler
     * @param anzahlKarten
     * @return List<Spielkarte>
     * @throws MauMauException
     * @return
     */
    Spieler zieheKartenVomStapel(Spieler spieler, int anzahlKarten, Spielrunde spielrunde) throws MauMauException;

}
