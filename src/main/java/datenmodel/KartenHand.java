package datenmodel;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KartenHand {
	
	private List<Spielkarte> handKarten;
	
	private Spielrunde spielrunde;
	
	public KartenHand() {
		this.handKarten = new ArrayList<Spielkarte>();
	}
	
	public int getSizeHand() {
		return this.handKarten.size();
	}
	
	public Spielkarte getKarteAt(int index) {
		return this.handKarten.get(index);
	}
	
	public void add(Spielkarte spielkarte) {
		this.handKarten.add(spielkarte);
	}
	
	public void remove(final Spielkarte spielkarte) {

		if(this.handKarten.contains(spielkarte)) {
			this.handKarten.remove(spielkarte);
		}
	}

	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < this.handKarten.size(); i++) {
			s += this.handKarten.get(i).toString();
			if( i < this.handKarten.size()-1) {
				s += ", ";
			}
		}
		
		return s;
	}

}
