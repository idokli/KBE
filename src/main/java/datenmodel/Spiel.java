package datenmodel;

import datenmodel.HilfKlassen.BaseEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class Spiel extends BaseEntity {

    private Date beginn;

    private long dauer;

    private List<Spielrunde> spielrunden;

}
