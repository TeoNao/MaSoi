/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testSV;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.*;

/**
 *
 * @author minha
 */
public class ChatRoomServer extends javax.swing.JFrame {
     Socket socket;
     DataInputStream input;
     DataOutputStream output;
     int port = 9998;
     
     ChatRoomServer() {
        initComponents();
        jPanel2.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Server Chat");
        excute();
        txtContent.append("Chat server has been started <!>\n");
    }
        
    private void excute(){           
        try {
            ServerSocket server = new ServerSocket(9998);
            Thread th = new Thread(new Runnable(){
                @Override
                public void run() {
                    while (true) {                        
                        try {
                            socket = server.accept();
                            txtContent.append("successful connection <3\n");
                            ServerDAO.listSockets.add(socket);
                            W_R_server();
                        } catch (IOException ex) {
                            Logger.getLogger(ChatRoomServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
            });
            th.start();
        } catch (IOException ex) {
            Logger.getLogger(ChatRoomServer.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    private void W_R_server(){
        Thread th1 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    input = new DataInputStream(socket.getInputStream());
                    output = new DataOutputStream(socket.getOutputStream());
                    while (true) {                        
                        output.writeUTF(input.readUTF());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ChatRoomServer.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }         
        });
        th1.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        btnShowMsg = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 284, 300, -1));

        btnShowMsg.setBackground(new java.awt.Color(0, 0, 0));
        btnShowMsg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnShowMsg.setForeground(new java.awt.Color(255, 255, 255));
        btnShowMsg.setText("Message System");
        btnShowMsg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShowMsgMouseClicked(evt);
            }
        });
        btnShowMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowMsgActionPerformed(evt);
            }
        });
        getContentPane().add(btnShowMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 140, -1));

        txtContent.setEditable(false);
        txtContent.setBackground(new java.awt.Color(0, 0, 0));
        txtContent.setColumns(20);
        txtContent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtContent.setForeground(new java.awt.Color(255, 255, 255));
        txtContent.setRows(5);
        txtContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtContentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txtContent);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 34, 470, 290));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("******");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 310, 40));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(0, 0, 0));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("Port Sever \"");
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 310, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowMsgActionPerformed
        jPanel2.show();
    }//GEN-LAST:event_btnShowMsgActionPerformed

    private void btnShowMsgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowMsgMouseClicked
        if (evt.getClickCount() == 2) {
           btnShowMsg.setVisible(false);
           jPanel2.setVisible(false);
        }
    }//GEN-LAST:event_btnShowMsgMouseClicked

    private void txtContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContentMouseClicked
          btnShowMsg.setVisible(true);
    }//GEN-LAST:event_txtContentMouseClicked

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
            java.util.logging.Logger.getLogger(ChatRoomServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatRoomServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatRoomServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatRoomServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatRoomServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShowMsg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextArea txtContent;
    // End of variables declaration//GEN-END:variables
}
