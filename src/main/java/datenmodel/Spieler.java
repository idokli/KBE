package datenmodel;

import datenmodel.HilfKlassen.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Spieler extends BaseEntity {

	private List<Spielkarte> hand;
	private String name;
	private boolean spielend;
	
	public Spieler(String name) {
		this.hand = new ArrayList<Spielkarte>();
		this.name = name;
	}

}
