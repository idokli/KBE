package Komponenten.SpielSteuerung.export;

import datenmodel.Enum.Blatttyp;
import datenmodel.Exceptions.MauMauException;
import datenmodel.Spieler;
import datenmodel.Spielkarte;
import datenmodel.Spielrunde;

import java.util.List;

public interface ISpielSteuerung {

    /**
     * Um bei der Spielsteuerung zu fragen, welcher Spieler daran ist
     * @return
     * @throws MauMauException
     */
    Spieler fragWerDaranIst() throws MauMauException;

    /**
     * Prüft, ob der Spieler, der daran ist, Karten zu ziehen hat
     * @param spielrunde
     * @return
     * @throws MauMauException
     */
    int checkZuziehendenKarten(Spielrunde spielrunde) throws MauMauException;

    /**
     * Prüft ob Spielkarte auflegbar ist
     * @param spieler
     * @param spielkarte
     * @return
     * @throws MauMauException
     */
    boolean spieleKarte(Spieler spieler, Spielkarte spielkarte) throws MauMauException;

    /**
     * Prüft ob der Spieler, der daran ist, Mau Mau aufrufen sollte
     * @param spieler
     * @return
     * @throws MauMauException
     */
    boolean sollMauMauAufrufen(Spieler spieler) throws MauMauException;


    /**
     * Prüft, ob der Spieler, der daran ist, sich einen Blatttyp aussuchen kann (wegen Regel "Wünscher")
     * @return
     * @throws MauMauException
     */
    boolean pruefeObWuenscher(Spielkarte spielkarte) throws MauMauException;

    /**
     * Der Spielerwünsch wird übergeben
     * @param blatttyp
     * @throws MauMauException
     */
    void bestimmeBlatttyp(Blatttyp blatttyp) throws MauMauException;

    /**
     * Spielsteuerung zieht eine Spielkarte vom Kartenstapel
     * @param spieler
     * @param anzahlKarten
     * @return List<Spielkarte>
     * @throws MauMauException
     */
    Spieler zieheKartenVomStapel(Spieler spieler, int anzahlKarten) throws MauMauException;

}
