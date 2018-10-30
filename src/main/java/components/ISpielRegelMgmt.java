package components;

import datenmodel.Blattwert;
import datenmodel.Regel;

public interface ISpielRegelMgmt {


    /**
     * Spielregel wird mit einem Blattwert definiert
     * @param blattwert
     */
    void setzteSpielregel(Regel regel, Blattwert blattwert);

    /**
     * Nächster Spieler muss entweder 2 Karten ziehen oder noch ein "Zwei-Ziehen" spielen
     */
    void useZweiZiehen();

    /**
     * Nächster Spieler wird ausgesetzt
     */
    void userAussetzen();

    /**
     * Spieler darfst sich einen Blatttyp aussuchen
     */
    void userWuenscher();

    /**
     * Spielrichtung wird gewechselt
     */
    void userRichtungswechsel();

    /**
     * Spieler kann die Funktion "zwei-ziehen" stoppen
     */
    void useStopper();

    /**
     * Spieler darf die Allesleger-karte immer spielen
     */
    void userAllesleger();


}
