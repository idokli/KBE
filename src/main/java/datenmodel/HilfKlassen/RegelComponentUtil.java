package datenmodel.HilfKlassen;

import datenmodel.Spieler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RegelComponentUtil {

    private List<Spieler> spielerListe;

    private int anzahlKartenZuZiehen;

}
