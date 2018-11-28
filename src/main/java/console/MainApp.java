package console;

import config.AppConfig;
import datenmodel.Enum.RegelKompTyp;
import datenmodel.Enum.SpielTyp;
import datenmodel.Exceptions.MauMauException;
import datenmodel.Spiel;
import datenmodel.Spieler;
import datenmodel.Spielrunde;
import komponenten.SpielSteuerung.impl.SpielSteuerungImpl;
import komponenten.SpielVerwaltung.impl.SpielVerwaltungImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) throws MauMauException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SpielVerwaltungImpl spielVerwaltung = context.getBean(SpielVerwaltungImpl.class);

        Spiel spiel = spielVerwaltung.starteNeuesSpiel(SpielTyp.MauMau, RegelKompTyp.OHNE_SONDER_REGEL);

        List<Spieler> spielerListe = new ArrayList<Spieler>();
        spielerListe.add(new Spieler("Ido"));
        spielerListe.add(new Spieler("Victor"));
        spielerListe.add(new Spieler("Lucas"));

        Spielrunde spielrunde = spielVerwaltung.starteSpielrunde(spielerListe, spiel);


        SpielSteuerungImpl spielSteuerung = context.getBean(SpielSteuerungImpl.class);

        for(Spieler spieler : spielerListe) {
            spielSteuerung.zieheKartenVomStapel(spieler, 6);
        }

        spielVerwaltung.beendeSpielrunde(spielrunde);

        spielVerwaltung.beendeSpiel(spiel);



    }
}
