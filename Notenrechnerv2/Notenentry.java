package Notenrechnerv2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
        JPanel boxPanel=new JPanel(new GridLayout(lehrer.getSchuelers().length+1, 2));
        for(int i=0;i<lehrer.getSchuelers().length;i++){
            iterator=i;
            JLabel schuelerLabel =new JLabel(lehrer.getSchuelers()[i]);
            boxPanel.add(schuelerLabel);
            JTextField Entryfield =new JTextField();
           boxPanel.add(Entryfield);
            Entryfield.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    if(Entryfield.getText()==null){
                        return;
                    }
                    if(Entryfield.getText()!=null){
                        selected.put(lehrer.getSchuelers()[iterator],Integer.parseInt(Entryfield.getText()));
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
            lehrer.TestaddNote(fach, test, name, selected.get(name));
        }
        this.setVisible(false);
    }
}