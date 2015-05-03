
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hoang
 */
public class UserGuiVoting extends javax.swing.JFrame {

    /** Creates new form UserGuiVoting */
    public UserGuiVoting() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ValidationNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        IDNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Vote = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Text = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("User Voting");

        jLabel2.setText("Enter your validation number:");

        ValidationNumber.setText("empty");
        ValidationNumber.setToolTipText("");
        ValidationNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValidationNumberActionPerformed(evt);
            }
        });

        jLabel3.setText("Choose your ID number:");

        IDNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                IDNumberFocusGained(evt);
            }
        });
        IDNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDNumberActionPerformed(evt);
            }
        });

        jLabel4.setText("Who are you voting for?");

        Vote.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "George Washington", "John Adams", "Thomas Jefferson", "James Madison", "Abe Lincoln" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(Vote);

        jButton1.setText("Submit Vote");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Text.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDNumber, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ValidationNumber, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Text, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ValidationNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Text, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //System.out.println("Hi, " + ValidationNumber.getText() + ", with your ID: " + IDNumber.getText() + ", you voted for: " + Vote.getSelectedValue());
        
        //FORMAT: Validation, ID, vote
        
        //error checking
        String number = ValidationNumber.getText();
        String idNum = IDNumber.getText();
        if(number.length() <= 0){
            Text.setText("The validation number field is empty");
        }
        else if(number.length() > 0 && !number.matches("[0-9]+")){
            Text.setText("The validation number is not a valid number");
        }
        else if(idNum.length() <= 0){
            Text.setText("The ID number field is empty");
        }
        else if(idNum.length() >9){
            Text.setText("The ID number must be less than 9 digits");
        }
        else if(idNum.length() > 0 && !idNum.matches("[0-9]+")){
            Text.setText("The ID number is not a valid number");
        }
        else if(Vote.getSelectedIndex() < 0){
            Text.setText("You did not vote, please select a name");
        }
        else
        {
          String serverName = "localhost";
          String temp = "6067";
          int port = Integer.parseInt(temp);
          System.setProperty("javax.net.ssl.trustStore", "cacerts.jks");
      	  System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
          SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
          //WITHOUT SSL ------------------------
          /*
          try
          {
             System.out.println("Connecting to " + serverName+ " on port " + port);
             Socket client = new Socket(serverName, port);
             System.out.println("Just connected to "+ client.getRemoteSocketAddress());
             OutputStream outToServer = client.getOutputStream();
             DataOutputStream out =new DataOutputStream(outToServer);

             //out.writeUTF("Hello from "+ client.getLocalSocketAddress());
             int vote = Vote.getSelectedIndex() + 1;
             out.writeUTF(ValidationNumber.getText() + ", " + IDNumber.getText() + ", " + vote);
             /*InputStream inFromServer = client.getInputStream();
             DataInputStream in =new DataInputStream(inFromServer);
             String validation = ""+in.readInt();
             System.out.println("Server says " + validation);
             Text.setText("The server says: "+validation);
             jButton1.enable(false);
             client.close();

          } 
*/        
          //WITHOUT SSL ---------------------
          //WITH SSL --------------------------------
          try {
        	  System.out.println("Connecting to " + serverName+ " on port " + port);
         	 SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket("localhost", 6067);
              //Socket client = new Socket(serverName, port);
              System.out.println("Just connected to "+ sslsocket.getRemoteSocketAddress());
              OutputStream outToServer = sslsocket.getOutputStream();
              DataOutputStream out =new DataOutputStream(outToServer);

              //out.writeUTF("Hello from "+ client.getLocalSocketAddress());
              int vote = Vote.getSelectedIndex() + 1;
              out.writeUTF(ValidationNumber.getText() + ", " + IDNumber.getText() + ", " + vote);
              /*InputStream inFromServer = client.getInputStream();
              DataInputStream in =new DataInputStream(inFromServer);
              String validation = ""+in.readInt();
              System.out.println("Server says " + validation);
              Text.setText("The server says: "+validation);*/
              jButton1.enable(false);
          }
          catch(IOException e)
          {
             //e.printStackTrace();
              Text.setText("The CTF server is not running");
              System.out.println("CTF Server is not running");
          }
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ValidationNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValidationNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValidationNumberActionPerformed

    private void IDNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IDNumberFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_IDNumberFocusGained

    private void IDNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDNumberActionPerformed
    public void setValidation(String validation){
        ValidationNumber.setText(validation);
        if(!(ValidationNumber.getText().equals("")))
        {
            IDNumber.requestFocusInWindow();
            //System.out.println("ITS EMPTY");
        }
        Text.setText("Enter your validation number, choose an ID, and choose someone to vote for");
    }
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
            java.util.logging.Logger.getLogger(UserGuiVoting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserGuiVoting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserGuiVoting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserGuiVoting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserGuiVoting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDNumber;
    private javax.swing.JLabel Text;
    private javax.swing.JTextField ValidationNumber;
    private javax.swing.JList Vote;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
