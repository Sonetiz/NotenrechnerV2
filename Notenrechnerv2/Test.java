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
    

    
}
