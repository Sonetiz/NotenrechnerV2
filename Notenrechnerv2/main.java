package Notenrechnerv2;

public class main{
    //diese Main Methode dient lediglich dem Debugging während der entwicklung
public static void main(String[] args)  {

    Lehrer lehrer=new Lehrer();

    // fächer anlegen
    lehrer.addFach("Mathe");
    lehrer.addFach("Deutsch");
    lehrer.addFach("Englisch");
    lehrer.addFach("toberemoved");
    lehrer.addFach("tobeedited");
    //System.out.println(lehrer.toString());
    
    // fächer bearbeiten
    lehrer.editFach("tobeedited","edited" );
    
    // fächer löschen
    //lehrer.removeFach("Mathe");
    //System.out.println(lehrer.toString());
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

    //System.out.println(lehrer.toString());
    //Test bearbeiten
    lehrer.editTest("Mathe","Epochalnote", "Epo");

    //Test loeschen
    lehrer.removeTest("Mathe","HUE");

    System.out.println(lehrer.toString());
    //Test converters
    //System.out.println(lehrer.convertfromMSS(14));
    //System.out.println(lehrer.convertfromMSS(8));
    //System.out.println(lehrer.converttoMSS(14));
    //System.out.println(lehrer.convertfromMSS(2));
    //Test addSchueler
    lehrer.addSchüler("Simon");
    lehrer.addSchüler("Max");
    lehrer.addSchüler("Tobedeleted");
    lehrer.addSchuelertoTest("Mathe", "Epo", "Jonas");
    lehrer.addSchuelertoTest("Mathe", "Epo", "Simon");
    lehrer.addSchuelertoTest("Mathe", "Epo", "Max");
    lehrer.addSchuelertoTest("Mathe", "Epo", "Tobedeleted");
    //Test getSchuelers
    lehrer.removeSchuelerfromTest("Mathe", "Epo", "Tobedeleted");

    //Test add note &&getNote
    lehrer.TestaddNote("Mathe", "Epo", "Simon", 2);
    lehrer.TestaddNote("Mathe", "Epo", "Jonas", 3);
    lehrer.TestaddNote("Mathe", "Epo", "Max", 1);
    lehrer.TesteditNote("Mathe", "Epo", "Jonas", 4);
    //lehrer.TestremoveNote("Mathe", "Epo", "Jonas");
    //Test add Schueler to different  Fach to Test getSchuelersfromFach
    lehrer.addSchüler("Deutschtester");
    lehrer.addSchuelertoTest("Deutsch", "Klassenarbeit", "Deutschtester");
    
    
    //System.out.println(lehrer.getSchuelersfromFach("Deutsch"));



    //System.out.println(lehrer.toString("Mathe", "Epo"));
    
    //System.out.println(lehrer.Testgetaverage("Mathe", "Epo"));
    //System.out.println(lehrer.getSchuelersfromTest("Mathe", "Epo").length);
    
    //Test Zeugnisnote
    lehrer.addTest("Mathe", "Klassenarbeit");
    lehrer.addTest("Mathe","Projekt");
    lehrer.addSchuelertoTest("Mathe", "Klassenarbeit", "Simon");
    lehrer.addSchuelertoTest("Mathe", "Projekt", "Simon");
    lehrer.TestaddNote("Mathe", "Klassenarbeit", "Simon", 1);
    lehrer.TestaddNote("Mathe", "Projekt", "Simon", 4);
    
    System.out.println("Zeugnisnote Simon:");
    System.out.println(lehrer.getZeugnisnote("Mathe", "Simon"));
    
}
}