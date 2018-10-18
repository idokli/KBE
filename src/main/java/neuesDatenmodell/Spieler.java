package neuesDatenmodell;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spieler {
	
	private KartenHand hand;
	
	private String name;
	private boolean isPlaying;
	
	public Spieler(String name) {
		this.hand = new KartenHand();
		this.name = name;
		this.isPlaying = true;
	}
	
	
	/**
	 * Für wenn der Spieler einen Blatttyp aussuchen kann
	 * @return
	 */
	public Blatttyp waehleBlatttyp() {
		if(this.hand.getSizeHand() > 0) {
			
			// Hier wird dem Spieler die Farben angezeigt
			return Blatttyp.Herz;
			
		} else {
			
			// hier kommt ein random generierte Farbe
			return Blatttyp.Herz;
		}
	}
	
	public void zieheKarten(int anzahl) throws MauMauException {
		

	}
	
	public Spielkarte zieheKarte() throws MauMauException {
		return null;
		
	}
	
	public void spieleKarte() {
		
	}
	


	
};
