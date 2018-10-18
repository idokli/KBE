
package neuesDatenmodell;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spielkarte {
	
	private Blattwert Blattwert;

	private Blatttyp Blatttyp;

	
	public Spielkarte(Blatttyp blatttyp, Blattwert blattwert) {
		this.Blatttyp = blatttyp;
		this.Blattwert = blattwert;
	}
	
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Spielkarte)) {
			return false;
		}
		Spielkarte tmp = (Spielkarte) obj;
		return (this.Blatttyp == tmp.Blatttyp && this.Blattwert == tmp.Blattwert);
	}
	
	public String ToString() {
		return this.Blatttyp.name() + "-" + this.Blattwert;
	}
};
