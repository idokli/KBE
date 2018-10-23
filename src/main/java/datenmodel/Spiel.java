package datenmodel;

import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.List;


@Getter
@Setter
public class Spiel  extends  BaseEntity{

    private Date beginn;

    private long dauer;

    private List<Spielrunde> spielrunden;

    public Spiel() {
        this.beginn = new Date();
    }

}
