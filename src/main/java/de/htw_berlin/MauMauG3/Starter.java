package de.htw_berlin.MauMauG3;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;


import datenmodell.Spiel;
import datenmodell.Spieler;
import datenmodell.Spielkarte;
import datenmodell.Spielrunde;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Starter 
{
	
    public static void main( String[] args ) {
    	
    	// Stopwatch für die Dauer des Spiels
    	StopWatch stopwatch = new StopWatch();
    	stopwatch.start();
    	log.info("Stopwatch started");
    	
    	// Spiel anlegen
       Spiel neuesSpiel = new Spiel();
       neuesSpiel.setDatum(new Date());
       
       // Spieler anlegen und dem Spiel zuordnen
       Spieler spielerIdo = new Spieler();
       neuesSpiel.registriereSpieler(spielerIdo);
       Spieler spielerVictor = new Spieler();
       neuesSpiel.registriereSpieler(spielerVictor);
       
       
       // Runde erstellen
       Spielrunde spielrunde = neuesSpiel.erstelleRunde();
  
      
       // Stapel erstellen
       spielrunde.baueStapel();
       List<Spielkarte> stapel = spielrunde.getStapel();

       
       // Initialkarten verteilen, 7 karten pro Spieler?
       for(Spieler spieler: neuesSpiel.getSpielerListe()) {
           for(int i= 0; i<7; i++) {
        	   int random = (int) ((Math.random() * stapel.size()));
        	   spieler.zieheSpielkarte(stapel.get(random));
        	   stapel.remove(random);
           }
       }
   
       // Ende --> Dauer berechnen
       neuesSpiel.setDauer(stopwatch.getTime());
       log.info("Stopwatch stopped");
     
    }
}
