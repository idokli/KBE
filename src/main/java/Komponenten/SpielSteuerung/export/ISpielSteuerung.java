package Komponenten.SpielSteuerung.export;

import datenmodel.Spiel;
import datenmodel.Spieler;
import datenmodel.Spielkarte;
import datenmodel.Spielrunde;

import java.util.List;

public interface ISpielSteuerung {

    /**
     * SpielVerwaltung durch seine Hand spielt eine Karte auf dem aufgelegten Kartenstapel
     * @param spieler
     * @param spielkarte
     * @return boolean - ob die Spielkarte gespielt werden darf
     */
    boolean spieleKarte(Spieler spieler, Spielkarte spielkarte);

    /**
     * checks ob es Karten gibt die man ziehen soll
     * @param spielrunde
     * @return boolean
     */
    boolean checkZuziehndenKarten(Spielrunde spielrunde);

    /**
     * check ob Mau aufgerufen werden soll, wenn der SpielVerwaltung nur eine Karte noch hat
     * @param spieler
     * @return
     */
    boolean sollMauAufgerufen (Spieler spieler);

    /**
     * SpielVerwaltung zieht eine Spielkart vom Kartenstapel
     * @param spieler
     * @param anzahlKarten
     * @return List<Spielkarte>
     */
    List<Spielkarte> zieheKartenVomStapel(Spieler spieler, int anzahlKarten);

}
