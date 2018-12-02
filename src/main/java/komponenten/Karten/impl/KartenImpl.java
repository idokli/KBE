package komponenten.Karten.impl;

import datenmodel.Enum.Blatttyp;
import datenmodel.Enum.Blattwert;
import datenmodel.Exceptions.MauMauException;
import datenmodel.Spielkarte;
import komponenten.Karten.export.IKarten;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Komponent, der je nach Spieltyp, den Kartenstapel baut
 */
@Service
public class KartenImpl implements IKarten {


    @Override
    public List<Spielkarte> baueStapel(List<Blatttyp> blatttypen, List<Blattwert> blattwerten) throws MauMauException {

        if(blatttypen==null || blattwerten == null) {
            throw new MauMauException("Fehler");
        }

        List<Spielkarte> stapel = new ArrayList<>();
        for(Blatttyp blatttyp : Blatttyp.values()) {
            if(!blatttypen.contains(blatttyp)) {
                for(Blattwert blattwert : Blattwert.values()) {
                    if(!blattwerten.contains(blattwert)) {
                        stapel.add(new Spielkarte(blattwert, blatttyp));
                    }
                }
            }
        }
        return stapel;
    }

}
