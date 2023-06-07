package Notenrechnerv2;

import java.util.HashMap;
import java.util.Map;

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
        if(Testmap.containsKey(Schuelername)){
            return;
        }
        Testmap.put(Schuelername,-1);
    }
    
    //removeSchueler(Schueler)

    public void removeSchueler(String Schuelername){
        if(!Testmap.containsKey(Schuelername)){
            return;
        }
        Testmap.remove(Schuelername);
    }
    //getSchuelers()
    public String[] getSchuelers(){
        if(Testmap.isEmpty()){
            return new String[0];
        }
        return Testmap.keySet().toArray(new String[Testmap.keySet().size()]);
        
        
    }
    
    //addNote(Schueler,Note)
    public void addNote(String schuelerString,int Note){
        if(!Testmap.containsKey(schuelerString)){
            return;
        }
        Testmap.put(schuelerString,Note);
    }
    //editNote(Schueler,Note)
    public void editNote(String SchuelerString,int newNote){
        if(!Testmap.containsKey(SchuelerString)){
            return;
        }
        Testmap.put(SchuelerString,newNote);
    }
    //removeNote(Schueler)
    public void removeNote(String schuelerString){
        if(!Testmap.containsKey(schuelerString)){
            return;
        }
        Testmap.put(schuelerString,-1);
    }
    //getNote(Schuler)
    public int getNote(String schuelerString){
        if(!Testmap.containsKey(schuelerString)){
            return-1;
        }
        return Testmap.get(schuelerString);
    }

    //isSchuelerpresent(Schueler)
    public boolean isSchuelerpresent(String Schuelerstring){
        return Testmap.containsKey(Schuelerstring);
        }
        
    //getTestaverage()
    public int getTestaverage(){
        int anzahl=0;
        int total=0;
        for(String Schueler :Testmap.keySet()){
            if(Testmap.get(Schueler)!=-1){
                anzahl++;
                total+=Testmap.get(Schueler);

            }

        }
        return total/anzahl;
    }
    
}
