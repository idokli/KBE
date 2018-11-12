package Komponenten.Karten.export;

import datenmodel.Enum.SpielTyp;
import datenmodel.Exceptions.MauMauException;
import datenmodel.KartenStapel;


public interface IKarten {

    /**
     * Gib zurück einen Kartenstapel zum ausgewählten Spieltyp
     * @param spielTyp
     * @return
     * @throws MauMauException
     */
    KartenStapel baueStapel(SpielTyp spielTyp) throws MauMauException;

}
