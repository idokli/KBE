package de.htw_berlin.MauMauG3;

import java.util.List;

import datenmodel.Spiel;
import datenmodel.Spieler;
import datenmodel.Spielrunde;
import datenmodel.KartenStapel;
import datenmodel.Spielkarte;

public class MauMauImpl implements IMauMau {


	public Spiel beginneSpiel() {

		return null;
	}

	public void registriereSpieler(Spieler spieler, Spiel spiel) {

	}

	public Spielrunde erstelleRunde(Spiel Spiel) {
		return null;
	}

	public KartenStapel baueStapel(Spielrunde spielrunde) {
		return null;
	}

	public void kartenverteilen(List<Spieler> spielerListe, KartenStapel kartenstapel) {

	}

	public void waehleErsterSpieler(List<Spieler> spielerliste) {

	}

	public void spieleKarte(Spieler spieler, KartenStapel aufgelegterStapel) {

	}

	public Spielkarte zieheKarteVomStapel(KartenStapel kartenstapel, Spieler spieler) {
		return null;
	}

	public void berechneErgebnisse(List<Spieler> spielerListe) {

	}
}
