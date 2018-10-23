package datenmodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

@Getter
@Setter
public class KartenStapel {

    private List<Spielkarte> stapel;

    public KartenStapel() {
        this.stapel = new ArrayList<Spielkarte>();
    }


    public void addeSpielkarte(Spielkarte spielkarte) {
        if (!CollectionUtils.isEmpty(this.stapel)) {
            this.stapel.add(spielkarte);
        }
    }

    // Für aufgedeckten Stapel
    public Spielkarte getLetzteAufgelegteKarte() throws MauMauException {
        if (!CollectionUtils.isEmpty(this.stapel)) {
            throw new MauMauException("Stapel ist leer");
        }

        Spielkarte spielkarte = this.stapel.get(this.stapel.size() - 1);
        return spielkarte;
    }

    // Für verdeckten Stapel
    public Spielkarte getNeueSpielkarte() throws MauMauException {
        if (!CollectionUtils.isEmpty(this.stapel)) {
            throw new MauMauException("Stapel ist leer");
        }

        Spielkarte spielkarte = this.stapel.get(this.stapel.size() - 1);
        this.stapel.remove(this.stapel.size() - 1);
        return spielkarte;
    }


    public void mischeKarten() throws MauMauException {
        if (!this.stapel.isEmpty()) {
            Collections.shuffle(this.stapel);
        } else {
            throw new MauMauException("Stapel ist leer");
        }
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
