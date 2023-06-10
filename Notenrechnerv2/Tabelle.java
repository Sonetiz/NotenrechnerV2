package Notenrechnerv2;
import javax.swing.*;
import java.awt.*;

public class Tabelle extends JFrame {
    private Lehrer lehrer;
    private JPanel tabPanel;
    private String fach;
    public Tabelle(Lehrer inLehrer,String fachString){
        lehrer=inLehrer;
        fach=fachString;
        setTitle("Tabelle");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        tabPanel=createTabelle();
       
        add(tabPanel,BorderLayout.CENTER);

    }

   
    private JPanel createTabelle(){
        if(fach==null){
            return new JPanel();
        }
        JPanel tabPanel=new JPanel(new GridLayout(lehrer.getSchuelersfromFach(fach).length+2,lehrer.getTests(fach).length+2));
        JLabel fachLabel=new JLabel(fach);
        tabPanel.add(fachLabel);
        for(String test:lehrer.getTests(fach)){
            JLabel testLabel=new JLabel(test);
            tabPanel.add(testLabel);
        }
        JLabel zLabel=new JLabel("Zeugnisnote:");
        tabPanel.add(zLabel);
        for(String schueler:lehrer.getSchuelersfromFach(fach)){
            JLabel nLabel=new JLabel(schueler);
            tabPanel.add(nLabel);
            for(String test:lehrer.getTests(fach)){
                if(lehrer.TestgetNote(fach, test, schueler)==-1){
                    JLabel errorLabel=new JLabel("Note fehlt!");
                    tabPanel.add(errorLabel);
                }
                else{
                    JLabel NotenLabel=new JLabel(lehrer.TestgetNote(fach, test, schueler).toString());
                    tabPanel.add(NotenLabel);
                }
            }
            JLabel zeugnisLabel=new JLabel(lehrer.getZeugnisnote(fach,schueler).toString());
            tabPanel.add(zeugnisLabel);

        }
        JLabel blankLabel=new JLabel("Notenschnitt Test");
        tabPanel.add(blankLabel);
        for(String test:lehrer.getTests(fach)){
            JLabel avgLabel=new JLabel(Integer.toString(lehrer.Testgetaverage(fach, test)));
            tabPanel.add(avgLabel);
        }
        return tabPanel;
    }

    
}
