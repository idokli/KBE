
package datenmodel;

import datenmodel.Enum.Blatttyp;
import datenmodel.Enum.Blattwert;
import datenmodel.Enum.Regel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spielkarte {

    private datenmodel.Enum.Blattwert Blattwert;

    private datenmodel.Enum.Blatttyp Blatttyp;

    private Regel regel;

    public Spielkarte(Blatttyp blatttyp, Blattwert blattwert) {

        this.Blatttyp = blatttyp;
        this.Blattwert = blattwert;
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
