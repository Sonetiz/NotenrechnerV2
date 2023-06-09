package Notenrechnerv2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import all the things

public class Tabelle extends JFrame {
    private Lehrer lehrer;
    private JPanel tabPanel;
    private JPanel buttonPanel;
    private JComboBox fachBox;
    
    private JButton updaButton;
    private String fachselection;
    private String testselection;
    public Tabelle(Lehrer inLehrer){
        lehrer=inLehrer;
        setTitle("Tabelle");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel buttonPanel=createbuttons();
        //JPanel tabPanel=createTabelle();
        add(buttonPanel,BorderLayout.NORTH);
        //add(tabPanel,BorderLayout.CENTER);

    }

    private JPanel createbuttons(){
        JPanel ButtonPanel=new JPanel(new GridLayout(1, 3));
        fachBox=new JComboBox<>(lehrer.getFaecher());
        fachBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                fachselection=fachBox.getSelectedItem().toString();
                update();
            }
        });
        ButtonPanel.add(fachBox);
        if(fachselection!=null){
            fachBox.setSelectedItem(fachselection);
        }
       
        JLabel Label=new JLabel("Testuebersicht");
        ButtonPanel.add(Label);

        return ButtonPanel;
    }
    private JPanel createTabelle(){
        if(fachselection==null){
            return new JPanel();
        }
        JPanel tabPanel=new JPanel(new GridLayout(lehrer.getSchuelersfromFach(fachselection).length+2,lehrer.getTests(fachselection).length+2));
        JLabel fachLabel=new JLabel(fachselection);
        add(fachLabel);
        for(String test:lehrer.getTests(fachselection)){
            JLabel testLabel=new JLabel(test);
            add(testLabel);
        }
        JLabel zLabel=new JLabel("Zeugnisnote:");
        add(zLabel);
        for(String schueler:lehrer.getSchuelersfromFach(fachselection)){
            JLabel nLabel=new JLabel(schueler);
            add(nLabel);
            for(String test:lehrer.getTests(fachselection)){
                if(lehrer.TestgetNote(fachselection, test, schueler)==-1){
                    JLabel errorLabel=new JLabel("Note fehlt!");
                    add(errorLabel);
                }
                else{
                    JLabel NotenLabel=new JLabel(lehrer.TestgetNote(fachselection, test, schueler).toString());
                    add(NotenLabel);
                }
            }
            JLabel zeugnisLabel=new JLabel(lehrer.getZeugnisnote(fachselection,schueler).toString());
            add(zeugnisLabel);

        }
        JLabel blankLabel=new JLabel("");
        add(blankLabel);
        for(String test:lehrer.getTests(fachselection)){
            JLabel avgLabel=new JLabel(Integer.toString(lehrer.Testgetaverage(fachselection, test)));
            add(avgLabel);
        }
        return tabPanel;
    }

    private void update(){
        removeAll();
        buttonPanel=createbuttons();
        tabPanel=createTabelle();
        add(buttonPanel,BorderLayout.NORTH);
        add(tabPanel,BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
