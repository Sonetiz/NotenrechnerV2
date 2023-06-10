package Notenrechnerv2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
//import all the things
public class Notenentry extends JFrame{
    private Lehrer lehrer;
    private String fach;
    private String test;
    private Integer iterator;
    private HashMap<String,Integer> selected=new HashMap<String,Integer>();
    public Notenentry(Lehrer lehrerin,String fachString,String testString){
        lehrer=lehrerin;
        fach=fachString;
        test=testString;
        setTitle(testString);
        setSize(400,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel boxPanel=createboxPanel();
        add(boxPanel,BorderLayout.CENTER);
    }
    private JPanel createboxPanel(){
        JPanel boxPanel=new JPanel(new GridLayout(lehrer.getSchuelersfromTest(fach,test).length+1, 2));
        for(int i=0;i<lehrer.getSchuelersfromTest(fach,test).length;i++){
            iterator=i;
            JLabel schuelerLabel =new JLabel(lehrer.getSchuelersfromTest(fach,test)[i]);
            boxPanel.add(schuelerLabel);
            JTextField Entryfield =new JTextField();
           boxPanel.add(Entryfield);
           if(lehrer.TestgetNote(fach, test,lehrer.getSchuelersfromTest(fach,test)[i])!=-1){
            Entryfield.setText(Integer.toString(lehrer.TestgetNote(fach, test,lehrer.getSchuelersfromTest(fach,test)[i])));
           }
            Entryfield.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    if(Entryfield.getText()==null){
                        return;
                    }
                    if(Entryfield.getText()!=null){
                        selected.put(lehrer.getSchuelersfromTest(fach,test)[iterator],Integer.parseInt(Entryfield.getText()));
                    }
                }
            });
            boxPanel.add(Entryfield);



        }
        JButton saveButton=new JButton("ausgewaehlte Schueler dem Test zuordnen");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                saveButtonisclicked();
            }
        });
        boxPanel.add(saveButton);
        JLabel Label=new JLabel("Notenangabe erfolgt im 15pkt MSS-System");
        boxPanel.add(Label);
        return boxPanel;
    }
    private void saveButtonisclicked(){
        for(String name:selected.keySet()){
            if(lehrer.TestgetNote(fach,test,name)==-1){
            lehrer.TestaddNote(fach, test, name, selected.get(name));
            }
            else{
                lehrer.TesteditNote(fach, test, name, selected.get(name));
            }
        }
        this.setVisible(false);
    }
}