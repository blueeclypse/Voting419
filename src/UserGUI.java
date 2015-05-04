/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hoang
 */
import java.net.*;
import java.io.*;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.JFrame;
public class UserGUI extends javax.swing.JFrame {

    /**
     * Creates new form UserGUI
     */
    public UserGUI() {
        initComponents();
    }
String valid = "";
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Text = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UserName.setToolTipText("name");
        UserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserNameActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter your name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("User Registration Form");

        jButton1.setText("Request Validation Number");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Exit");
        jButton2.setActionCommand("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Proceed to Voting");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Text.setText("Enter your name and request a validation number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(UserName)
                    .addComponent(Text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Text)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        UserName.getAccessibleContext().setAccessibleName("userName");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //CODE FOR BUTTON
        
        //User newUser = new User(UserName.getText());
        //UserName.setVisible(false);
        //UserName.setEnabled(false);
        //UserName.setEditable(false);
        
        if(UserName.getText().isEmpty()){
            Text.setText("Please enter a name");
        }
        else if(UserName.getText().length() > 21){
            Text.setText("Please enter a shorter name(20 chars or less)");
        }
        else if(UserName.getText().trim().length() == 0){
            Text.setText("Please do not enter only spaces");
            UserName.setText("");
        }
        else{
        //WITHOUT SSL--------------------------------------------------------------------------------------------------
        	/*
        String serverName = "localhost";
        String temp = "6066";
      int port = Integer.parseInt(temp);
      try
      {
         System.out.println("Connecting to " + serverName+ " on port " + port);
         Socket client = new Socket(serverName, port);
         System.out.println("Just connected to "+ client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out =new DataOutputStream(outToServer);

         //out.writeUTF("Hello from "+ client.getLocalSocketAddress());
         out.writeUTF(UserName.getText());
         InputStream inFromServer = client.getInputStream();
         DataInputStream in =new DataInputStream(inFromServer);
         String validation = ""+in.readInt();
         System.out.println("Server says " + validation);
         valid = validation;
         Text.setText(UserName.getText() + ", your validation number is: "+validation);
         jButton1.enable(false);
         client.close();
         
      }catch(IOException e)
      {
         //e.printStackTrace();
          Text.setText("The CLA server is not running");
          System.out.println("CLA Server is not running");
      }
       */ 
     //WITHOUOT SSL END--------------------------------------------------------------------------------------------------
      
      //WITH SSL AISER ----------------
            String serverName = "localhost";
            String temp = "6066";
            System.setProperty("javax.net.ssl.trustStore", "cacerts.jks");
        	System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            
          int port = Integer.parseInt(temp);
          try
          {
        	 SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket("localhost", 6066);
             //System.out.println("Connecting to " + serverName+ " on port " + port);
             //Socket client = new Socket(serverName, port);
             //System.out.println("Just connected to "+ sslsocket.getRemoteSocketAddress());
             OutputStream outToServer = sslsocket.getOutputStream();
             DataOutputStream out =new DataOutputStream(outToServer);

             //out.writeUTF("Hello from "+ client.getLocalSocketAddress());
             out.writeUTF(UserName.getText());
             InputStream inFromServer = sslsocket.getInputStream();
             DataInputStream in =new DataInputStream(inFromServer);
             int validation = in.readInt();
             if(validation == 0){
                 Text.setText("This name has already been registered");
             }   
             else{
                 valid = validation+"";
                 Text.setText(UserName.getText() + ", your validation number is: "+validation);
                 UserName.setText("");
                 jButton1.setEnabled(false);
             }
            // client.close();
             
          }catch(IOException e)
          {
             //e.printStackTrace();
              Text.setText("The CLA server is not running");
              System.out.println("CLA Server is not running");
          }
        	
      //WITH SSL AISER END -----------------------
      
      //WITH SSL---------------------------------------------------------------------------------------------------------
        	/*
      try {
        	System.setProperty("javax.net.ssl.trustStore", "cacerts.jks");
        	System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket("localhost", 6066);

            InputStream inputstream = System.in;
            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

            OutputStream outputstream = sslsocket.getOutputStream();
            OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
            BufferedWriter bufferedwriter = new BufferedWriter(outputstreamwriter);
            String string = UserName.getText();
            DataOutputStream out =new DataOutputStream(outputstream);
            out.writeUTF(UserName.getText());
            bufferedwriter.write(string);
            bufferedwriter.flush();
            
            InputStream inputstream2 = sslsocket.getInputStream();
            InputStreamReader inputstreamreader2 = new InputStreamReader(inputstream2);
            BufferedReader bufferedreader2 = new BufferedReader(inputstreamreader2);
            String validation = bufferedreader.readLine();
            System.out.println("Server says " + validation);
            valid = validation;
            Text.setText(UserName.getText() + ", your validation number is: "+validation);
        } catch (Exception exception) {
            //exception.printStackTrace();
          Text.setText("The CLA server is not running");
          System.out.println("CLA Server is not running");
        }
      */
      //WITH SSL END---------------------------------------------------------------------------------------------------------
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void UserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserNameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        UserGuiVoting GUI = new UserGuiVoting();
        GUI.setVisible(true);
        GUI.revalidate();
        GUI.repaint();
        GUI.setValidation(valid);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Text;
    private javax.swing.JTextField UserName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
