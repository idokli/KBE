package console;

import datenmodel.Enum.RegelKompTyp;
import datenmodel.Enum.SpielTyp;
import datenmodel.Spieler;
import datenmodel.Spielrunde;
import komponenten.Spielregel.export.ISpielregel;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUtil {

    public ArrayList<Spieler> spielerEingabe(Scanner sc){
        ArrayList<Spieler> spielerList = new ArrayList<>(0);
        boolean nochSpieler = true;
        System.out.println("Bitte geben Sie die Namen der Spieler:");
        do {
            System.out.println("Bitte geben Sie den "+(spielerList.size()+1)+"er Namen:");
            String name = sc.nextLine();
            spielerList.add(new Spieler(name));

            System.out.println("Wollen Sie noch einen Spieler ins Spiel eintragen? (y|n)");
            String antwort = sc.nextLine();
            if(!antwort.equals("y")){
                if(spielerList.size() > 1){
                    nochSpieler = false;
                } else {
                    System.out.println("Ein Spiel muss mindestens 2 Spieler haben");
                }
            }
        }while(nochSpieler);

        return spielerList;
    }

    public RegelKompTyp regelWahl(Scanner sc,
                                  ISpielregel spielregelohneSonder,
                                  ISpielregel spielregelBasicSonder,
                                  ISpielregel spielregelAlleSonder){
        int wahl;
        boolean richtigeEingabe;

        printChoices(RegelKompTyp.values(), "Mit welchen Regeln wollen Sie spielen?" );

        do{
            wahl = sc.nextInt();
            if(wahl > RegelKompTyp.values().length || wahl < 0){
                System.out.println("Bitte geben Sie einen der zulässigen Werte");
                richtigeEingabe = false;
            } else {
                richtigeEingabe = true;
            }
        } while (!richtigeEingabe);

        return (RegelKompTyp.values()[wahl]);

//        switch (RegelKompTyp.values()[wahl]){
//            case OHNE_SONDER_REGEL:
//                return spielregelohneSonder ;
//            case MIT_BASIC_SONDER_REGEL:
//                return spielregelBasicSonder ;
//            case ALL_SONDER_REGEL:
//                return spielregelAlleSonder ;
//            default:
//                return spielregelohneSonder;
//        }
    }

    public SpielTyp spielTypWahl(Scanner sc){

        int wahl;
        boolean richtigeEingabe;

        printChoices(SpielTyp.values() , "Welches Spiel wollen Sie spielen?");

        do{
            wahl = sc.nextInt();
            if(wahl > SpielTyp.values().length || wahl < 0){
                System.out.println("Bitte geben Sie einen der zulässigen Werte");
                richtigeEingabe = false;
            } else {
                richtigeEingabe = true;
            }
        } while (!richtigeEingabe);

        return SpielTyp.values()[wahl];
    }

    private <T> void printChoices(T[] values, String msg) {
        int counter = 0;
        System.out.println(msg);
        for (T typ : values) {
            System.out.println("Wählen Sie " +counter+ " für " + typ.toString());
            counter++;
        }
    }

    public void spielZug(Spielrunde spielrunde, Spieler spieler) {
        System.out.println("Der jetzige Spieler ist " + spieler.getName());
        System.out.println("Der jetzige Spieler ist " + spieler.getName());

    }
}
