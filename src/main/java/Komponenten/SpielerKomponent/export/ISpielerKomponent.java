package Komponenten.SpielerKomponent.export;

import datenmodel.Spieler;

public interface ISpielerKomponent {

    /**
     * register Spieler in DB
     * @param spieler
     * @return
     */
    boolean registerSpieler (Spieler spieler);

    /**
     * gibt ein Spieler Objekt mit dem Namen zurück
     * @param name
     * @return
     */
    Spieler getSpieler(String name);
}
