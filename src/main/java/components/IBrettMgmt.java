package components;

import datenmodel.KartenStapel;
import datenmodel.Spieler;
import datenmodel.Spielkarte;
import datenmodel.Spielrunde;

import java.util.List;

public interface IBrettMgmt {


    /**
     * Aus der Klasse Spielkarte wird der Stapel für die Spielrune gebaut
     * @param spielrunde
     * @return
     */
    KartenStapel baueStapel(Spielrunde spielrunde, Spielkarte spielkarte);

    /**
     * Spieler bekommen Initialkarten
     * @param kartenStapel
     * @param spielerListe
     * @return
     */
    List<Spieler> verteileInitialKarten(KartenStapel kartenStapel, List<Spieler> spielerListe);


    /**
     * Prüft ob eine Karte auflegbar ist
     * @param spielkarte
     * @return
     */
    boolean pruefeObKarteAuflegbar(Spielkarte spielkarte);


}
