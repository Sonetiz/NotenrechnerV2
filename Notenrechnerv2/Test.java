package Notenrechnerv2;

import java.util.HashMap;
import java.util.Map;
//die Test Objekte speichern den eigenen Namen, das Fach dem sie zugeordnet sind und eine Hashmap die Schülern ihren Noten zuordnet

public class Test {
    
    public String Fach;
    public String Testname;
    //Schueler->Note 0-15 Pkt
    public Map<String,Integer> Testmap=new HashMap<>();
    public Test(String fachString,String testString){
        
        Fach=fachString;
        Testname=testString;
        

    }

    //addSchueler(Schueler)
    public void addSchueler(String Schuelername){
        //prüft ob der Schüler schon vorhanden ist 
        if(Testmap.containsKey(Schuelername)){
            return;
        }
        //fügt den Schüler der Hashmap hinzu mit einer Platzhalternote -1
        //generell ist die Note -1 der Output bei falschen eingabewerten
        Testmap.put(Schuelername,-1);
    }
    
    //removeSchueler(Schueler)

    public void removeSchueler(String Schuelername){
        if(!Testmap.containsKey(Schuelername)){
            return;
        }
        //prüft ob der Schüler existiert und löscht ihn ggf
        Testmap.remove(Schuelername);
    }
    //getSchuelers()
    public String[] getSchuelers(){
        //prüft ob überhaupt schüler eingetragen wurden
        if(Testmap.isEmpty()){
            return new String[0];
        }
        //returned alle Keys der Hashmap(Schüler)als Array mit der göße=größe der Hashmap
        return Testmap.keySet().toArray(new String[Testmap.keySet().size()]);
        
        
    }
    
    //addNote(Schueler,Note)
    public void addNote(String schuelerString,int Note){
        if(!Testmap.containsKey(schuelerString)){
            return;
        }
        //prüft ob der Schüler diesem Test zugeordnet wurde
        Testmap.put(schuelerString,Note);
    }
    //editNote(Schueler,Note)
    public void editNote(String SchuelerString,int newNote){
        if(!Testmap.containsKey(SchuelerString)){
            return;
        }
        //prüft ob der Schüler einen eintrag in der Hashmap hat und ersetzt diesen
        Testmap.replace(SchuelerString,newNote);
        
    }
    //removeNote(Schueler)
    public void removeNote(String schuelerString){
        if(!Testmap.containsKey(schuelerString)){
            return;
        }
        //prüft ob der Eintrag existiert und setzt diesen ggf = Platzhalternote
        Testmap.put(schuelerString,-1);
    }
    //getNote(Schuler)
    public int getNote(String schuelerString){
        if(!Testmap.containsKey(schuelerString)){
            return-1;
        }
        //prüft ob der Schüler in der NotenMap existiert und returned den eingetragenen Notenwert
        return Testmap.get(schuelerString);
    }

    //isSchuelerpresent(Schueler)
    public boolean isSchuelerpresent(String Schuelerstring){
        return Testmap.containsKey(Schuelerstring);
        //prüft ob der SChüler in der Map vorhanden ist
        }
        
    //getTestaverage()
    public int getTestaverage(){
        int anzahl=0;
        int total=0;
        //init temporäre werte zu errechnung des Durchschnitts
        for(String Schueler :Testmap.keySet()){
            //nutzt Lambda um über das Keyset der Testmap zu iterieren
            if(Testmap.get(Schueler)!=-1){
                //wenn ein Eintrag existiert welcher nicht= Platzhalternote dann wird die Anzahl um 1 erhöht und der total wert um die Note des Eintrags erhöht
                anzahl++;
                total+=Testmap.get(Schueler);

            }

        }
        //selbsterklärend
        if(anzahl==0){
            return -1;
        }
        return total/anzahl;
    }
    
}
