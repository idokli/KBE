package komponenten.Karten.export;

import datenmodel.Enum.SpielTyp;
import datenmodel.Exceptions.MauMauException;
import datenmodel.Spielkarte;

import java.util.List;


public interface IKarten {

    /**
     * Gib zurück einen Kartenstapel zum ausgewählten Spieltyp
     * @param spielTyp
     * @return
     * @throws MauMauException
     */
    List<Spielkarte> baueStapel(SpielTyp spielTyp) throws MauMauException;

}
