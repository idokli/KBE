package datenmodel.Enum;

public enum Regel {

    ZWEI_ZIEHEN,

    AUSSETZEN,

    WUENSCHER,

    RICHTUNGSWECHSEL,

    // Hebt die Funktion von ZWEI_ZIEHEN auf
    STOPPER,

    // Darf auf jede Karte gelegt werden (aber nicht auf einem anderen Allesleger)
    ALLESLEGER,

    KEIN;

}
