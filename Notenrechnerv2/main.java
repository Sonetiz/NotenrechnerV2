package Notenrechnerv2;

public class main{
public static void main(String[] args)  {

    Lehrer lehrer=new Lehrer();

    // fächer anlegen
    lehrer.addFach("Mathe");
    lehrer.addFach("Deutsch");
    lehrer.addFach("Englisch");
    
    
    // fächer bearbeiten
    lehrer.editFach("Englisch","Mathe" );
    
    // fächer löschen
    lehrer.removeFach("Mathe");
    System.out.println(lehrer.toString());
    lehrer.removeFach("Mathe");

    //Schüler anlegen

    lehrer.addSchüler("Simon");
    lehrer.addSchüler("Jonas");

    //Schüler bearbeiten
    lehrer.editSchüler("Simon","David");

    //Schüler löschen
    lehrer.removeSchüler("Simon");

System.out.println(lehrer.toString());

    
}
}