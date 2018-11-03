package Komponenten.SpielregelKomponent;

import datenmodel.Enum.Regel;
import datenmodel.Spielkarte;

public interface ISpielregelKomponent {

    boolean konfigurierRegelFuerSpiel(Boolean zwei_ziehen_aktiv, Spielkarte zwei_ziehen_karte,
                                      Boolean aussetzen_aktiv, Spielkarte aussetzen_karte,
                                      Boolean wuenscher_aktiv, Spielkarte wuenscher_karte,
                                      Boolean richtungswechsel_aktiv, Spielkarte richtungswechsel_karte,
                                      Boolean stopper_aktiv, Spielkarte stopper_karte,
                                      Boolean allesleger_aktiv, Spielkarte allesleger_karte);

    Regel getRegelFuerKarte(Spielkarte spielkarte);
}
