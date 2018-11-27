package komponenten.SpielSteuerung.impl;

import komponenten.SpielSteuerung.export.ISpielSteuerung;
import datenmodel.*;
import datenmodel.Enum.Blatttyp;
import komponenten.Spielregel.export.ISpielregel;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import datenmodel.Exceptions.MauMauException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private ISpielregel spielregelohneSonder;

    @Autowired
    @Qualifier("basicSonder")
    private ISpielregel spielregelBasicSonder;

    @Autowired
    @Qualifier("alleSonder")
    private ISpielregel spielregelAlleSonder;

    //TODO add to interface setting of selected spiel regel
    private ISpielregel selectedSpielRegel;

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
        if( spielrunde.getZuZiehnKartenAnzahl() == null){
            spielrunde.setZuZiehnKartenAnzahl(0);
        }
        return spielrunde.getZuZiehnKartenAnzahl();
    }

    public boolean spieleKarte(Spieler spieler, Spielkarte spielkarte) throws MauMauException {
        if(selectedSpielRegel.istKarteLegbar(getLetzteAufgelegteKarte(), spielkarte, spielrunde.getRundeFarbe())){
            return true;
        } else {
            return false;
        }
    }

    public boolean sollMauMauAufrufen(Spieler spieler) throws MauMauException {
        if(spieler == null){
            throw new MauMauException("Spieler ist null");
        }
        return spieler.getHand().size() == 1;
    }

    public boolean pruefeObWuenscher(Spielkarte spielkarte) throws MauMauException {
        return selectedSpielRegel.pruefeObWuenscher(spielkarte);
    }

    public void bestimmeBlatttyp(Blatttyp blatttyp) throws MauMauException {
        if (blatttyp == null){
            throw new MauMauException("Blatttyp ist null");
        }
        spielrunde.setRundeFarbe(blatttyp);
    }

    public Spieler zieheKartenVomStapel(Spieler spieler, int anzahlKarten) throws MauMauException {
        if(spieler == null){
            throw new MauMauException("Spieler ist null");
        }

        List<Spielkarte> neueKarten = getNeueKartenVomVerdecktenStapelUndRemove(anzahlKarten);
        spieler.getHand().addAll(neueKarten);

        return spieler;
    }

    private void addeSpielkarteZumAufgelegtStapel(Spielkarte spielkarte) throws MauMauException {
        if (CollectionUtils.isEmpty(spielrunde.getAufgelegtStapel())) {
            throw new MauMauException("AufgelegtStapel ist leer");
        }
        spielrunde.getAufgelegtStapel().add(spielkarte);
    }

    // Für aufgedeckten Stapel
    private Spielkarte getLetzteAufgelegteKarte() throws MauMauException {
        List<Spielkarte> aufgelegtStapel = spielrunde.getAufgelegtStapel();
        if (CollectionUtils.isEmpty(aufgelegtStapel)) {
            throw new MauMauException("AufgelegtStapel ist leer");
        }
        return aufgelegtStapel.get(aufgelegtStapel.size() - 1);
    }

    // Für verdeckten Stapel
    private List<Spielkarte> getNeueKartenVomVerdecktenStapelUndRemove(int anzahl) throws MauMauException {
        if(spielrunde.getVerdeckteStapel().size() < anzahl){
            reloadVerdecktenStapel();
        }
        List<Spielkarte> returnedKarte = new ArrayList<>(anzahl);
        for (int i=0; i < anzahl; i++){
            int letzteIndex = spielrunde.getVerdeckteStapel().size()-1;
            returnedKarte.add(spielrunde.getVerdeckteStapel().get(letzteIndex));
            spielrunde.getVerdeckteStapel().remove(letzteIndex);
        }
        return returnedKarte;
    }

    //TODO add logger comment
    private void reloadVerdecktenStapel(){
        List<Spielkarte> originalAufgeleteStapel = spielrunde.getAufgelegtStapel();
        // nimmt die letzte aufgelegte Karte, erzeug davon ein neuer Stapel und setzt er als der neue aufgelegte Stapel in der Spielrunde
        Spielkarte letzteAufgelegteSpielKarte = originalAufgeleteStapel.get(originalAufgeleteStapel.size() - 1);
        List<Spielkarte> neuAufgelegteStapel = new ArrayList<>();
        neuAufgelegteStapel.addAll(Arrays.asList(letzteAufgelegteSpielKarte));
        spielrunde.setAufgelegtStapel(neuAufgelegteStapel);

        //Entfernung von der letzte aufgelegte Karte und durchmischen
        originalAufgeleteStapel.remove(originalAufgeleteStapel.size() - 1);
        List<Spielkarte> gemischteNeuerAufgedeckterStapel = mischeKarten(originalAufgeleteStapel);

        //hinzufügen von den vorherigen Karten vom verdeckten Stapel
        List<Spielkarte> originalVerdeckteStapel = spielrunde.getVerdeckteStapel();
        gemischteNeuerAufgedeckterStapel.addAll(originalVerdeckteStapel);

        //Aktualisierung vom verdeckten Stapel in der Spielrunde
        List<Spielkarte> neuVerdeckterStapel = new ArrayList<>();
        neuVerdeckterStapel.addAll(gemischteNeuerAufgedeckterStapel);
        spielrunde.setVerdeckteStapel(neuVerdeckterStapel);
    }


    private List<Spielkarte> mischeKarten(List<Spielkarte> listSpielkarten) {
        Collections.shuffle(listSpielkarten);
        return listSpielkarten;
    }
}
