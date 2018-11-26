package komponenten.SpielSteuerung.impl;

import komponenten.SpielSteuerung.export.ISpielSteuerung;
import datenmodel.*;
import datenmodel.Enum.Blatttyp;
import komponenten.Spielregel.export.ISpielregel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import datenmodel.Exceptions.MauMauException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Komponent, der eine Spielrunde steuert
 */
@Service
// NoArgsConstructor needed for spring container initiation
@NoArgsConstructor
public class SpielSteuerungImpl implements ISpielSteuerung {

    // Die spezifische Implementierung muss definiert werden
    @Autowired
    @Qualifier("ohneSonder")
    private ISpielregel spielregel;

    private Spielrunde spielrunde;

    public SpielSteuerungImpl(Spielrunde spielrunde){

        this.spielrunde = spielrunde;
    }

    public Spieler fragWerDaranIst() throws MauMauException {
        List<Spieler> spielerMitSpielend = spielrunde.getSpielerListe().stream()
                .filter(Spieler::isSpielend).collect(Collectors.toList());

        if(spielerMitSpielend.size() != 1){
            throw new MauMauException("Keine oder mehrere Spieler mit spielend true gesetzt");
        }

        return spielerMitSpielend.get(0);

    }

    public int checkZuZiehendenKarten(Spielrunde spielrunde) {
        return 0;
    }

    public boolean spieleKarte(Spieler spieler, Spielkarte spielkarte) {
        return false;
    }

    public boolean sollMauMauAufrufen(Spieler spieler) throws MauMauException {
        if(spieler == null){
            throw new MauMauException("Spieler ist null");
        }
        return spieler.getHand().size() == 1;
    }

    public boolean pruefeObWuenscher(Spielkarte spielkarte) throws MauMauException {
        return spielregel.pruefeObWuenscher(spielkarte);
    }

    public void bestimmeBlatttyp(Blatttyp blatttyp) throws MauMauException {
        if (blatttyp == null){
            throw new MauMauException("Blatttyp ist null");
        }
        spielrunde.setRundeFarbe(blatttyp);
    }

    public Spieler zieheKartenVomStapel(Spieler spieler, int anzahlKarten) {
        return null;
    }
}
