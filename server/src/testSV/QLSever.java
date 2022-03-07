/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testSV;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import helper.*;
import model.*;
import java.util.ArrayList;
import java.sql.*;
import dao.*;
import java.util.List;
import java.util.Random;

public class QLSever extends javax.swing.JFrame {

    ArrayList<Room> listRoom = new ArrayList<>();
    Socket socket;
    DataInputStream input;
    DataOutputStream output;
    int port = 9999;
    public int portSV2 = 0;
    String userName, pass, email;
    int id = 0;
    String idPlayer = "";
    String[] word = null;
    String idUser = null;
    InformationDAO dao = new InformationDAO();
    ServerSocket server2;
    String messenger = null;
    String idRoom = null;
    String x = null;
    int value_Role;
    List<String> list_idVote = new ArrayList<>();

    public QLSever() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Sever 1");
        txtThongTinClient.append("Khởi động server thành công....\n");
        try {
            excute();
        } catch (IOException ex) {
            Logger.getLogger(QLSever.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void excute() throws IOException {
        ServerSocket server = new ServerSocket(9999);
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        socket = server.accept();
                        txtThongTinClient.append("---------------------------\n");
                        txtThongTinClient.append("kết nối thành công.... \n");
                        txtThongTinClient.append("địa chỉ người dùng hiện kết nối : " + socket.getRemoteSocketAddress() + "\n");
                        readSever().start();
                        ServerDAO.listSockets.add(socket);
                    } catch (IOException ex) {
                        Logger.getLogger(QLSever.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        });
        th1.start();
    }

    private Thread readSever() {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        input = new DataInputStream(socket.getInputStream());
                        x = input.readUTF();
                        txtThongTinClient.append("client said : " + x + "\n");
                        word = x.split("\\s");
                        try {
                            userName = word[1];
                            pass = word[2];
                            email = word[3];
                        } catch (IndexOutOfBoundsException e) {
                        }
                        switch (word[0]) {
                            case "1":
                                checkSQL();
                                break;
                            case "2":
                                getIn4();
                                register();
                                IDtoClientFindByUser(userName);
                                break;
                            case "3":
                                try {
                                idUser = word[1];
                                idRoom = word[2];
                                String nameRoom = word[3];
                                String passRoom = word[4];
                                listRoom.add(new Room(idUser, idRoom, nameRoom, passRoom));
                                txtThongTinClient.append("*Room add list success\n");
                                IDtoClientFindByID(Integer.parseInt(idUser));
                                txtThongTinClient.append("\n" + idUser + " | " + userName + " đã được thêm vào phòng\n");
                                txtThongTinClient.append("Server 2 started\n");
                                output = new DataOutputStream(socket.getOutputStream());
                                output.writeUTF("true");
                                txtThongTinClient.append("Server 2 waitting....\n");
                                portSV2 = Integer.parseInt(idRoom);
                                server2 = new ServerSocket(portSV2);
                                show_add_UserInRoom(true);
                            } catch (IndexOutOfBoundsException e) {
                            }
                            break;
                            case "5":
                                showRoom();
                                txtThongTinClient.append("show case 5 success\n");
                                break;
                            case "join":
                                System.out.println("đã vào case join");
                                idUser = word[1];
                                show_add_UserInRoom(false);
                                txtThongTinClient.append("show case join success\n");
                                break;
                            case "mess":
                                System.out.println("case mess đã vào");
                                read_sendMs(x);
                                break;
                            case "ready":
                                System.out.println("đã vào case ready");
                                idPlayer = word[1];
                                update_Ready(true);
                                break;
                            case "unready":
                                idPlayer = word[1];
                                update_Ready(false);
                                break;
                            case "start":
                                check_list_ready();
                                if (check_list_ready() == true) {
                                    read_sendMs("start true");
                                    randomRole();
                                    senRole();
                                    clock();
                                }
                                break;
                            case "vote":
                                System.out.println("vào case vote");
                                idVote = word[1];
                                idByVote = word[2];
                                if (ServerDAO.listVote.isEmpty()) {
                                    System.out.println("điều kiện null vote");
                                    ServerDAO.listVote.add(new VoteUser(idVote, idByVote));
                                    read_sendMs("vote " + idByVote + " " + countVote(idByVote));
                                } else {
                                    for (VoteUser i : ServerDAO.listVote) {
                                        if (!idVote.equals(i.getIdVote())) {
                                            System.out.println("điều kiện check # idVote vote");
                                            ServerDAO.listVote.add(new VoteUser(idVote, idByVote));
                                            read_sendMs("vote " + idByVote + " " + countVote(idByVote));
                                            break;
                                        }
                                    }
                                }
                                for (VoteUser i : ServerDAO.listVote) {

                                    System.out.println("list vote : " + i.getIdVote() + " | " + i.getVoteByVote());
                                }

                                break;
                            case "unvote":
                                System.out.println("vào case unvote ----------------------------");
                                idVote = word[1];
                                idByVote = word[2];
                                hisoryIdByVote(idVote);
                                System.out.println("history "+history);
                                // cập nhật idByVote -> đếm idbyVote thực tại
                                for (VoteUser i : ServerDAO.listVote) {
                                    if (idVote.equals(i.getIdVote())) {
                                        i.setVoteByVote(idByVote);
                                        read_sendMs("vote " + idByVote + " " + countVote(idByVote));
                                        System.out.println("giá trị gửi cho client : "+"vote " + idByVote + " " + countVote(idByVote));
                                        break;
                                    }
                                }
                                // đếm thằng idByVote cũ
                                int coutn = countVote(history);
                                System.out.println("đếm history "+history+" = "+coutn);
                                read_sendMs("vote " + history+ " " + coutn);
                                System.out.println("giá trị gửi cho client unvote " + "vote " + history + " " + coutn);
                                for (VoteUser i : ServerDAO.listVote) {
                                    System.out.println("list unvote : " + i.getIdVote() + " | " + i.getVoteByVote());
                                }
                                break;
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(QLSever.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });
        return th;
    }
    //----------------thời gian trong game -------------------------------------
      public  void clock (){
       Thread th = new Thread(){
           @Override
           public void run() {
               for (int i = 1; i <= 31; i++) {                  
                   System.out.println("ngày "+i);
               for (int iz = 180; iz >= 0 ; iz--) {
                   try {
                       Thread.sleep(100);
                       System.out.println("buổi sáng : "+iz);
                       read_sendMs("time "+iz+" ngay");
                   } catch (InterruptedException ex) {
                       Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
               }
               for (int iz = 30; iz >= 0; iz--) {
                   try {
                       Thread.sleep(100);
                         System.out.println("buổi tối : "+iz);
                          read_sendMs("time "+iz+" dem");
                   } catch (InterruptedException ex) {
                       Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                   }
                 
               }
               }
           }           
       };
       th.start();
    }
    //---------------------vote người chơi--------------------------------------
    String idVote = null;
    String idByVote = null;
    String history = null;

    private void hisoryIdByVote(String idVote) {
        for (VoteUser i : ServerDAO.listVote) {
            if (idVote.equals(i.getIdVote())) {
                history = i.getVoteByVote();
                break;
            }
        }
    }

    private int countVote(String idByVote) {
        System.out.println("vô phương thức countVote");
        int coutn = 0;
        for (int i = 0; i < ServerDAO.listVote.size(); i++) {
            if (idByVote.equals(ServerDAO.listVote.get(i).getVoteByVote())) {
                coutn++;
                System.out.println("count trong countVote dieu kien " + coutn);
            }
        }
        return coutn;
    }

    //---------------------cập nhật trạng thái người chơi ----------------------
    private void update_Ready(boolean ready) {
        for (UserAtRoom i : ServerDAO.listUser_atRoom) {
            if (i.getId().equals(String.valueOf(idPlayer))) {
                i.setReady(ready);
                showUserInRoom();
            }
        }
    }

    //------------bắt đầu game (kiểm tra ready trong list)----------------------
    private boolean check_list_ready() {
        boolean result = false;
        for (UserAtRoom i : ServerDAO.listUser_atRoom) {
            if (i.isReady() == true) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }
    //----------------------------Vai trò trong game----------------------------
    Random random = new Random();
    boolean check = false;
    int ran;
    int[] arr = new int[12];

    private void randomRole() {
        ran = random.nextInt(arr.length);
        ServerDAO.listRandom_role.add(ran);
        arr[0] = ran;
        try {
            for (int i = 0; i < arr.length - 1;) {
                ran = random.nextInt(arr.length);
                for (Integer j : ServerDAO.listRandom_role) {
                    check = true;
                    if (ran == j) {
                        check = false;
                        break;
                    }
                }
                if (check == true) {
                    ServerDAO.listRandom_role.add(ran);
                    arr[i] = ran;
                    i++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void senRole() {
        try {
            for (Socket j : ServerDAO.listSocketsSV2) {
                String role = "role ";
                output = new DataOutputStream(j.getOutputStream());
                for (int i = 0; i < arr.length - 1; i++) {
                    role = role + arr[i] + " ";
                }
                output.writeUTF(role);
                System.out.println(role);
            }

        } catch (IOException ex) {
            Logger.getLogger(QLSever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ---------------------đọc gửi tin nhắn -----------------------------------
    private void read_sendMs(String requirement) {
        try {
            for (Socket i : ServerDAO.listSocketsSV2) {
                output = new DataOutputStream(i.getOutputStream());
                output.writeUTF(requirement);
            }
        } catch (IOException ex) {
            Logger.getLogger(QLSever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // -------------------------------------------------------------------------

    // phần hiển thị user lên phòng chơi và trạng thái sẵn sàng ----------------
    private void showUserInRoom() {
        try {
            for (Socket sk : ServerDAO.listSocketsSV2) {
                String show = "";
                output = new DataOutputStream(sk.getOutputStream());
                for (UserAtRoom i : ServerDAO.listUser_atRoom) {
                    show = show + i.getId() + " " + i.getName() + " " + i.isReady() + " ";
                }
                output.writeUTF(show);
            }
            txtThongTinClient.append("-- *Join* successful data push member in the room *Join*\n");
        } catch (IOException ex) {
            Logger.getLogger(QLSever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void show_add_UserInRoom(boolean ready) {
        try {
            socket = server2.accept();
            ServerDAO.listSocketsSV2.add(socket);
            IDtoClientFindByID(Integer.parseInt(idUser));
            ServerDAO.listUser_atRoom.add(new UserAtRoom(idUser, userName, ready));
            showUserInRoom();
        } catch (IOException ex) {
            Logger.getLogger(QLSever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // -------------------------------------------------------------------------
    private void checkSQL() {
        try {
            String sql = "select * from information where userName = ? and pass = ?";
            ResultSet rs = jdbc.excuteQuery(sql, userName, pass);
            output = new DataOutputStream(socket.getOutputStream());
            while (true) {
                if (rs.next()) {
                    txtThongTinClient.append("Thông tin đã được tìm thấy\n");
                    output.writeUTF("true " + String.valueOf(rs.getInt(1)));
                } else {
                    output.writeUTF("false");
                }
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLSever.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QLSever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void IDtoClientFindByID(int ID) {
        try {
            txtThongTinClient.append("Accepted <3\n");
            ResultSet rs = dao.SelectByID(ID);
            if (rs.next()) {
                id = rs.getInt(1);
                userName = rs.getString(2);
                txtThongTinClient.append("ID and name user to client for join room : " + id + " " + userName);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QLSever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void IDtoClientFindByUser(String nameUser) {
        try {
            output = new DataOutputStream(socket.getOutputStream());
            ResultSet rs = dao.SelectByID(nameUser);
            if (rs.next()) {
                int idd = rs.getInt(1);
                txtThongTinClient.append("ID to client socket : " + idd + "\n");
                output.writeUTF(String.valueOf(id));
            }
        } catch (IOException ex) {
            Logger.getLogger(QLSever.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLSever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Information getIn4() {
        Information model = new Information();
        model.setUserName(userName);
        model.setPass(pass);
        model.setEmail(email);
        return model;
    }

    private void register() throws IOException {
        try {
            Information model = getIn4();
            dao.Insert(model);
            txtThongTinClient.append("----------Đăng kí thành công-----------\n");
        } catch (SQLException ex) {
            output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF("warring");
        }
    }

    // hiển thị danh sách phòng trong game -------------------------------------
    private void showRoom() {
        String show = "";
        try {
            output = new DataOutputStream(socket.getOutputStream());
            for (Room i : listRoom) {
                show = show + i.getIdRoom() + " " + i.getNameRoom() + " " + i.getPassRoom() + " ";
            }
            output.writeUTF(show);
            txtThongTinClient.append("*successful data push *showroom*\n");
        } catch (IOException ex) {
            Logger.getLogger(QLSever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // -------------------------------------------------------------------------

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPort = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtThongTinClient = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPort.setEditable(false);
        txtPort.setBackground(new java.awt.Color(0, 0, 0));
        txtPort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPort.setForeground(new java.awt.Color(255, 255, 255));
        txtPort.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPort.setText("*****************************************************");
        getContentPane().add(txtPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 700, 40));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Port Sever \"");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        txtThongTinClient.setEditable(false);
        txtThongTinClient.setBackground(new java.awt.Color(0, 0, 0));
        txtThongTinClient.setColumns(20);
        txtThongTinClient.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtThongTinClient.setForeground(new java.awt.Color(255, 255, 255));
        txtThongTinClient.setRows(5);
        jScrollPane1.setViewportView(txtThongTinClient);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 37, 840, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(QLSever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSever().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextArea txtThongTinClient;
    // End of variables declaration//GEN-END:variables
}
