package datenmodel;

import datenmodel.HilfKlassen.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
public class Spieler extends BaseEntity {

	@Embedded
	private List<Spielkarte> hand;

	@Column
	private String name;

	@Column
	private boolean spielend;
	
	public Spieler(String name) {
		this.hand = new ArrayList<Spielkarte>();
		this.name = name;
	}

	public Spieler() {
	}
}
