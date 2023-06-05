package Notenrechnerv2;

public class main{
public static void main(String[] args)  {

    Lehrer lehrer=new Lehrer();

    // fächer anlegen
    lehrer.addFach("Mathe");
    lehrer.addFach("Deutsch");
    lehrer.addFach("Englisch");
    lehrer.addFach("toberemoved");
    lehrer.addFach("tobeedited");
    System.out.println(lehrer.toString());
    
    // fächer bearbeiten
    lehrer.editFach("tobeedited","edited" );
    
    // fächer löschen
    //lehrer.removeFach("Mathe");
    System.out.println(lehrer.toString());
    lehrer.removeFach("toberemoved");

    //Schüler anlegen

    lehrer.addSchüler("Simon");
    lehrer.addSchüler("Jonas");

    //Schüler bearbeiten
    lehrer.editSchüler("Simon","David");

    //Schüler löschen
    lehrer.removeSchüler("Simon");

    //Test anlegen
    lehrer.addTest("Deutsch","Klassenarbeit" );
    lehrer.addTest("Mathe","Epochalnote");
    lehrer.addTest("Deutsch","Epochalnote");
    lehrer.addTest("Mathe","HUE");
    //gleichnamige Tests in verschiedenen Faechern wird nur das erste Objekt mit dem Testname gespeichert

    System.out.println(lehrer.toString());
    //Test bearbeiten
    //lehrer.editTest("Epochalnote", "Epo");

    //Test loeschen
    //lehrer.removeTest("HUE");

    System.out.println(lehrer.toString());

    
}
}