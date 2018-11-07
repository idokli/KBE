package Komponenten.SpielregelKomponent.export;

import datenmodel.Enum.Regel;
import datenmodel.Spielkarte;

public interface ISpielregel {

    Regel getRegelFuerKarte(Spielkarte spielkarte);

    boolean istKarteAuflegbar(Spielkarte vorherigeSpielkarte, Spielkarte aktuelleSpielkarte);
}
