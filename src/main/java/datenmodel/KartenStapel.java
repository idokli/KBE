package datenmodel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Embeddable
public class KartenStapel {

    @Embedded
    private List<Spielkarte> stapel;

    public KartenStapel() {
        this.stapel = new ArrayList<Spielkarte>();
    }

    @Override
    public String toString() {
        String s = "";
        int count = 0;
        for (Spielkarte spielkarte : this.stapel) {
            s += count + 1 + ". " + this.stapel.get(count).toString();
            s += "\n";
        }

        return s;
    }

}
