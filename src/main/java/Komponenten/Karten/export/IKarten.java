package Komponenten.Karten.export;

import datenmodel.Enum.SpielTyp;
import datenmodel.KartenStapel;


public interface IKarten {

    /**
     * Gib zurück eine Kartenstapel zum ausgewählten Spiel
     * @param spielTyp
     * @return
     */
    KartenStapel baueStapel(SpielTyp spielTyp);

}
