package de.htw_berlin.MauMauG3;

import java.util.List;

import org.apache.commons.lang3.time.StopWatch;

import datenmodell.Spiel;
import datenmodell.Spieler;
import datenmodell.Spielkarte;
import datenmodell.Spielrunde;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MauMauImpl implements MauMau {

	private static Spiel neuesSpiel;
	private static StopWatch stopwatch = new StopWatch();
	private static Spielrunde runde;
	private static List<Spielkarte> stapel;

	public void beginneSpiel() {

		neuesSpiel = new Spiel();

		stopwatch.start();
		log.info("Stopwatch started");

		neuesSpiel.setBeginn(stopwatch.getTime());
		
		this.registriereSpieler();

	}

	public void registriereSpieler() {

		Spieler spielerIdo = new Spieler(1);
		neuesSpiel.registriereSpieler(spielerIdo);

		Spieler spielerVictor = new Spieler(2);
		neuesSpiel.registriereSpieler(spielerVictor);
		
		this.starteRunde();

	}

	public void starteRunde() {
		runde = neuesSpiel.erstelleRunde();
		
		this.baueStapel();

	}

	public void baueStapel() {
		
		 runde.baueStapel(true);
		 stapel = runde.getStapel();
		 
		 this.verteileInitialeKarten();

	}

	public void verteileInitialeKarten() {
		
		// Initialkarten verteilen, 7 karten pro Spieler?
		for (Spieler spieler : neuesSpiel.getSpielerListe()) {
			for (int i = 0; i < 7; i++) {
				System.out.println("Listegroesse: " + stapel.size());
				int random = (int) ((Math.random() * stapel.size()));
				spieler.zieheSpielkarte(stapel.get(random));
				stapel.remove(random);
			}
		}

		for (Spieler spieler : neuesSpiel.getSpielerListe()) {
			System.out.println("Spieler hat " + spieler.getHandKarten().size() + " Spielkarten:");
			for (Spielkarte spielkarte : spieler.getHandKarten()) {
				System.out.println(spielkarte.getBlatttyp().name() + "-" + spielkarte.getBlattwert().name());
			}
		}
		
		this.beendeSpiel();

	}

	public void legeKarteAuf() {
		// TODO Auto-generated method stub

	}

	public void zieheKartevonStapel() {
		// TODO Auto-generated method stub

	}

	public void mischeKarten() {
		// TODO Auto-generated method stub

	}

	public void berechneErgebnisPunkte() {
		// TODO Auto-generated method stub

	}

	public void beendeSpiel() {

		stopwatch.stop();
		neuesSpiel.setDauer(stopwatch.getTime());
		log.info("Stopwatch stopped");
	}

}
