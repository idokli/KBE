package komponenten.SpielSteuerung.impl;

import komponenten.SpielSteuerung.export.ISpielSteuerung;
import datenmodel.*;
import datenmodel.Enum.Blatttyp;
import komponenten.Spielregel.export.ISpielregel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Komponent, der eine Spielrunde steuert
 */
@Service
public class SpielSteuerungImpl implements ISpielSteuerung {

    @Autowired
    @Qualifier("ohneSonder")
    private ISpielregel spielregelService;


    // Constructr can't have an entity for now
//    private Spielrunde spielrunde;

//    public SpielSteuerungImpl(Spielrunde spielrunde){
//
//        this.spielrunde = spielrunde;
//    }

    public SpielSteuerungImpl() {

    }

    public Spieler fragWerDaranIst() {
        return null;
    }

    public int checkZuZiehendenKarten(Spielrunde spielrunde) {
        return 0;
    }

    public boolean spieleKarte(Spieler spieler, Spielkarte spielkarte) {
        return false;
    }

    public boolean sollMauMauAufrufen(Spieler spieler) {
        return false;
    }

    public boolean pruefeObWuenscher(Spielkarte spielkarte) {
        return false;
    }

    public void bestimmeBlatttyp(Blatttyp blatttyp) { }

    public Spieler zieheKartenVomStapel(Spieler spieler, int anzahlKarten) {
        return null;
    }
}
