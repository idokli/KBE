package datenmodell;

public enum Blattwert {

	/**
	 * 
	 */
	Eins(1),
	/**
	 * 
	 */
	Zwei(2),
	/**
	 * 
	 */
	Drei(3),
	/**
	 * 
	 */
	Vier(4),
	/**
	 * 
	 */
	Fuenf(5),
	/**
	 * 
	 */
	Sechs(6),
	/**
	 * 
	 */
	Sieben(7),
	/**
	 * 
	 */
	Acht(8),
	/**
	 * 
	 */
	Neun(9),
	/**
	 * 
	 */
	Zehn(10),
	/**
	 * 
	 */
	Joker(11),
	/**
	 * 
	 */
	Queen(12),
	/**
	 * 
	 */
	King(13);
	/**
	 * 
	 */
	
	private final int blattWertZahl;
	
	Blattwert (int blattWertZahl) {
		this.blattWertZahl = blattWertZahl;
	}
	
	public int getIntWert(Blattwert blattwert) {
		return blattwert.blattWertZahl;
	}
	

};
