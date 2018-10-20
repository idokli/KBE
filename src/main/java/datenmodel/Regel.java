package datenmodel;

public enum Regel {

    ZWEI_ZIEHEN(Blattwert.Sieben),

    AUSSETZEN(Blattwert.Ass),

    WUENSCHER(Blattwert.Bube),

    RICHTUNGSWECHSEL(Blattwert.Neun),

    // Hebt die Funktion von ZWEI_ZIEHEN auf
    STOPPER(Blattwert.Acht),

    // Darf auf jede Karte gelegt werden (aber nicht auf einem anderen Allesleger)
    ALLESLEGER(Blattwert.Zehn);


    private final Blattwert blattwert;

    Regel(Blattwert blattwert) {

        this.blattwert = blattwert;
    }

    public Blattwert getBlattwert() {
        return this.blattwert;
    }


}
