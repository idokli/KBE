package datenmodell.defaultData;

import java.util.ArrayList;
import java.util.List;

import datenmodell.Blatttyp;
import datenmodell.Blattwert;
import datenmodell.Spielkarte;

public class createDefaultData {
	
	public static List<Spielkarte> createDefaultSpielkarten() {
		
		List<Spielkarte> spielKarten = new ArrayList<Spielkarte>();
		
		for (Blatttyp blatttyp : Blatttyp.values()) {
			for (Blattwert blattwert : Blattwert.values()) {

				spielKarten.add(new Spielkarte(blatttyp, blattwert));
			}
		}
		return spielKarten;
		
	}

}
