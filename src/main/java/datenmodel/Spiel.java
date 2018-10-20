package datenmodel;

import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

@Getter
@Setter
public class Spiel  extends  BaseEntity{

    private Date beginn;

    private long dauer;

    private List<Spieler> spielerListe;

    public Spiel() {
        this.beginn = new Date();
    }

    public void registriereSpieler(final Spieler spieler) {
        if(CollectionUtils.isEmpty(this.spielerListe)) {
            spielerListe = new ArrayList<Spieler>();
        }
        this.spielerListe.add(spieler);
    }
}
