package de.htw_berlin.MauMauG3;

import java.util.List;

import datenmodel.Spiel;
import datenmodel.Spieler;
import datenmodel.Spielrunde;
import datenmodel.KartenStapel;
import datenmodel.Spielkarte;

public interface IMauMau {


	/**
	 * Erstellt ein neues Spiel
	 * 
	 * @return
	 */
	Spiel beginneSpiel();

	/**
	 * Registriert Spieler auf dem SPiel
	 * 
	 * @param spieler
	 * @param spiel
	 */
	void registriereSpieler(Spieler spieler, Spiel spiel);

	/**
	 * Erstellt im Spiel eine Runde
	 * 
	 * @param Spiel
	 * @return
	 */
	Spielrunde erstelleRunde(Spiel Spiel);

	/**
	 * Baut in der Runde den Kartenstapel
	 * 
	 * @param spielrunde
	 * @return
	 */
	KartenStapel baueStapel(Spielrunde spielrunde);
	
	
	/**
	 * Verteilt initiale Spielkarten an den Spieler bzw. erstellt die Kartenhand
	 * @param spielerListe
	 * @param kartenstapel
	 */
	void kartenverteilen(List<Spieler> spielerListe, KartenStapel kartenstapel);


	/**
	 * Sucht sich einen Spieler random aus. isPlaying wird auf true gesetzt
	 * @param spielerliste
	 */
	void waehleErsterSpieler(List<Spieler> spielerliste);


	/**
	 * Spieler durch seine Hand spielt eine Karte auf dem aufgelegten Kartenstapel
	 * @param spieler
	 * @param aufgelegterStapel
	 */
	void spieleKarte(Spieler spieler, KartenStapel aufgelegterStapel);

	
	/**
	 * Spieler zieht eine Spielkart vom Kartenstapel
	 * @param kartenstapel
	 * @param spieler
	 * @return
	 */
	Spielkarte zieheKarteVomStapel(KartenStapel kartenstapel, Spieler spieler);


	/**
	 * Berechnet aus der Kartenhand jedes Spielers die Punkte
	 * @param spielerListe
	 */
	void berechneErgebnisse(List<Spieler> spielerListe);
}
