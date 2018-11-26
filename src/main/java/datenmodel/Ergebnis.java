
package datenmodel;


import datenmodel.HilfKlassen.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@Entity
public class Ergebnis extends BaseEntity {

    @Column
    private int Punkte;


    @OneToOne
    private Spielrunde spielrunde;

    @OneToOne
    private Spieler spieler;
}
