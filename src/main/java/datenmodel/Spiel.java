package datenmodel;

import datenmodel.Enum.RegelKompTyp;
import datenmodel.Enum.SpielTyp;
import datenmodel.HilfKlassen.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
public class Spiel extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private SpielTyp spielTyp;

    @Column
    @Enumerated(EnumType.STRING)
    private RegelKompTyp regelKompTyp;

    @Column
    private Date beginn;

    @Column
    private long dauer;

    @OneToMany
    private List<Spielrunde> spielrunden;

}
