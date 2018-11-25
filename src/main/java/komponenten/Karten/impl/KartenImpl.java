package komponenten.Karten.impl;

import komponenten.Karten.export.IKarten;
import datenmodel.Enum.SpielTyp;
import datenmodel.Exceptions.MauMauException;
import datenmodel.KartenStapel;
import org.springframework.stereotype.Service;

/**
 * Komponent, der je nach Spieltyp, den Kartenstapel baut
 */
@Service
public class KartenImpl implements IKarten {

    public KartenStapel baueStapel(SpielTyp spielTyp) throws MauMauException {
        return null;
    }
}
