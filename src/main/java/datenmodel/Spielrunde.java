// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package datenmodel;

import datenmodel.Enum.Blatttyp;
import datenmodel.HilfKlassen.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Spielrunde extends BaseEntity {

    @ManyToOne
    private Spiel spiel;

    @Column
    private String gewinnerName;

    @Column
    private Date start;

    @Column
    private long dauer;

    // Stapel mit verdeckten karten
    @Embedded
    private List<Spielkarte> verdeckteStapel;

    // Stapel mit aufgelegten Karten
    @Embedded
    private List<Spielkarte> aufgelegtStapel;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "spielrunde", orphanRemoval = true)
    private List<Ergebnis> ergebnisListe;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "spielrunde", orphanRemoval = true)
    private List<Spieler> spielerListe;

    @Column
    @Enumerated(EnumType.STRING)
    private Blatttyp rundeFarbe;

    @Column
    private Integer zuZiehnKartenAnzahl;

    public Spielrunde(Spiel spiel) {
        this.spiel = spiel;
        this.start = new Date();
        this.spielerListe = new ArrayList<>();
        this.ergebnisListe = new ArrayList<>();
    }

}
