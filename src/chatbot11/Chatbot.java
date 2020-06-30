
package chatbot;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Chatbot {

    public static void main(String[] args) {
        // TODO code application logic here
        Main gui=new Main();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setResizable(false);
        gui.setTitle("ChatBot By LAMIAE");

    }
    
}
