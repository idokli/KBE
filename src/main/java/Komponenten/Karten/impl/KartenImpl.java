package Komponenten.Karten.impl;

import Komponenten.Karten.export.IKarten;
import datenmodel.Enum.SpielTyp;
import datenmodel.Exceptions.MauMauException;
import datenmodel.KartenStapel;

/**
 * Komponent, der je nach Spieltyp, den Kartenstapel baut
 */
public class KartenImpl implements IKarten {

    public KartenStapel baueStapel(SpielTyp spielTyp) throws MauMauException {
        return null;
    }
}
