package de.htw_berlin.MauMauG3;

import java.util.List;

import datenmodell.Spiel;
import datenmodell.Spieler;
import datenmodell.Spielrunde;
import neuesDatenmodell.KartenHand;
import neuesDatenmodell.KartenStapel;
import neuesDatenmodell.Spielkarte;

public interface IMauMauNew {


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
	 * Verteilt initiale Spielkarten an den Spieler
	 * @param spielerListe
	 * @param kartenstapel
	 */
	void kartenverteilen(List<Spieler> spielerListe, KartenStapel kartenstapel);
	
	/**
	 * Spieler zieht eine Spielkart vom Kartenstapel
	 * @param kartenstapel
	 * @param spieler
	 * @return
	 */
	Spielkarte zieheKarteVomStapel(KartenStapel kartenstapel, Spieler spieler);

	
	/**
	 * Spieler durch seine Hand spielt eine Karte auf dem aufgelegten Kartenstapel
	 * @param hand
	 * @param spielkarte
	 * @param kartenstapelAufgelegt
	 * @return
	 */
	List<Spielkarte> spieleKarte(KartenHand hand, Spielkarte spielkarte, KartenStapel kartenstapelAufgelegt);
	
	

}
