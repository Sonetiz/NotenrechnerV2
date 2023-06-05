package Notenrechnerv2;
import java.util.ArrayList;

public class Lehrer {
    //Fach 
    //Schüler
    //Test
    private ArrayList<String> Fachliste=new ArrayList<String>();
    private ArrayList<String> Schülerliste=new ArrayList<String>();
    private ArrayList<String> Testliste=new ArrayList<String>();
    public Lehrer(){

    }
    
    
    
    public void addFach(String Fachname){
        Fach myFach=new Fach(Fachname);
    }
}
