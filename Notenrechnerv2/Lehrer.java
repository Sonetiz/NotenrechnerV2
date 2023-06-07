package Notenrechnerv2;
import java.util.ArrayList;
//Haupt Objekt welches die Test,Fach und Schülerobjekte erstellt und Verwaltet.


public class Lehrer {
    //Fach 
    //Schüler
    //Test
    //prinzipiell werden innerhalb des Objekts Lehrer die erstellten "child"Objekte (Tests,Fächer,Schüler) in Arraylisten gespeichert
    private ArrayList<Fach> Fachliste=new ArrayList<Fach>();
    private ArrayList<Schüler> Schülerliste=new ArrayList<Schüler>();
    private ArrayList<Test> Testliste=new ArrayList<Test>();
    public Lehrer(){

    }
    
    
    //hinzufügen neues Fach
    public void addFach(String Fachname){
        if(isFachPresent(Fachname)){
            return;
        }
        Fach myFach=new Fach(Fachname);
        Fachliste.add(myFach);

    }
    //entfernen bestehendes Fach
    public void removeFach(String Fachname){
        //Fachliste durchiterieren
        int index=getindexOfFach(Fachname);
        if(index==-1){
            return;
        }
        //Fach aus Fachlist löschen
        Fachliste.remove(index);
    }
    //bearbeiten bestehendes Fach
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
    //check ob ein Fach bereits angelegt ist
    private boolean isFachPresent(String searchedFach){
        return getindexOfFach(searchedFach)!=-1;
    }
    //findet den Index des Fachs in der Fachliste oder returned -1 wenn das Fach nicht gefunden wird
    private int getindexOfFach(String searchedFach){
        //findet den Index des Fachs in der Fachliste
        for(int i=0;i<Fachliste.size();i++){
            if(Fachliste.get(i).Fachname==searchedFach){
                return i;
            }
            
        }
        return -1;
    }
    //fügt neuen Schüler hinzu
    public void addSchüler(String Schülername){
        if(isSchülerPresent(Schülername)){
            return;
        }
        Schüler mySchüler=new Schüler(Schülername);
        Schülerliste.add(mySchüler);

    }
    //entfernt einen existierenden Schüler
    public void removeSchüler(String Schülername){
        //Schülerliste durchiterieren
        int index=getindexOfSchüler(Schülername);
        if(index==-1){
            return;
        }
        //SChüler aus Schülerlist löschen
        Schülerliste.remove(index);
        
    }
    //bearbeitet existierenden Schüler
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
    //prüft ob ein Schüler bereits angelegt ist
    private boolean isSchülerPresent(String searchedSchüler){
        return getindexOfSchüler(searchedSchüler)!=-1;
    }
    //findet den Index eines Schülers in der Schülerliste oder wenn er nicht existiert returned -1
    private int getindexOfSchüler(String searchedSchüler){
        //findet den Index des Schülers in der Schülerliste
        for(int i=0;i<Schülerliste.size();i++){
            if(Schülerliste.get(i).Schülername==searchedSchüler){
                return i;
            }
            
        }
        return -1;
    }



    
    //bei allen Tests wird immer geprüft ob das zuzuordnende Fach existiert
    //fügt neuen Test hinzu 
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
    //bearbeitet existierenden Test
    public void editTest(String Fachname,String Isttestname, String Solltestname){
        if(!isTestPresent(Fachname,Isttestname)){
            return;
        }
        int index=getIndexOfTest(Fachname,Isttestname);
        if(index==-1){
            return;
        }
        Testliste.get(index).Testname=Solltestname;
    }
    //entfernt existierenden Test
    public void removeTest(String Fachname,String Testname){
        //Testliste durchiterieren
        int index=getIndexOfTest(Fachname,Testname);
        if(index==-1){
            return;
        }
        //Test aus Testliste löschen
        Testliste.remove(index);

    }
    //prüft ob ein Test existiert
    private boolean isTestPresent(String searchedFach,String searchedTestName) {
        for (Test test : Testliste) {
            if (test.Testname.equals(searchedTestName) && test.Fach.equals(searchedFach)) {
                return true;
            }
        }
        return false;
    }
    //findet den Index eines Tests in der List
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
    //fügt einen existierenden Schüler einem existierendem Test hinzu
    public void addSchuelertoTest(String Fachname,String Test,String Schueler){
        if(!isFachPresent(Fachname)){
            return;
        }
        if(!isTestPresent(Fachname,Test)){
            return;
        }
        for (Test test:Testliste) {
            if(test.Fach==Fachname&&test.Testname==Test){
                test.addSchueler(Schueler);
            }
            
        }
    }
    //removeSchuelerfromtTest(Fach,Test,Schueler)
    //entfernt einen Schüler von Test
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
                test.removeSchueler(Schueler);
                
            }
            
        }
    }
    
    //getSchuelers(Fach,Test)
    //sammelt eine Liste an Schülern die einem Test zugeordnet sind
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
    //TestaddNote(Fach,Test,Schueler,Note)
    //fügt einem Test eine Schüler Noten Kombo hinzu
    public void TestaddNote(String FachString,String TestString,String SchuelerString,int Note){
        if(!isFachPresent(FachString)){
            return;
        }
        if(!isTestPresent(FachString,TestString)){
            return;
        }
        for(Test test:Testliste){
            if(test.Fach==FachString&&test.Testname==TestString){
            if(!test.isSchuelerpresent(SchuelerString)){
                test.addSchueler(SchuelerString);
            }
            test.addNote(SchuelerString, Note);
        }
        }



    }
    //TesteditNote(Fach,Test,Schueler,Note)
    //bearbeitet Noteneintrag 
    public void TesteditNote(String FachString,String TestString,String SchuelerString,int newNote){
        if(!isFachPresent(FachString)){
            return;
        }
        if(!isTestPresent(FachString,TestString)){
            return;
        }
        for(Test test:Testliste){
            if(test.Fach==FachString&&test.Testname==TestString){
            if(!test.isSchuelerpresent(SchuelerString)){
                return;
            }
            test.editNote(SchuelerString, newNote);

        }
        }


        
    }
    //TestremoveNote(Fach,Test,Schuler)
    //entfern Note eines bestimmten Schülers
    public void TestremoveNote(String FachString,String TestString,String SchuelerString){
        if(!isFachPresent(FachString)){
            return;
        }
        if(!isTestPresent(FachString,TestString)){
            return;
        }
        for(Test test:Testliste){
            if(test.Fach==FachString&&test.Testname==TestString){
            if(!test.isSchuelerpresent(SchuelerString)){
                return;
            }
            test.removeNote(SchuelerString);

        }
        }



    }
    //TestremoveSchueler
    //entfernt einen Schüler von einem Test
    public void TestremoveSchueler(String FachString,String TestString,String SchuelerString){
        if(!isFachPresent(FachString)){
            return;
        }
        if(!isTestPresent(FachString,TestString)){
            return;
        }
        for(Test test:Testliste){
            if(test.Fach==FachString&&test.Testname==TestString){
                if(!test.isSchuelerpresent(SchuelerString)){
                return;
            }
            test.removeSchueler(SchuelerString);

        }
    }


    
    }
    
    
    //getNote(Fach,Test,Schueler)
    //findet die Note eines Schülers in einem Test in einem Fach
    public Integer TestgetNote(String FachString,String TestString,String SchuelerString){
        if(!isFachPresent(FachString)){
            return -1;
        }
        if(!isTestPresent(FachString,TestString)){
            return -1;
        }
        for(Test test:Testliste){
            if(test.Fach==FachString&&test.Testname==TestString){
            if(!test.isSchuelerpresent(SchuelerString)){
                return -1;
            }
            return test.getNote(SchuelerString);

        }
    }
    return -1;



    }
    //getTestaverage
    //berechnet den Notenschnitt eines Tests
    public int Testgetaverage(String fachString,String testString){
        if(!isFachPresent(fachString)){
            return -1;
        }
        if(!isTestPresent(fachString,testString)){
            return -1;
        }
        for(Test test:Testliste){
            if(test.Fach==fachString&&test.Testname==testString){
                
                return test.getTestaverage();
            }
        }
        return -1;
        
    }

    
    //getFaecher
    //erstellt ein Array aller Fächer
    public String[] getFaecher(){
        if(Fachliste.size()==0){
            return new String[0];
        }
        String[] temparr=new String[Fachliste.size()];
        int i=0;
        for(Fach fach:Fachliste){
            temparr[i]=fach.Fachname;
            i++;
        }
        return temparr;
    }
    //erstellt ein Array aller Schüler
    public String[]getSchuelers(){
        if(Schülerliste.size()==0){
            return new String[0];
        }
        String[] temparr=new String[Schülerliste.size()];
        int i=0;
        for(Schüler schüler:Schülerliste){
            temparr[i]=schüler.Schülername;
            i++;
        }
        return temparr;
    }
    //getTests
    public String[]getTests(){
        if(Testliste.size()==0){
            return new String[0];
        }
        String[] temparr=new String[Testliste.size()];
        int i=0;
        for(Test test:Testliste){
            temparr[i]=test.Testname;
            i++;
        }
        return temparr;
    }
    //getTests(Fach)
    //erstellt ein Array aller Tests in einem Fach
    public String[] getTests(String fachString){
        if(!isFachPresent(fachString)){
            return new String[0];
        }
        ArrayList<String> temp =new ArrayList<String>();
        for(Test test:Testliste){
            if(test.Fach==fachString){
                temp.add(test.Testname);
            }
        }
        if(temp.size()==0){
            return new String[0];
        }
        return temp.toArray(new String[temp.size()]);
        
    }
    
    //erstellt ein Array aller Schüler die einem Test in einem Fach zugeordnet sind
    public String[] getSchuelersfromFach(String fachString){
        ArrayList<String> temp =new ArrayList<String>();
        if(!isFachPresent(fachString)){
            return new String[0];
        }
        for(Test test : Testliste){
            if(test.Fach==fachString){
                String[] temp2=new String[test.getSchuelers().length];
                temp2=test.getSchuelers();
                for(int i=0;i<temp2.length;i++){
                    if(!temp.contains(temp2[i])){
                        temp.add(temp2[i]);
                    }
                }
            }
        }
        return temp.toArray(new String[temp.size()]);
        
    }
    //initTest(Fach,Test,[Schueler]).
    //getZeugnisnote(Fach,Schueler)
    //berechnet die Durchschnittliche Note eines Schülers in allen Tests eines Fachs
    public Integer getZeugnisnote(String fachString,String schuelerString){
        int total=0;
        int anzahl=0;
        if(!isFachPresent(fachString)){
            return -1;
        }
        for(Test test:Testliste){
            if(test.isSchuelerpresent(schuelerString)){
                if(test.getNote(schuelerString)!=-1){
                    total+=test.getNote(schuelerString);
                    anzahl++;
                }
            }
        }
        if(total==0){
            return -1;
        }
        return total/anzahl;
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
        //debugginghilfe
        StringBuilder sb=new StringBuilder();
        sb.append("\nFach:"+Fachname);
        sb.append("\nTest:"+Testname);
        
        for (int i=0;i<getSchuelersfromTest(Fachname, Testname).length;i++) {
            sb.append("\nSchüler:"+getSchuelersfromTest(Fachname, Testname)[i]);
            sb.append(" Note:");
            sb.append(TestgetNote(Fachname,Testname,getSchuelersfromTest(Fachname,Testname)[i]));
        }
        return sb.toString();

    }
    //convertentry(1-6)
    //umrechnung von 1-6Schulnoten zu 0-15MSS Punkten
    public Integer converttoMSS(Integer In){
        if(In<1||In>6){
            return -1;
        }
        switch(In){
            case 1:
                return 14;
                
            case 2:
                return 11;
                
                case 3:
                return 8;
                
            case 4:
            return 5;
            
            case 5:
                return 2;
                
            case 6:
                return 0;
                
                default:
                return -1;
            }
    }
    //convertexit(0-15)
    //umrechnung von 0-15MSS punkten zu 1-6 Schulnote
    public Integer convertfromMSS(Integer In){
        if(In<0||In>15){
            return -1;
        }
        switch(In){
            case 0:
            return 6;
            case 1:
                return 5;
                
            case 2:
                return 5;
                
            case 3:
                return 5;
                
            case 4:
                return 4;
                
            case 5:
                return 4;
                
            case 6:
                return 4;
                
            case 7:
                return 3;
            case 8:
                return 3;
            case 9:
                return 3;
            case 10:
                return 2;
            case 11:
                return 2;
            case 12:
                return 2;
            case 13:
                return 1;
            case 14:
                return 1;
            case 15:
                return 1;
            default:
                return -1;
        }
    }
    
    





}
