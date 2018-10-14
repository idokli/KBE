// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package datenmodell;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spiel {

	private int id;

	private Date Datum;

	private long Dauer;

	private List<Spieler> spielerListe;
	
	
	public void registriereSpieler(Spieler spieler) {
		if (this.spielerListe == null) {
			this.spielerListe = new ArrayList<Spieler>();
		}
		this.spielerListe.add(spieler);
	}
	
	public Spielrunde erstelleRunde() {
		return new Spielrunde();
	}
};
