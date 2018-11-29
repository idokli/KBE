package komponenten.Karten.impl;

import datenmodel.Enum.Blatttyp;
import datenmodel.Enum.Blattwert;
import datenmodel.Exceptions.MauMauException;
import datenmodel.Spielkarte;
import komponenten.Karten.export.IKarten;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Komponent, der je nach Spieltyp, den Kartenstapel baut
 */
@Service
public class KartenImpl implements IKarten {


    @Override
    public List<Spielkarte> baueStapel(List<Blatttyp> blatttypen, List<Blattwert> blattwerten) throws MauMauException {
        return null;
    }

}
