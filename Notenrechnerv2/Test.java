package Notenrechnerv2;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public Long id;
    public String Fach;
    public String Testname;
    //Schueler->Note 0-15 Pkt
    public Map<String,Integer> Testmap=new HashMap<>();
    public Test(Long ID,String fachString,String testString){
        id=ID;
        Fach=fachString;
        Testname=testString;
        

    }
    

    
}
