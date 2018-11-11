package Komponenten.Karten.export;

import datenmodel.Enum.SpielTyp;
import datenmodel.Exceptions.MauMauException;
import datenmodel.KartenStapel;


public interface IKarten {

    /**
     * Gib zurück eine Kartenstapel zum ausgewählten Spiel
     * @param spielTyp
     * @return
     * @throws MauMauException
     */
    KartenStapel baueStapel(SpielTyp spielTyp) throws MauMauException;

}
