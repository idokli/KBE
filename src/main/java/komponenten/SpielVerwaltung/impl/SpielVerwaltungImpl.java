package komponenten.SpielVerwaltung.impl;

import datenmodel.Enum.Blattwert;
import datenmodel.Enum.RegelKompTyp;
import datenmodel.Enum.SpielTyp;
import datenmodel.*;
import datenmodel.Exceptions.MauMauException;
import komponenten.Karten.export.IKarten;
import komponenten.SpielVerwaltung.export.ISpielVerwaltung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.SpielRepository;
import repositories.SpielrundeRepository;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Komponent, der ein Spiel verwaltet bzw. einzelne Spielrunde erstellt
 */
@Service
public class SpielVerwaltungImpl implements ISpielVerwaltung {

    @Autowired
    private IKarten kartenService;

    @Autowired
    private SpielRepository spielRepository;

    @Autowired
    private SpielrundeRepository spielrundeRepository;


    public Spiel starteNeuesSpiel(SpielTyp spielTyp, RegelKompTyp regelKompTyp) throws MauMauException {
        Spiel spiel = new Spiel(spielTyp, regelKompTyp);
        // Falls mehrere Nutzer auf verschiedenen Rechner ein Spiel spielen würde, müsste das Spiel bei der
        // Erstellung persistiert werden, damit der 2. Spieler das 1. erstellte Spiel nutzt
        // this.spielRepository.save(spiel);
        return spiel;
    }

    public Spielrunde starteSpielrunde(List<Spieler> spielerListe, Spiel spiel) throws MauMauException {
        Spielrunde spielrunde = new Spielrunde(spiel);
        spielrunde.setSpielerListe(spielerListe);
        List<Blattwert> blattwertNicht = new ArrayList<>();
        blattwertNicht.add(Blattwert.Joker);
        spielrunde.setVerdeckteStapel(this.kartenService.baueStapel(null, blattwertNicht));
        for(Spieler spieler : spielrunde.getSpielerListe()) {
            for(int i = 0; i<6; i++) {
                Random r = new Random();
                int low = 0;
                int high = spielrunde.getVerdeckteStapel().size();
                int result = r.nextInt(high-low) + low;
                spieler.getHand().add(spielrunde.getVerdeckteStapel().get(result));
                spielrunde.getVerdeckteStapel().remove(result);
            }

        }
        spiel.getSpielrunden().add(spielrunde);
     //   this.spielrundeRepository.save(spielrunde);
        return spielrunde;
    }

    public List<Ergebnis> beendeSpielrunde(Spielrunde spielrunde) throws MauMauException {
//        spielrunde = this.spielrundeRepository.findById(spielrunde.getId());
        // Dauer
        Duration duration = Duration.between(spielrunde.getStart().toInstant(), Instant.now());
        spielrunde.setDauer(duration.toMinutes());

        // Ergebnisse
        for(Spieler spieler : spielrunde.getSpielerListe()) {

            int punkte = 0;
            for(Spielkarte spielkarte : spieler.getHand()) {
                punkte += spielkarte.getBlattwert().getIntWert();
            }
            Ergebnis ergebnis = new Ergebnis(punkte, spielrunde, spieler);
            spielrunde.getErgebnisListe().add(ergebnis);

        }
        this.spielrundeRepository.save(spielrunde);
        return spielrunde.getErgebnisListe();
    }

    public Spiel beendeSpiel(Spiel spiel) throws MauMauException {
//        spiel = this.spielRepository.findById(spiel.getId());
        // Dauer
        Duration duration = Duration.between(spiel.getBeginn().toInstant(), Instant.now());
        spiel.setDauer(duration.toMinutes());

        this.spielRepository.save(spiel);
        return spiel;
    }


}
