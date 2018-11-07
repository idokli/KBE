package Komponenten.Karten.export;

import datenmodel.Enum.SpielTyp;
import datenmodel.Spielkarte;

import java.util.List;

public interface IKarten {

    /**
     * Gib zurück eine Kartenstapel zum ausgewählten Spiel
     * @param spielTyp
     */
    List<Spielkarte> baueStapel(SpielTyp spielTyp);

}
