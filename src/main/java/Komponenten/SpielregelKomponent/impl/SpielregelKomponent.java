package Komponenten.SpielregelKomponent.impl;

import Komponenten.SpielregelKomponent.export.ISpielregelKomponent;
import datenmodel.Enum.Regel;
import datenmodel.Spielkarte;

public class SpielregelKomponent implements ISpielregelKomponent {

    private boolean zwei_ziehen_aktiv;
    private Spielkarte zwei_ziehen_karte;
    private boolean aussetzen_aktiv;
    private Spielkarte aussetzen_karte;
    private boolean wuenscher_aktiv;
    private Spielkarte wuenscher_karte;
    private boolean richtungswechsel_aktiv;
    private Spielkarte richtungswechsel_karte;
    private boolean stopper_aktiv;
    private Spielkarte stopper_karte;
    private boolean allesleger_aktiv;
    private Spielkarte allesleger_karte;

    public SpielregelKomponent(boolean zwei_ziehen_aktiv, Spielkarte zwei_ziehen_karte,
                               boolean aussetzen_aktiv, Spielkarte aussetzen_karte,
                               boolean wuenscher_aktiv, Spielkarte wuenscher_karte,
                               boolean richtungswechsel_aktiv, Spielkarte richtungswechsel_karte,
                               boolean stopper_aktiv, Spielkarte stopper_karte,
                               boolean allesleger_aktiv, Spielkarte allesleger_karte) {

        this.zwei_ziehen_aktiv = zwei_ziehen_aktiv;
        this.zwei_ziehen_karte = zwei_ziehen_karte;
        this.aussetzen_aktiv = aussetzen_aktiv;
        this.aussetzen_karte = aussetzen_karte;
        this.wuenscher_aktiv = wuenscher_aktiv;
        this.wuenscher_karte = wuenscher_karte;
        this.richtungswechsel_aktiv = richtungswechsel_aktiv;
        this.richtungswechsel_karte = richtungswechsel_karte;
        this.stopper_aktiv = stopper_aktiv;
        this.stopper_karte = stopper_karte;
        this.allesleger_aktiv = allesleger_aktiv;
        this.allesleger_karte = allesleger_karte;
    }

    public Regel getRegelFuerKarte(Spielkarte spielkarte) {
        return null;
    }
}
