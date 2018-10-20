
package datenmodel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spielkarte {

    private Blattwert Blattwert;

    private Blatttyp Blatttyp;

    private Regel regel;

    public Spielkarte(Blatttyp blatttyp, Blattwert blattwert) {

        this.Blatttyp = blatttyp;
        this.Blattwert = blattwert;
        this.regel = this.pruefeObRegel(blattwert);
    }

    public Regel pruefeObRegel(Blattwert blattwert) {
        for(Regel regel : Regel.values()) {
            if(regel.getBlattwert().equals(blattwert)) {
                return regel;
            }
        }
        return null;
    }

    // Um sicher zu gehen, dass das richtige Java-Object genommen wird
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Spielkarte)) {
            return false;
        }
        Spielkarte tmp = (Spielkarte) obj;
        return (this.Blatttyp == tmp.Blatttyp && this.Blattwert == tmp.Blattwert);
    }

    @Override
    public String toString() {
        return this.Blatttyp.name() + "-" + this.Blattwert.name();
    }
}
