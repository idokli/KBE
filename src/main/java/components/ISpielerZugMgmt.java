package components;

import datenmodel.KartenStapel;
import datenmodel.Spieler;
import datenmodel.Spielkarte;

import java.util.List;

public interface ISpielerZugMgmt {

    /**
     * Spieler legt karte auf
     * @param spieler
     * @return
     */
    Spielkarte legeKarteAuf(Spieler spieler);

    /**
     * Spieler zieht Karte(n)
     * @param spieler
     * @param kartenStapel
     * @return
     */
    List<Spielkarte> zieheKarteAuf(Spieler spieler, KartenStapel kartenStapel);

}
