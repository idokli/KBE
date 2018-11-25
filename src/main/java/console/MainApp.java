package console;

import config.AppConfig;
import datenmodel.Enum.RegelKompTyp;
import datenmodel.Enum.SpielTyp;
import datenmodel.Exceptions.MauMauException;
import datenmodel.Spiel;
import komponenten.SpielSteuerung.impl.SpielSteuerungImpl;
import komponenten.SpielVerwaltung.impl.SpielVerwaltungImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) throws MauMauException {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SpielVerwaltungImpl spielVerwaltung = context.getBean(SpielVerwaltungImpl.class);

        Spiel spiel = spielVerwaltung.starteNeuesSpiel(SpielTyp.MauMau, RegelKompTyp.OHNE_SONDER_REGEL);

        SpielSteuerungImpl spielSteuerung = context.getBean(SpielSteuerungImpl.class);

        spielSteuerung.fragWerDaranIst();

    }
}
