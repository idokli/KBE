
package datenmodel;

import datenmodel.Enum.Blatttyp;
import datenmodel.Enum.Blattwert;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@Embeddable
public class Spielkarte {

    private Blattwert Blattwert;

    private Blatttyp Blatttyp;


    public Spielkarte() {
    }
}
