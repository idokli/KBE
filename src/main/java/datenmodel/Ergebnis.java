
package datenmodel;


import datenmodel.HilfKlassen.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ergebnis extends BaseEntity {

    @Column
    private int Punkte;

    @ManyToOne
    private Spielrunde spielrunde;

    @OneToOne
    private Spieler spieler;


}
