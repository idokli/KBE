package datenmodel;

import datenmodel.HilfKlassen.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Spieler extends BaseEntity {

	private List<Spielkarte> hand;
	private String name;
	private boolean spielend;
	
	public Spieler(String name) {
		this.hand = new ArrayList<Spielkarte>();
		this.name = name;
	}

	public void zieheKarte(final Spielkarte spielkarte) {
		this.hand.add(spielkarte);
	}

	public void spieleKarte(final Spielkarte spielkarte) {
		this.hand.remove(spielkarte);
	}

}
