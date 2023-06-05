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
        Testliste.forEach((test) -> {sb.append("ID:"+test.id+test.Fach+" Test: "+test.Testname+"\n");});

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
        long id =getfreeTestID();
        if(!isFachPresent(Fachname)){
            return;
        }
        if(isTestPresent(Testname)){
            return;
        }
        if(getfreeTestID()==-1){
            id=1;
        }else{
            id=getfreeTestID();
        }
        Test myTest=new Test(id,Fachname,Testname);
        Testliste.add(myTest);
    }
    public void editTest(long id, String Solltestname){
        if(isTestPresent(id)){
            return;
        }
        int index=getindexOfTest(id);
        if(index==-1){
            return;
        }
        Testliste.get(index).Testname=Solltestname;
    }
    public void removeTest(String Testname){
        //Testliste durchiterieren
        int index=getindexOfTest(Testname);
        if(index==-1){
            return;
        }
        //Test aus Testliste löschen
        Testliste.remove(index);

    }

    private boolean isTestPresent(String searchedTest){
        return getindexOfTest(searchedTest)!=-1;
    }
    private boolean isTestPresent(long id){
        return getindexOfTest(id)!=-1;
    }
    private int getindexOfTest(String searchedTest){
        //findet den Index des Test in der Testliste
        for(int i=0;i<Testliste.size();i++){
            if(Testliste.get(i).Testname==searchedTest){
                return i;
            }
            
        }
        return -1;
    }
    private int getindexOfTest(long id){
        for(int i=0;i<Testliste.size();i++){
            if(Testliste.get(i).id==id){
                return i;
            }


        }
        return -1;
    }
    private long getfreeTestID(){
        //findet den Index des Schülers in der Schülerliste
        long highest=-1;
        for(int i=0;i<Testliste.size();i++){
            
            if(Testliste.get(i).id>highest){
                highest=Testliste.get(i).id;
            }
            
        }
        if(highest==-1){
            return highest;
        }
        return highest+1;
    }





}
