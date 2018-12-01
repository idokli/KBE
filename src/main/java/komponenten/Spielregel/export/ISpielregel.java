package komponenten.Spielregel.export;

import datenmodel.Enum.Blatttyp;
import datenmodel.Exceptions.MauMauException;
import datenmodel.HilfKlassen.RegelComponentUtil;
import datenmodel.Spieler;
import datenmodel.Spielkarte;

import java.util.List;

public interface ISpielregel {

    /**
     * Prüft ob eine Spielkarte auf eine andere Spielkarte legbar ist
     *
     * @param vorherigeSpielkarte - die Spielkarte, die im Zug davor gespielt wurde
     * @param aktuelleSpielkarte  - die Spielkarte, die im aktuellen Zug gespielt werden soll
     * @param blatttyp            - der Blatttyp, der bei einer Bube gewünscht wird
     * @return boolean - ob die Spielkarte legbar ist oder nicht
     * @throws MauMauException
     */
    boolean istKarteLegbar(Spielkarte vorherigeSpielkarte, Spielkarte aktuelleSpielkarte, Blatttyp blatttyp) throws MauMauException;

    /**
     * Bestimmt die Auswirkungen von der gespielten Karte. In dieser Impl gibt es aber keine Sonderegel und daher
     * wird nur der zu spielende Spieler bestimmt.
     *
     * @param aktuelleSpielkarte - die Spielkarte, die im aktuellen Zug gespielt wird
     * @param spielerListe       - die Spielerliste
     * @return RegelComponentUtil - Util-Object, um die Spielerliste und die Anzahl von zu ziehenden Karten zurückzugeben
     * @throws MauMauException
     */
    RegelComponentUtil holeAuswirkungVonKarte(Spielkarte aktuelleSpielkarte, List<Spieler> spielerListe) throws MauMauException;

    /**
     * Prüft, ob die übergebene Spielkarte den Blattwert Bube hat
     *
     * @param spielkarte - die übergebene Spielkarte
     * @return boolean - ja oder nein
     */
    boolean pruefeObWuenscher(Spielkarte spielkarte) throws MauMauException;
}
