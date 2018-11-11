package Komponenten.Spielregel.export;

import datenmodel.HilfKlassen.RegelComponentUtil;
import datenmodel.Spieler;
import datenmodel.Spielkarte;

import java.util.List;

public interface ISpielregel {

    /**
     * Erste Prüfung ob die vom User ausgewählten Spielkarte überhaupt legbar ist
     * @param vorherigeSpielkarte
     * @param aktuelleSpielkarte
     * @return
     */
    boolean istKarteLegbar(Spielkarte vorherigeSpielkarte, Spielkarte aktuelleSpielkarte) ;

    /**
     * Bestimmt die Auswirkungen von der gespielten Karte bzw. wer daran ist und wie viele Karten zu ziehen sind
     * @param aktuelleSpielkarte
     * @param spielerListe
     * @return
     */
    RegelComponentUtil holeAuswirkungVonKarte(Spielkarte aktuelleSpielkarte, List<Spieler> spielerListe);


}
