
package datenmodel;

import datenmodel.Enum.Blatttyp;
import datenmodel.Enum.Blattwert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Spielkarte {

    private Blattwert blattwert;

    private Blatttyp blatttyp;

    @Override
    public String toString() {
        return blattwert + " " + blatttyp;
    }
}
