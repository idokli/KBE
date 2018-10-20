package datenmodel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spieler extends BaseEntity {
	
	private KartenHand hand;
	
	private String name;
	private boolean isPlaying;
	
	public Spieler(String name) {
		this.hand = new KartenHand();
		this.name = name;
	}

	public void zieheKarte(final Spielkarte spielkarte) {
		this.hand.add(spielkarte);
	}

	public void spieleKarte(final Spielkarte spielkarte) {
		this.hand.remove(spielkarte);
	}

}
