
package datenmodel;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Ergebnis {


	private int Punkte;


	private Spielrunde spielrunde;


	private List<Spieler> spieler;
};
