package de.htw_berlin.MauMauG3;

import java.util.List;

import datenmodel.*;

public interface IMauMau {

	/**
	 * Erstellt ein neues Spiel
	 *
	 * @return
	 */
	Spiel starteNeuesSpiel();

	/**
	 * Erstellt im Spiel eine Spielrunde
	 *
	 * @param Spiel
	 */
	void erstelleRunde(Spiel Spiel);

	/**
	 Registriert Spieler auf der Spielrunde
	 * @param spieler
	 * @param spielrunde
	 */
	void registriereSpieler(Spieler spieler, Spielrunde spielrunde);

	/**
	 * Baut in der Runde den Kartenstapel
	 * 
	 * @param spielrunde
	 */
	void baueStapel(Spielrunde spielrunde);


	/**
	 * Verteilt initiale Spielkarten an den Spieler bzw. erstellt die Kartenhand
	 * @param spielerListe
	 * @param spielrunde
	 */
	void kartenverteilen(List<Spieler> spielerListe, Spielrunde spielrunde);


	/**
	 * Sucht sich einen Spieler random aus. "spielend" wird auf true gesetzt
	 * @param spielerliste
	 */
	void waehleErsterSpieler(List<Spieler> spielerliste);


	/**
	 * Spieler durch seine Hand spielt eine Karte auf dem aufgelegten Kartenstapel
	 * @param spieler
	 * @param aufgelegterStapel
	 * @return boolean - ob die Spielkarte gespielt werden darf
	 */
	boolean spieleKarte(Spieler spieler, KartenStapel aufgelegterStapel);


	/**
	 * Spieler zieht eine Spielkart vom Kartenstapel
	 * @param kartenstapel
	 * @param spieler
	 * @param anzahlKarten
	 * @return -
	 */
	void zieheKartenVomStapel(KartenStapel kartenstapel, Spieler spieler, int anzahlKarten);


	/**
	 * Berechnet aus der Kartenhand jedes Spielers die Punkte und setzte den Gewinnername
	 * @param spielrunde
	 */
	void berechneErgebnisse(Spielrunde spielrunde);


	/**
	 * Berechnet Dauer des Spiels
	 * @param spiel
	 */
	void beendeSpiel(Spiel spiel);
}
