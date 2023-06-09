package Notenrechnerv2;

import javax.swing.SwingUtilities;

public class main{
    //diese Main Methode dient lediglich dem Debugging während der entwicklung
    public GUI window1;
public static void main(String[] args)  {

    //Lehrer lehrer=new Lehrer();
    //fillwithexampledata(lehrer);
    SwingUtilities.invokeLater(new Runnable(){
        public void run(){
            GUI window1=new GUI();
            window1.setVisible(true);
        }
    });


    
}

}