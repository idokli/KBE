
package datenmodel;

import datenmodel.Enum.Blatttyp;
import datenmodel.Enum.Blattwert;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Spielkarte {

    private Blattwert Blattwert;

    private Blatttyp Blatttyp;



}
