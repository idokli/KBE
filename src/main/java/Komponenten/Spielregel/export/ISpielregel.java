package Komponenten.Spielregel.export;

import datenmodel.Enum.Blatttyp;
import datenmodel.Exceptions.MauMauException;
import datenmodel.HilfKlassen.RegelComponentUtil;
import datenmodel.Spieler;
import datenmodel.Spielkarte;

import java.util.List;

public interface ISpielregel {

    /**
     * Erste Prüfung ob die vom User ausgewählten Spielkarte überhaupt legbar ist
     * Blatttyp muss übergeben werden, für den Fall dass einen Blatttyp im Zug davor gewünscht wurde
     * @param vorherigeSpielkarte
     * @param aktuelleSpielkarte
     * @return
     */
    boolean istKarteLegbar(Spielkarte vorherigeSpielkarte, Spielkarte aktuelleSpielkarte, Blatttyp blatttyp) throws MauMauException;

    /**
     * Bestimmt die Auswirkungen von der gespielten Karte bzw. wer daran ist und wie viele Karten zu ziehen sind
     * @param aktuelleSpielkarte
     * @param spielerListe
     * @return
     */
    RegelComponentUtil holeAuswirkungVonKarte(Spielkarte aktuelleSpielkarte, List<Spieler> spielerListe)throws MauMauException;


}
