package datenmodell;

public enum Blattwert {

	Joker(0),

	Ass(1),

	Zwei(2),

	Drei(3),

	Vier(4),

	Fuenf(5),

	Sechs(6),

	Sieben(7),

	Acht(8),

	Neun(9),

	Zehn(10),

	Bube(11),

	Dame(12),

	Koenig(13);

	private final int blattWertZahl;

	Blattwert(int blattWertZahl) {
		this.blattWertZahl = blattWertZahl;
	}

	public int getIntWert(Blattwert blattwert) {
		return blattwert.blattWertZahl;
	}

};
