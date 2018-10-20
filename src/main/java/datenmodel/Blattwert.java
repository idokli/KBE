package datenmodel;

public enum Blattwert {

    Joker(30),

    Ass(11),

    Zwei(2),

    Drei(3),

    Vier(4),

    Fuenf(5),

    Sechs(6),

    Sieben(7),

    Acht(8),

    Neun(9),

    Zehn(10),

    Bube(20),

    Dame(10),

    Koenig(10);

    private final int blattWertZahl;

    Blattwert(int blattWertZahl) {

        this.blattWertZahl = blattWertZahl;
    }

    public int getIntWert() {
        return this.blattWertZahl;
    }

}
