package de.htw_berlin.MauMauG3;


/**
 * @author victo
 *
 */

public interface MauMau {
	
	
	void beginneSpiel();
	
	void registriereSpieler();
	
	void starteRunde();
	
	void baueStapel();
	
	void verteileInitialeKarten();
	
	void legeKarteAuf();
	
	void zieheKartevonStapel();
	
	// Sonderregel
	

	void mischeKarten();
	
	void berechneErgebnisPunkte();
	
	

}
