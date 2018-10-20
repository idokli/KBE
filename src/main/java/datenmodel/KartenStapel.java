package datenmodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KartenStapel {

    private List<Spielkarte> stapel;

    public KartenStapel() {
        this.stapel = new ArrayList<Spielkarte>();
    }


    public int getStapelSize() {

        return this.stapel.size();
    }

    public boolean isEmpty() {

        return this.stapel.size() == 0;
    }


    // Für aufgedeckten Stapel
    public void addeSpielkarte(Spielkarte spielkarte) {

        this.stapel.add(spielkarte);
    }

    // Für aufgedeckten Stapel
    public Spielkarte getAufgelegteKarte() throws MauMauException {
        if (this.isEmpty()) {
            throw new MauMauException("Stapel ist leer");
        }

        Spielkarte spielkarte = this.stapel.get(this.stapel.size() - 1);
        return spielkarte;
    }

    // Für verdeckten Stapel
    public Spielkarte getNeueSpielkarte() throws MauMauException {
        if (this.isEmpty()) {
            throw new MauMauException("Stapel ist leer");
        }

        Spielkarte spielkarte = this.stapel.get(this.stapel.size() - 1);
        this.stapel.remove(this.stapel.size() - 1);
        return spielkarte;
    }

    public void baueStapel() {
        for (Blatttyp blatttyp : Blatttyp.values()) {
            for (Blattwert blattwert : Blattwert.values()) {
                this.stapel.add(new Spielkarte(blatttyp, blattwert));
            }
        }
    }

    public void entleereStapel() {
        this.stapel.clear();
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
