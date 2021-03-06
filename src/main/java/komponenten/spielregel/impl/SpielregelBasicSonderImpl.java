package komponenten.spielregel.impl;

import datenmodel.Enum.Blatttyp;
import datenmodel.Enum.Blattwert;
import datenmodel.Exceptions.MauMauException;
import datenmodel.HilfKlassen.RegelComponentUtil;
import datenmodel.Spieler;
import datenmodel.Spielkarte;
import komponenten.spielregel.export.ISpielregel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Implementierung von spielregel-Komponent mit Zwei_ziehen(7), Aussetzen(Ass) und Wünscher(Bube)
 */
@Service
@Qualifier("basicSonder")
public class SpielregelBasicSonderImpl extends SpielregelOhneSonderImpl implements ISpielregel {


    @Override
    public boolean istKarteLegbar(Spielkarte vorherigeSpielkarte, Spielkarte aktuelleSpielkarte, Blatttyp blatttyp) throws MauMauException {
        // TODO wie behandeln wir exceptions?
        if (vorherigeSpielkarte == null || aktuelleSpielkarte == null) {
            throw new MauMauException("Fehler");
        }
        // Basic-Prüfung ohne SonderRegel
        boolean istLegbar = super.istKarteLegbar(vorherigeSpielkarte, aktuelleSpielkarte, blatttyp);
        // Wenn Blatttyp im Zug davor gewählt, dann kann man nur Blattyp spielen aber nicht noch eine Bube
        if (blatttyp != null) {
            if (aktuelleSpielkarte.getBlattwert() == Blattwert.Bube) {
                istLegbar = false;
            } else if(aktuelleSpielkarte.getBlatttyp() == blatttyp) {
                istLegbar = true;
            }
        } else {
            // Sonderprüfung wegen Zwei_ziehen
            switch (vorherigeSpielkarte.getBlattwert()) {
                case Sieben:
                    if(aktuelleSpielkarte.getBlattwert() != Blattwert.Sieben) {
                        istLegbar = false;
                    }
                    break;
                case Ass:
                    istLegbar = false;
                    break;
            }
        }
        return istLegbar;
    }

    @Override
    public RegelComponentUtil holeAuswirkungVonKarte(Spielkarte aktuelleSpielkarte, List<Spieler> spielerListe) throws MauMauException {
        // TODO wie behandeln wir Exceptions?
        if (aktuelleSpielkarte == null || spielerListe == null) {
            throw new MauMauException("Fehler");
        }
        RegelComponentUtil util = super.holeAuswirkungVonKarte(aktuelleSpielkarte, spielerListe);
        switch (aktuelleSpielkarte.getBlattwert()) {
            case Sieben:
                util.setAnzahlKartenZuZiehen(2);
                break;
            case Ass:
                for (Spieler spieler : spielerListe) {
                    if (spieler.isSpielend()) {
                        int indexSpielend = spielerListe.indexOf(spieler);
                        if (indexSpielend == spielerListe.size() - 1) {
                            spielerListe.get(1).setSpielend(true);
                        } else if (indexSpielend == spielerListe.size() - 2) {
                            spielerListe.get(0).setSpielend(true);
                        } else {
                            spielerListe.get(indexSpielend + 2).setSpielend(true);
                        }
                        break;
                    }
                }
                util.setSpielerListe(spielerListe);
                break;
        }
        return util;
    }
}
