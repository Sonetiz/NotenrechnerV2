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
    //addNote(Schueler,Note)
    //editNote(Schueler,Note)
    //getNote(Schuler)
    //getTestaverage()
    //getSchuelers()
    public String[] getSchuelers(){
        if(Testmap.isEmpty()){
            return new String[0];
        }
        return Testmap.keySet().toArray(new String[Testmap.keySet().size()]);
            
        
    }

    
}
