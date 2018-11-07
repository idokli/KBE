
package datenmodel;

import datenmodel.Enum.Blatttyp;
import datenmodel.Enum.Blattwert;
import lombok.Data;

@Data
public class Spielkarte {

    private Blattwert Blattwert;

    private Blatttyp Blatttyp;

}
