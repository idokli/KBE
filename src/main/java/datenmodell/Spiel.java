// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package datenmodell;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Spiel extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private Date Datum;
	
	@Column
	private Date beginn;

	@Column
	private Date ende;
	
	@Column
	private long dauer;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="spiel", orphanRemoval = true)
	private List<Spieler> spielerListe;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="spiel", orphanRemoval = true)
	private List<Spielrunde> spielrunden;
	
	
	public Spiel() {
		this.Datum = new Date();
		this.beginn = new Date();
	}
	
	public void registriereSpieler(Spieler spieler) {
		if (this.spielerListe == null) {
			this.spielerListe = new ArrayList<Spieler>();
		}
		this.spielerListe.add(spieler);
		spieler.setSpiel(this);
	}
	
	public void erstelleRunde() {
		if(spielrunden == null) {
			spielrunden = new ArrayList<Spielrunde>();
		}
		Spielrunde spielrunde = new Spielrunde();
		spielrunden.add(spielrunde);
		spielrunde.setSpiel(this);
	}
};
