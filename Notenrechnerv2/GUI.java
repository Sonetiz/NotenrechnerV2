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
    public JPanel tabellenpanel;
    public String tabellenFachselection;
    private JButton tabelleupdateButton;
    public GridBagLayout layout;
    public GridBagConstraints c;
    

    public GUI() {
        //Konstruktor des GUIs
        lehrer = new Lehrer();
        fillwithexampledata(lehrer);
        
        //Ueberschrift
        setTitle("Noten Manager by JMS™");
        setSize(1080, 165);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        layout=new GridBagLayout();
        setLayout(layout);
        c =new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        c.gridx=0;
        c.gridy=0;

        FachselectorPanel = createFachPanel();
        add(FachselectorPanel,c);
        c.gridy=1;
        SchülerselectorPanel =createSchülerPanel();
        add(SchülerselectorPanel,c);
        c.gridy=2;
        TestselectorPanel =createTestPanel();
        add(TestselectorPanel,c);
        c.gridy=3;
        tabellenpanel=TabeellenPanel();
        add(tabellenpanel,c);

        
    }
    private JPanel TabeellenPanel(){
        JPanel tabPanel=new JPanel(new GridLayout(1, 2));

        fachComboBox=new JComboBox<>(lehrer.getFaecher());
        fachComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tabellenFachselection=fachComboBox.getSelectedItem().toString();
            }
        });
        tabPanel.add(fachComboBox);
        tabelleupdateButton = new JButton("Notenuebersich anzeigen");
        tabelleupdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Fach entfernen
                showtable();
            }
        });
        tabPanel.add(tabelleupdateButton);
        return tabPanel;


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
                fachsaveButtonisclicked();

            }
        });
        FachPanel.add(fachsaveButton);
        fachdeleteButton = new JButton("Fach entfernen");
        fachdeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Fach entfernen
                fachdeleteButtonisclicked();
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
                schuelersaveButtonisclicked();
            }
        });
        SchülerPanel.add(schülersaveButton);
        JButton schülerdeleteButton = new JButton("Schüler entfernen");
        schülerdeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Schüler entfernen
                schuelerdeleteButtonisclicked();
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
                testsaveButtonisclicked();
            }
        });
        TestPanel.add(testsaveButton);
        JButton testdeleteButton = new JButton("Test entfernen");
        testdeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Test entfernen
                testdeleteButtonisclicked();
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
                testinitButtonisclicked();
            }
        });
        TestPanel.add(testinitButton);
        JButton testentryButton = new JButton("Noten für Test eintragen");
        testentryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Popout Noteneintragen
                testentryButtonisclicked();
            }
        });
        TestPanel.add(testentryButton);


        return TestPanel;
    }
    private void showtable(){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                Tabelle windowTabelle =new Tabelle(lehrer,tabellenFachselection);
                windowTabelle.setVisible(true);
            }
        });
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
        tabellenpanel=TabeellenPanel();
    
        // Add the updated panels to the frame
        c.gridy=0;
        add(FachselectorPanel,c);
        c.gridy=1;
        add(SchülerselectorPanel,c);
        c.gridy=2;
        add(TestselectorPanel,c);
        c.gridy=3;
        add(tabellenpanel,c);
    
        // Revalidate and repaint the frame to reflect the changes
        revalidate();
        repaint();
    }
    public void fachsaveButtonisclicked(){
        if(fachTextField.getText()==""){
            JOptionPane.showMessageDialog(this,"Bitte Fach eintragen!");
        }
        if(fachcomboselection=="neues Fach erstellen"){
            lehrer.addFach(fachTextField.getText());
        }
        else{
            lehrer.editFach(fachcomboselection, fachTextField.getText());
        }    
        update();
    }
    public void fachdeleteButtonisclicked(){
        if(fachcomboselection!="neues Fach erstellen"){
            lehrer.removeFach(fachcomboselection);
        }
        update();
    }
    public void schuelersaveButtonisclicked(){
        if(schülerTextField.getText()==""){
            JOptionPane.showMessageDialog(this,"Bitte Schüler eintragen!");
        }
        if(fachcomboselection=="neuen Schüler erstellen"){
            lehrer.addSchüler(fachTextField.getText());
        }
        else{
            lehrer.editSchüler(schülercomboselection, schülerTextField.getText());
        }    
        update();
    }
    public void schuelerdeleteButtonisclicked(){
        if(schülercomboselection!="neuen Schüler erstellen"){
            lehrer.removeSchüler(schülercomboselection);
        }
        update();
    }
    public void testsaveButtonisclicked(){
        if(testTextField.getText()==""){
            JOptionPane.showMessageDialog(this,"Bitte Testnamen eintragen!");
        }
        if (testselectfach==null){
            JOptionPane.showMessageDialog(this,"Bitte Fach auswaehlen!");
        }
        if(testcomboselection=="neuen Test erstellen"){
            lehrer.addTest(testselectfach, testTextField.getText());
        }
        else{
            lehrer.editTest(testselectfach, testcomboselection, testTextField.getText());
        }
        update();
    } 
    public void testdeleteButtonisclicked(){
        if (testselectfach==null){
            JOptionPane.showMessageDialog(this,"Bitte Fach auswaehlen!");
        }
        if(testcomboselection!="neuen Test erstellen"){
            lehrer.removeTest(testselectfach, testcomboselection);
        }
        update();
    }
    public void testinitButtonisclicked(){
        if (testselectfach==null){
            JOptionPane.showMessageDialog(this,"Bitte Fach auswaehlen!");
            return;
        }
        if (testselectcomboselection==null){
            JOptionPane.showMessageDialog(this,"Bitte Test auswaehlen!");
            return;
        }
        //run selection GUI(testselectfach,testselectcomboselection)
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                schuelerselectionGUI selectWindow=new schuelerselectionGUI(lehrer, testselectfach, testselectcomboselection);
                selectWindow.setVisible(true);
            }
        });

        update();

    }
    public void testentryButtonisclicked(){
        if (testselectfach==null){
            JOptionPane.showMessageDialog(this,"Bitte Fach auswaehlen!");
        }
        if (testselectcomboselection==null){
            JOptionPane.showMessageDialog(this,"Bitte Test auswaehlen!");
        }
        //run NotenentryGUI(testselectfach,testselectcomboselection)
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                Notenentry entryWindow=new Notenentry(lehrer, testselectfach, testselectcomboselection);
                entryWindow.setVisible(true);
            }
        });

        update();

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