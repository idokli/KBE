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
import java.util.Scanner;

public class MainApp {

//    // Die spezifische Implementierung muss definiert werden
//    @Autowired
//    @Qualifier("ohneSonder")
    private static ISpielregel spielregelohneSonder;
//
//    @Autowired
//    @Qualifier("basicSonder")
    private static ISpielregel spielregelBasicSonder;
//
//    @Autowired
//    @Qualifier("alleSonder")
    private static ISpielregel spielregelAlleSonder;

    static Scanner sc = new Scanner(System.in);

    static ConsoleUtil consoleUtil = new ConsoleUtil();

    public static void main(String[] args) throws MauMauException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SpielVerwaltungImpl spielVerwaltung = context.getBean(SpielVerwaltungImpl.class);

        SpielSteuerungImpl spielSteuerung = context.getBean(SpielSteuerungImpl.class);

        SpielTyp spielTyp = consoleUtil.spielTypWahl(sc);

        RegelKompTyp gewaehlteSpielegel = consoleUtil.regelWahl
                (sc, spielregelohneSonder, spielregelBasicSonder, spielregelAlleSonder);

        Spiel spiel = spielVerwaltung.starteNeuesSpiel(spielTyp, gewaehlteSpielegel);

        ArrayList<Spieler> spielerListe = consoleUtil.spielerEingabe(sc);

        Spielrunde spielrunde = spielVerwaltung.starteSpielrunde(spielerListe, spiel);

        Spieler spieler = spielSteuerung.fragWerDranIst(spielrunde.getSpielerListe());

        consoleUtil.spielZug(sc, spielrunde, spieler);

//        spielVerwaltung.beendeSpielrunde(spielrunde);
//
//        spielVerwaltung.beendeSpiel(spiel);






    }

}
