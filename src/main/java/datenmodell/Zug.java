// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package datenmodell;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/************************************************************/
/**
 * 
 */	
@Getter
@Setter
public class Zug {

	private Richtung richtung;

	private Spielkarte aufgelegteKarte;

	private List<Spielkarte> erlaubteNaechsteKarten;
	

	public void bestimmeErlaubteNaechsteKarten() {
		
		// Normale erlaubte Karten
		
		
	
		// Sonderregel-Karten
	}
	

};
