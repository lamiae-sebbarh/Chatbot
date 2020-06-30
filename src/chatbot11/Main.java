
package chatbot;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.applet.AudioClip;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main extends javax.swing.JFrame {

    String asks, answer, generatedasks;
    boolean playing = false;
     AudioClip sound1, sound2,Kuliki_taka_ti_kuliki_taka_ta;
     
    
    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enviar = new javax.swing.JButton();
        texto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        pantalla = new javax.swing.JTextArea();
        online = new javax.swing.JLabel();
        Namebot = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        enviar.setBackground(new java.awt.Color(204, 204, 255));
        enviar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        enviar.setForeground(new java.awt.Color(51, 51, 255));
        enviar.setText("Send");
        enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        texto.setBackground(new java.awt.Color(204, 204, 255));
        texto.setForeground(new java.awt.Color(0, 0, 204));
        texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoActionPerformed(evt);
            }
        });

        pantalla.setEditable(false);
        pantalla.setBackground(new java.awt.Color(204, 204, 255));
        pantalla.setColumns(20);
        pantalla.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        pantalla.setForeground(new java.awt.Color(0, 0, 204));
        pantalla.setRows(5);
        jScrollPane1.setViewportView(pantalla);

        online.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        Namebot.setFont(new java.awt.Font("Felix Titling", 1, 18)); // NOI18N
        Namebot.setForeground(new java.awt.Color(0, 0, 153));
        Namebot.setText("Alexa ChatBot");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(texto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enviar))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(Namebot, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(online, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 53, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(online, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Namebot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enviar)
                    .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        // TODO add your handling code here:
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    asks = texto.getText ();
                    answer = (new SData (). translate (texto.getText ()));
                    generatedasks = (new SData (). translate (generateasks ()));
                    pantalla.append ("You:" + texto.getText () + "\n");
                    if (answer.equalsIgnoreCase ("ok")) {
                        pantalla.append ("Alexa: Could you teach me that I should answer if they tell me: '" + asks + "' please (yes / no) \n");
                        String userResponse = JOptionPane.showInputDialog ("Do you want to add it? (Yes / no)");
                        if (userResponse.equalsIgnoreCase ("if")) {
                            String asksResponseUser = JOptionPane.showInputDialog ("What is the answer of '" + asks + "'");
                            Read aprender = new Read ();
                              String newword = aprender.newask (asks, asksResponseUser);
                            aprender.save (aprender.readtxt ("data.txt"), newword);
        }
    }
        texto.setText ("");
        animationWrite (answer);
        int probability = halfProbability ();
                    //System.out.println(probability);
        if(probability>5){
                        //  System.out.println("entra");
                        asks=(generatedasks);
                        if (generatedasks.equalsIgnoreCase ("chose a music ") && playing!= true) {
                            Kuliki_taka_ti_kuliki_taka_ta = java.applet.Applet.newAudioClip (getClass (). getResource ("./ Kuliki_taka_ti_kuliki_taka_ta.wav"));
                            Kuliki_taka_ti_kuliki_taka_ta.play ();
             }
             
        }   
        } catch (Exception e) {
        }
        }
        });
        hilo.start();

    }//GEN-LAST:event_enviarActionPerformed

    public String generateasks () {
        int number;
        number = (int) (Math.random () * 9) + 1;
        String Randomasks = Integer.toString (number);
        String completedasks = Randomasks + "p";
        return completedasks;
    }
     public int halfProbability () {
         int number;
        number = (int) (Math.random () * 9) + 1;
        return number;
    }
    public void animationWrite (String reponsexd) throws InterruptedException, URISyntaxException, IOException {
        sound1 = java.applet.Applet.newAudioClip (getClass (). getResource ("./facebook_sms.wav"));
        sound2 = java.applet.Applet.newAudioClip (getClass (). getResource ("./pop.wav"));
        Thread.sleep (generateRandom ());
        online.setForeground (Color.blue);
        sound2.play ();
        online.setText ("Viewed");
        Thread.sleep (generateRandom ());
        online.setText ("Writing");
        Thread.sleep (generateRandom ());
        online.setText ("");
        sound1.play ();
        pantalla.append ("Alexa:" + reponsexd + "\n");
          if (asks.equalsIgnoreCase ("play your favourite music")) {
            playing = true;
              Desktop.getDesktop (). browse (new URI ("https://www.youtube.com/watch?v=FuAgLHJnc-Y"));
          
        }
        
    }
       public void animationsks (String reponsexd) throws InterruptedException {
        sound1 = java.applet.Applet.newAudioClip (getClass (). getResource ("./file.wav"));
        Thread.sleep (1500);
        online.setText ("Writing");
        Thread.sleep (1000);
        online.setText ("");
        sound1.play ();
        pantalla.append ("Alexa:" + reponsexd + "\n");
    }
    
    public int generateRandom () {
        int number;
        number = (int) (Math.random () * 4000) + 1000;
        return number;
        
    }
     public void setText () {
         pantalla.append ("Alexa:" + answer + "\n");
        texto.setText ("");
    }
    private void textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_textoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String UserName = JOptionPane.showInputDialog ("Suggestion");
         String asksResponseUser = JOptionPane.showInputDialog ("What is the answer of '" + UserName + "'");
         Read aprender =new Read();
         String newword = aprender.newask (UserName, asksResponseUser);
         aprender.save (aprender.readtxt("data.txt"), newword);   
    }//GEN-LAST:event_jButton1ActionPerformed

     public JButton submitPressed(){
        return enviar;
    }
    public void setPanatalla () {
        pantalla.append ("Alexa:" + answer + "\n");
    }
    public JTextArea returnsScreen(){
        return pantalla;
    }
    

    public JTextField returnsText(){
        return texto;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Namebot;
    private javax.swing.JButton enviar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel online;
    private javax.swing.JTextArea pantalla;
    private javax.swing.JTextField texto;
    // End of variables declaration//GEN-END:variables
}
