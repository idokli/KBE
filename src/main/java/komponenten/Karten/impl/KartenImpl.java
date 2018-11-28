package komponenten.Karten.impl;

import datenmodel.Enum.Blatttyp;
import datenmodel.Enum.Blattwert;
import datenmodel.Enum.SpielTyp;
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

    public List<Spielkarte> baueStapel(SpielTyp spielTyp) throws MauMauException {

        List<Spielkarte> stapel = new ArrayList<>();
        switch(spielTyp) {
            case MauMau:
                // 52 Karten, ohne 4 Jokers
                for(Blatttyp blatttyp : Blatttyp.values()) {
                    for(Blattwert blattwert : Blattwert.values()) {
                        if(blattwert != Blattwert.Joker) {
                            stapel.add(new Spielkarte(blattwert, blatttyp));
                        }
                    }
                }
                break;

            // TODO was bei default?
            default:
        }
        return stapel;
    }
}
