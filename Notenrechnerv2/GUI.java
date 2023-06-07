package Notenrechnerv2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class GUI extends JFrame {

    public Lehrer lehrer;
    private JLabel fachLabel;
    private JTextField fachTextField;
    private JComboBox fachComboBox;
    private String fachcomboselection;
    private JButton fachsaveButton;
    private JButton fachdeleteButton;
    private JLabel schülerLabel;
    private JTextField schülerTextField;
    private JComboBox schülerComboBox;
    private String schülercomboselection;
    private JButton schülersaveButton;
    private JButton schülerdeleteButton;
    private JLabel testLabel;
    private JTextField testTextField;
    private JComboBox testComboBox;
    private String testcomboselection;
    private JButton testsaveButton;
    private JButton testdeleteButton;
    private JLabel selectTestLabel;
    private JComboBox testselectfachBox;
    private String testselectfach;
    private JComboBox testselectBox;
    private String testselectcomboselection;
    private JButton testinitButton;
    private JButton testentryButton;
    public JPanel FachselectorPanel;
    public JPanel SchülerselectorPanel;
    public JPanel TestselectorPanel;
    

    public GUI() {
        //Konstruktor des GUIs
        lehrer = new Lehrer();
        fillwithexampledata(lehrer);

        //Ueberschrift
        setTitle("Noten Manager by JMS™");
        setSize(1000, 140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        FachselectorPanel = createFachPanel();
        add(FachselectorPanel, BorderLayout.NORTH);
        SchülerselectorPanel =createSchülerPanel();
        add(SchülerselectorPanel,BorderLayout.CENTER);
        TestselectorPanel =createTestPanel();
        add(TestselectorPanel,BorderLayout.SOUTH);

        
    }
    //JPanel Fach
    private JPanel createFachPanel(){
        JPanel FachPanel=new JPanel(new GridLayout(1,5));

        fachLabel=new JLabel("Fachauswahl");
        FachPanel.add(fachLabel);


        fachTextField =new JTextField("neuer Fachname");
        FachPanel.add(fachTextField);


        //combobox
        fachComboBox=new JComboBox<>(lehrer.getFaecher());
        fachComboBox.insertItemAt("neues Fach erstellen", 0);
        fachComboBox.setSelectedIndex(0);
        fachComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                fachcomboselection=fachComboBox.getSelectedItem().toString();
            }
        });
        FachPanel.add(fachComboBox);



        JButton fachsaveButton = new JButton("Speichern");
        fachsaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //fach eintragen/bearbeiten
            }
        });
        FachPanel.add(fachsaveButton);
        fachdeleteButton = new JButton("Fach entfernen");
        fachdeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Fach entfernen
            }
        });
        FachPanel.add(fachdeleteButton);
        return FachPanel;
    }
    //JPanel Schüler
    private JPanel createSchülerPanel(){
        JPanel SchülerPanel=new JPanel(new GridLayout(1,5));

        schülerLabel=new JLabel("Schülerauswahl");
        SchülerPanel.add(schülerLabel);


        schülerTextField =new JTextField("neuer Schülername");
        SchülerPanel.add(schülerTextField);


        //combobox
        schülerComboBox=new JComboBox<>(lehrer.getSchuelers());
        schülerComboBox.insertItemAt("neuen Schüler erstellen", 0);
        schülerComboBox.setSelectedIndex(0);
        schülerComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                schülercomboselection=schülerComboBox.getSelectedItem().toString();
            }
        });
        SchülerPanel.add(schülerComboBox);



        JButton schülersaveButton = new JButton("Speichern");
        schülersaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Schüler eintragen/bearbeiten
            }
        });
        SchülerPanel.add(schülersaveButton);
        JButton schülerdeleteButton = new JButton("Schüler entfernen");
        schülerdeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Schüler entfernen
            }
        });
        SchülerPanel.add(schülerdeleteButton);
        return SchülerPanel;
    }

    //JPanel Test
    private JPanel createTestPanel(){
        JPanel TestPanel=new JPanel(new GridLayout(2,5));

        testLabel=new JLabel("Tests anlegen/umbenennen/löschen");
        TestPanel.add(testLabel);


        testTextField =new JTextField("neuer Testname");
        TestPanel.add(testTextField);


        //combobox
        testComboBox=new JComboBox<>(lehrer.getTests());
        testComboBox.insertItemAt("neuen Test erstellen", 0);
        testComboBox.setSelectedIndex(0);
        testComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                testcomboselection=testComboBox.getSelectedItem().toString();
            }
        });
        TestPanel.add(testComboBox);



        JButton testsaveButton = new JButton("Speichern");
        testsaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Test eintragen/bearbeiten
            }
        });
        TestPanel.add(testsaveButton);
        JButton testdeleteButton = new JButton("Test entfernen");
        testdeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Test entfernen
            }
        });
        TestPanel.add(testdeleteButton);

        selectTestLabel=new JLabel("Testauswahl");
        TestPanel.add(selectTestLabel);
        testselectfachBox=new JComboBox<>(lehrer.getFaecher());
        if(testselectfach==null){

            testselectfachBox.setSelectedIndex(0);
        }
        else{
            testselectfachBox.setSelectedItem(testselectfach);
        }
        testselectfachBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                testselectfach=testselectfachBox.getSelectedItem().toString();
                
                update();

            }
        });
        TestPanel.add(testselectfachBox);
        testselectBox=new JComboBox<>(lehrer.getTests(testselectfach));
        //testselectBox.setSelectedIndex(0);
        testselectBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                testselectcomboselection=testselectBox.getSelectedItem().toString();
                
            }
        });
        TestPanel.add(testselectBox);
        JButton testinitButton = new JButton("gewählte Schüler ändern");
        testinitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Popoutfenster Schülerselection
            }
        });
        TestPanel.add(testinitButton);
        JButton testentryButton = new JButton("Noten für Test eintragen");
        testentryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Popout Noteneintragen
            }
        });
        TestPanel.add(testentryButton);


        return TestPanel;
    }
    private void update() {
        // Remove the old panels
        remove(FachselectorPanel);
        remove(SchülerselectorPanel);
        remove(TestselectorPanel);
    
        // Create the updated panels
        FachselectorPanel = createFachPanel();
        SchülerselectorPanel = createSchülerPanel();
        TestselectorPanel = createTestPanel();
    
        // Add the updated panels to the frame
        add(FachselectorPanel, BorderLayout.NORTH);
        add(SchülerselectorPanel, BorderLayout.CENTER);
        add(TestselectorPanel, BorderLayout.SOUTH);
    
        // Revalidate and repaint the frame to reflect the changes
        revalidate();
        repaint();
    }
    


   





    public static Lehrer fillwithexampledata(Lehrer lehrer){
        // fächer anlegen
        lehrer.addFach("Mathe");
        lehrer.addFach("Deutsch");
        lehrer.addFach("Englisch");
        lehrer.addFach("toberemoved");
        lehrer.addFach("tobeedited");
        //System.out.println(lehrer.toString());
        
        // fächer bearbeiten
        lehrer.editFach("tobeedited","edited" );
        
        // fächer löschen
        //lehrer.removeFach("Mathe");
        //System.out.println(lehrer.toString());
        lehrer.removeFach("toberemoved");
    
        //Schüler anlegen
    
        lehrer.addSchüler("Simon");
        lehrer.addSchüler("Jonas");
        
    
        //Schüler bearbeiten
        lehrer.editSchüler("Simon","David");
        
    
        //Schüler löschen
        lehrer.removeSchüler("Simon");
    
        //Test anlegen
        lehrer.addTest("Deutsch","Klassenarbeit" );
        lehrer.addTest("Mathe","Epochalnote");
        lehrer.addTest("Deutsch","Epochalnote");
        lehrer.addTest("Mathe","HUE");
        //gleichnamige Tests in verschiedenen Faechern wird nur das erste Objekt mit dem Testname gespeichert
    
        //System.out.println(lehrer.toString());
        //Test bearbeiten
        lehrer.editTest("Mathe","Epochalnote", "Epo");
    
        //Test loeschen
        lehrer.removeTest("Mathe","HUE");
    
        //System.out.println(lehrer.toString());
        //Test converters
        //System.out.println(lehrer.convertfromMSS(14));
        //System.out.println(lehrer.convertfromMSS(8));
        //System.out.println(lehrer.converttoMSS(14));
        //System.out.println(lehrer.convertfromMSS(2));
        //Test addSchueler
        lehrer.addSchüler("Simon");
        lehrer.addSchüler("Max");
        lehrer.addSchüler("Tobedeleted");
        lehrer.addSchuelertoTest("Mathe", "Epo", "Jonas");
        lehrer.addSchuelertoTest("Mathe", "Epo", "Simon");
        lehrer.addSchuelertoTest("Mathe", "Epo", "Max");
        lehrer.addSchuelertoTest("Mathe", "Epo", "Tobedeleted");
        //Test getSchuelers
        lehrer.removeSchuelerfromTest("Mathe", "Epo", "Tobedeleted");
    
        //Test add note &&getNote
        lehrer.TestaddNote("Mathe", "Epo", "Simon", 2);
        lehrer.TestaddNote("Mathe", "Epo", "Jonas", 3);
        lehrer.TestaddNote("Mathe", "Epo", "Max", 1);
        lehrer.TesteditNote("Mathe", "Epo", "Jonas", 4);
        //lehrer.TestremoveNote("Mathe", "Epo", "Jonas");
        //Test add Schueler to different  Fach to Test getSchuelersfromFach
        lehrer.addSchüler("Deutschtester");
        lehrer.addSchuelertoTest("Deutsch", "Klassenarbeit", "Deutschtester");
        
        
        //System.out.println(lehrer.getSchuelersfromFach("Deutsch"));
    
    
    
        //System.out.println(lehrer.toString("Mathe", "Epo"));
        
        //System.out.println(lehrer.Testgetaverage("Mathe", "Epo"));
        //System.out.println(lehrer.getSchuelersfromTest("Mathe", "Epo").length);
        
        //Test Zeugnisnote
        lehrer.addTest("Mathe", "Klassenarbeit");
        lehrer.addTest("Mathe","Projekt");
        lehrer.addSchuelertoTest("Mathe", "Klassenarbeit", "Simon");
        lehrer.addSchuelertoTest("Mathe", "Projekt", "Simon");
        lehrer.TestaddNote("Mathe", "Klassenarbeit", "Simon", 1);
        lehrer.TestaddNote("Mathe", "Projekt", "Simon", 4);
        
        //System.out.println("Zeugnisnote Simon:");
        //System.out.println(lehrer.getZeugnisnote("Mathe", "Simon"));
        return lehrer;
        
    }
}