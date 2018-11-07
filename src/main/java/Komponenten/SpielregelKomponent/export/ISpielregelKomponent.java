package Komponenten.SpielregelKomponent.export;

import datenmodel.Enum.Regel;
import datenmodel.Spielkarte;

public interface ISpielregelKomponent {

    Regel getRegelFuerKarte(Spielkarte spielkarte);
}
