/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.SecretKeyFactorySpi;

/**
 *
 * @author Teo Nao
 */
public class Sever extends javax.swing.JFrame {
    ServerSocket serverSocket;
    Socket socket;

    /**
     * Creates new form Sever
     */
    public Sever() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtnd = new javax.swing.JTextField();
        butgui = new javax.swing.JButton();
        btnconnect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtmess = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtport = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sever");
        setResizable(false);

        butgui.setBackground(new java.awt.Color(0, 153, 204));
        butgui.setText("Gửi");
        butgui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butguiActionPerformed(evt);
            }
        });

        btnconnect.setBackground(new java.awt.Color(51, 51, 51));
        btnconnect.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnconnect.setForeground(new java.awt.Color(255, 255, 255));
        btnconnect.setText("START");
        btnconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconnectActionPerformed(evt);
            }
        });

        txtmess.setColumns(20);
        txtmess.setRows(5);
        jScrollPane1.setViewportView(txtmess);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("SERVER MASOI");

        lblID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblID.setText("jLabel1");

        jButton1.setText("True");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("False");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtnd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butgui))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtport, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addComponent(txtport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnconnect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butgui)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconnectActionPerformed
        txtmess.append("Đang chờ kết nối...\n");
        this.excute();
        this.status();
    }//GEN-LAST:event_btnconnectActionPerformed

    private void butguiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butguiActionPerformed
       try {
           DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
           dos.writeUTF(txtnd.getText());
           dos.flush();
       } catch (Exception e) {
           //TODO: handle exception
       }
    }//GEN-LAST:event_butguiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
           DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
           dos.writeUTF("true 123");
           dos.flush();
       } catch (Exception e) {
           //TODO: handle exception
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        th.serverOut(txtnd.getText());
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Sever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sever().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconnect;
    private javax.swing.JButton butgui;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JTextArea txtmess;
    private javax.swing.JTextField txtnd;
    private javax.swing.JTextField txtport;
    // End of variables declaration//GEN-END:variables
    newThread th = new newThread();
    void excute(){
        try {
            serverSocket = new ServerSocket(Integer.parseInt(txtport.getText()));
            System.out.println(serverSocket.getLocalSocketAddress());
            Thread thread = new Thread(){
                @Override
                public void run() {
                    try {
                        while (true) {
                            socket = serverSocket.accept();
                            DataInputStream dis = new DataInputStream(socket.getInputStream());
                            String data = dis.readUTF();
                            String [] datas = data.split("\\s");
                            if(datas[0].equals("3")){
                                th.startServer(Integer.parseInt(datas[2]));
                            }
                            // if(datas[0].equals("join")){
                            //     th.serverOut(datas[1] + " Thái");
                            // }
                            txtmess.append("data: "+data+"\n");
                        }
                    } catch (Exception e) {} 
                }
            };thread.start();
        } catch (Exception e) {}
    }
    void status(){
        lblID.setText("SERVER: Đang hoạt động.");
    }

//Socket socket2;
//    void main2(){
//        try {
//            ServerSocket serverSocket2 = new ServerSocket(idr);
//            System.out.println("Server2: mở");
//            Thread thread2 = new Thread(){
//                @Override
//                public void run(){
//                    try {
//                        while (true) {
//                            socket2 = serverSocket2.accept();
//                            DataInputStream dis = new DataInputStream(socket2.getInputStream());
//                            String data = dis.readUTF();
//                            System.out.println("\nNhận "+data);
//                            //String [] datas = data.split("\\s");
//                            //if(datas[0].equals("join")){
//                            //}
//                        }
//                    } catch (Exception e) {
//
//                    }
//                }
//            };thread2.start();
//            gui(socket2);
//            System.out.println("\nsocket: "+socket2);
//        } catch (Exception e) {}
//    }
//    
//    void gui(Socket socket2){
//        try {
//            DataOutputStream dos = new DataOutputStream(socket2.getOutputStream());
//            dos.writeUTF("Thai Nguyen An Minh");
//            dos.flush();
//        } catch (Exception e) {}
//    }
}
class newThread {
    Socket socket;
    ServerSocket serverSocket;
    List<Socket> list = new ArrayList<>();
    public void startServer(int port) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                 try {
                    serverSocket = new ServerSocket(port);
                    System.out.println("Sv2 mở.........");
                    while (true) {
                        socket = serverSocket.accept();
                        list.add(socket);
                    //     System.out.println("kết nối thành công.........");
                    //     //serverOut("123 Thai");
                    //     // String str = serverInput();
                    //     // if (str.split("\\s")[0].equals("mess")){
                    //     //     System.out.println("vào hàm");
                    //     //     serverOut(str);
                    //     // }
                        System.out.println("hết.");
                    }
                 } catch (Exception e) {}
            }
        };thread.start();
    }
    // public void addSocket(){
    //     try {
    //         socket = serverSocket.accept();
    //         list.add(socket);
    //         System.out.println("kết nối thành công.........");
    //     } catch (Exception e) {
    //         //TODO: handle exception
    //     }
        
    // }
    public String serverInput() throws Exception{
        try {
            String str = null;
            for (Socket i : list) {
                DataInputStream dis = new DataInputStream(i.getInputStream());
                str = dis.readUTF();
                System.out.println("Input: "+str);
            }
            return str;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    public void serverOut(String data){
        try {
            // socket = serverSocket.accept();
            // list.add(socket);
            for (Socket sk : list) {
                DataOutputStream dos = new DataOutputStream(sk.getOutputStream());
                dos.writeUTF(data);
                System.out.println("Output: "+data+" "+socket);
                dos.flush();
            }
            
        } catch (Exception e) {}
    }
}