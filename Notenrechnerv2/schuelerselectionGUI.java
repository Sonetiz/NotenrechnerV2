package Notenrechnerv2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import all the things
public class schuelerselectionGUI extends JFrame{
    private Lehrer lehrer;
    private String fach;
    private String test;
    private Integer iterator;
    private ArrayList<String> selected=new ArrayList<String>();
    public schuelerselectionGUI(Lehrer lehrerin,String fachString,String testString){
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
            JCheckBox checkbox =new JCheckBox();
           boxPanel.add(checkbox);
            checkbox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    if(checkbox.isSelected()){
                        selected.add(lehrer.getSchuelers()[iterator]);
                    }
                    if(!checkbox.isSelected()){
                        selected.remove(lehrer.getSchuelers()[iterator]);
                    }
                }
            });
            boxPanel.add(checkbox);


        }
        JButton saveButton=new JButton("ausgewaehlte Schueler dem Test zuordnen");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                saveButtonisclicked();
            }
        });
        boxPanel.add(saveButton);
        return boxPanel;
    }
    private void saveButtonisclicked(){
        for(String name:selected){
            lehrer.addSchuelertoTest(fach, test, name);
        }
        this.setVisible(false);
    }
}