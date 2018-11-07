package Komponenten.SpielVerwaltung.export;

import datenmodel.Spieler;

public interface ISpielVerwaltung {

    /**
     * register SpielVerwaltung in DB
     * @param spieler
     * @return
     */
    boolean registerSpieler (Spieler spieler);

    /**
     * gibt ein SpielVerwaltung Objekt mit dem Namen zurück
     * @param name
     * @return
     */
    Spieler getSpieler(String name);
}
