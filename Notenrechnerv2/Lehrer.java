package Notenrechnerv2;
import java.util.ArrayList;


public class Lehrer {
    //Fach 
    //Schüler
    //Test
    private ArrayList<Fach> Fachliste=new ArrayList<Fach>();
    private ArrayList<Schüler> Schülerliste=new ArrayList<Schüler>();
    private ArrayList<Test> Testliste=new ArrayList<Test>();
    public Lehrer(){

    }
    
    
    
    public void addFach(String Fachname){
        if(isFachPresent(Fachname)){
            return;
        }
        Fach myFach=new Fach(Fachname);
        Fachliste.add(myFach);

    }
    public void removeFach(String Fachname){
        //Fachliste durchiterieren
        int index=getindexOfFach(Fachname);
        if(index==-1){
            return;
        }
        //Fach aus Fachlist löschen
        Fachliste.remove(index);

    }
    public void editFach(String Istfachname, String Sollfachname){
        if(isFachPresent(Sollfachname)){
            return;
        }
        int index=getindexOfFach(Istfachname);
        if(index==-1){
            return;
        }
        Fachliste.get(index).Fachname=Sollfachname;
    }
    private boolean isFachPresent(String searchedFach){
        return getindexOfFach(searchedFach)!=-1;
    }
    private int getindexOfFach(String searchedFach){
        //findet den Index des Fachs in der Fachliste
        for(int i=0;i<Fachliste.size();i++){
            if(Fachliste.get(i).Fachname==searchedFach){
                return i;
            }
            
        }
        return -1;
    }
    public String toString(){
        //Debugginghilfe
        StringBuilder sb = new StringBuilder();
        sb.append("\nSchüler:\n");
        Schülerliste.forEach((schüler) -> { sb.append(schüler.Schülername + ", ");});
        sb.append("\nFächer:\n");
        Fachliste.forEach((fach) -> { sb.append(fach.Fachname + ", ");});

        sb.append("\nTest im Fach:\n");
        Testliste.forEach((test) -> {sb.append(test.Fach+" Test: "+test.Testname+"\n");});

        return sb.toString();
    }
    public String toString(String Fachname,String Testname){
        StringBuilder sb=new StringBuilder();
        sb.append("\nFach\n"+Fachname);
        sb.append("\nTest\n"+Testname);
        for (String str : getSchuelersfromTest(Fachname, Testname)) {
            sb.append(str);
        }
        return sb.toString();

    }
    public void addSchüler(String Schülername){
        if(isSchülerPresent(Schülername)){
            return;
        }
        Schüler mySchüler=new Schüler(Schülername);
        Schülerliste.add(mySchüler);

    }
    public void removeSchüler(String Schülername){
        //Schülerliste durchiterieren
        int index=getindexOfSchüler(Schülername);
        if(index==-1){
            return;
        }
        //SChüler aus Schülerlist löschen
        Schülerliste.remove(index);

    }
    public void editSchüler(String Istschülername, String Sollschülername){
        if(isSchülerPresent(Sollschülername)){
            return;
        }
        int index=getindexOfSchüler(Istschülername);
        if(index==-1){
            return;
        }
        Schülerliste.get(index).Schülername=Sollschülername;
    }
    private boolean isSchülerPresent(String searchedSchüler){
        return getindexOfSchüler(searchedSchüler)!=-1;
    }
    private int getindexOfSchüler(String searchedSchüler){
        //findet den Index des Schülers in der Schülerliste
        for(int i=0;i<Schülerliste.size();i++){
            if(Schülerliste.get(i).Schülername==searchedSchüler){
                return i;
            }
            
        }
        return -1;
    }





    public void addTest(String Fachname,String Testname){
        
        if(!isFachPresent(Fachname)){
            return;
        }
        if(isTestPresent(Testname,Fachname)){
            return;
        }
        
        Test myTest=new Test(Fachname,Testname);
        Testliste.add(myTest);
    }
    public void editTest(String Fachname,String Isttestname, String Solltestname){
        if(isTestPresent(Fachname,Isttestname)){
            return;
        }
        int index=getIndexOfTest(Fachname,Isttestname);
        if(index==-1){
            return;
        }
        Testliste.get(index).Testname=Solltestname;
    }
    public void removeTest(String Fachname,String Testname){
        //Testliste durchiterieren
        int index=getIndexOfTest(Fachname,Testname);
        if(index==-1){
            return;
        }
        //Test aus Testliste löschen
        Testliste.remove(index);

    }

    private boolean isTestPresent(String searchedFach,String searchedTestName) {
        for (Test test : Testliste) {
            if (test.Testname.equals(searchedTestName) && test.Fach.equals(searchedFach)) {
                return true;
            }
        }
        return false;
    }
    
    private int getIndexOfTest(String searchedFach,String searchedTestName) {
        for (int i = 0; i < Testliste.size(); i++) {
            Test test = Testliste.get(i);
            if (test.Testname.equals(searchedTestName) && test.Fach.equals(searchedFach)) {
                return i;
            }
        }
        return -1;
    }

    //addSchuelertoTest(Fach,Test,Schueler)

    public void addSchuelertoTest(String Fachname,String Test,String Schueler){
        if(!isFachPresent(Fachname)){
            return;
        }
        if(!isTestPresent(Fachname,Test)){
            return;
        }
        for (Test test:Testliste) {
            if(test.Fach==Fachname&&test.Testname==Test){
                test.Testmap.put(Schueler,-1);
            }
            
        }
    }
    //removeSchuelerfromtTest(Fach,Test,Schueler)
    public void removeSchuelerfromTest(String Fachname,String Test,String Schueler){
        if(!isFachPresent(Fachname)){
            return;
        }
        if(!isTestPresent(Fachname,Test)){
            return;
        }
        for (Test test:Testliste) {
            if(test.Fach==Fachname&&test.Testname==Test){
                if(!test.Testmap.containsKey(Schueler)){
                    return;
                }
                test.Testmap.remove(Schueler);
                
            }
            
        }
    }
    
    //getSchuelers(Fach,Test)
    public String[] getSchuelersfromTest(String Fachname,String Test){
        if(!isFachPresent(Fachname)){
            return new String[0];
        }
        if(!isTestPresent(Fachname,Test)){
            return new String[0];
        }
        for(Test test :Testliste){
            if(test.Fach==Fachname&&test.Testname==Test){
                return test.getSchuelers();

            }
        }
        return new String[0];
    }

    //getFaecher
    //getTests(Fach)
    //getSchuelers(Fach)
    //getSchuelers(Fach,Test)---------------
    //initTest(Fach,Test,[Schueler])
    //TestaddNote(Fach,Test,Schueler,Note)
    //TesteditNote(Fach,Test,Schueler,Note)
    //TestremoveNote(Fach,Test,Schuler)
    //getNote(Fach,Test,Schueler)
    //getZeugnisnote(Fach,Schueler)
    //convertentry(1-6)
    //convertexit(0-15)
    
    





}
