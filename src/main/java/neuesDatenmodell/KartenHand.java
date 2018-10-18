package neuesDatenmodell;

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
	
	public void remove(int index) throws MauMauException {
		if(index < 0 || index >= this.handKarten.size()) {
			throw new MauMauException("Index nicht vorhanden");
		}
		
		this.handKarten.remove(index);
	}
	
	public String ToString() {
		String s = "";

		
		for(int i = 0; i < this.handKarten.size(); i++) {
			s += this.handKarten.get(i);
			if( i < this.handKarten.size()-1) {
				s += ", ";
			}
		}
		
		return s;
	}

}
