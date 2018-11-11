package datenmodel;

import datenmodel.Enum.RegelKompTyp;
import datenmodel.Enum.SpielTyp;
import datenmodel.HilfKlassen.BaseEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class Spiel extends BaseEntity {

    private SpielTyp spielTyp;

    private RegelKompTyp regelKompTyp;

    private Date beginn;

    private long dauer;

    private List<Spielrunde> spielrunden;

}
