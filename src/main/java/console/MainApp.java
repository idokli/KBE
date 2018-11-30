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
import komponenten.Spielregel.export.ISpielregel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

    // Die spezifische Implementierung muss definiert werden
    @Autowired
    @Qualifier("ohneSonder")
    private ISpielregel spielregelohneSonder;

    @Autowired
    @Qualifier("basicSonder")
    private ISpielregel spielregelBasicSonder;

    @Autowired
    @Qualifier("alleSonder")
    private ISpielregel spielregelAlleSonder;

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

        spielVerwaltung.beendeSpielrunde(spielrunde);

        spielVerwaltung.beendeSpiel(spiel);



    }
}
