package datenmodel;

import datenmodel.Enum.RegelKompTyp;
import datenmodel.Enum.SpielTyp;
import datenmodel.HilfKlassen.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
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

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "spiel", orphanRemoval = true)
    private List<Spielrunde> spielrunden;

    public Spiel(SpielTyp spielTyp, RegelKompTyp regelKompTyp) {
        this.spielTyp = spielTyp;
        this.regelKompTyp = regelKompTyp;
        this.beginn = new Date();
        this.spielrunden = new ArrayList<>();
    }

}
