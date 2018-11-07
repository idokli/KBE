package Komponenten.SpielregelKomponent;

import datenmodel.Enum.Regel;
import datenmodel.Spielkarte;

public interface ISpielregelKomponent {

    Regel getRegelFuerKarte(Spielkarte spielkarte);
}
