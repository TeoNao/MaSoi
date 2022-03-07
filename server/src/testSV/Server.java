/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testSV;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minha
 */
public class Server {
    private int port;
    public static ArrayList<Socket> listSK;
    public Server(int port){
        this.port = port;
    }
    private void execute() throws IOException{
       
            ServerSocket server = new ServerSocket(port);
            WriteSever write = new WriteSever();
            write.start();
            System.out.println("server đang lắng nghe....");
            while (true) {
                    Socket socket = server.accept();
			System.out.println("Đã kết nối với " + socket);
			Server.listSK.add(socket);
			ReadSever read = new ReadSever(socket);
			read.start();
            }
        
    }
     public static void main(String[] args) throws IOException {
		Server.listSK = new ArrayList<>();
		Server server = new Server(15797);
		server.execute();
	}
}
    class ReadSever extends Thread{
        private Socket socket;
        public ReadSever(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run(){
            try {
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                while (true) {                    
                    String sms = dis.readUTF();
                    if (sms.equals("exit")) {
                        Server.listSK.remove(socket);
                        System.out.println("đã ngắt kết nối với socket "+ socket);
                        dis.close();
                        socket.close();
                        continue;
                    }
                    for (Socket i : Server.listSK) {
                        if (i.getPort() != socket.getPort()) {
                            DataOutputStream dos = new DataOutputStream(i.getOutputStream());
                            dos.writeUTF(sms);
                        }
                    }
                    System.out.println(sms);
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class WriteSever extends Thread{

        @Override
        public void run() {
            DataOutputStream dos = null;
            Scanner sc = new Scanner(System.in);
            while (true) {                
                String sms = sc.nextLine();
                for (Socket i : Server.listSK) {
                    try {
                        dos = new DataOutputStream(i.getOutputStream());
                        dos.writeUTF("server : "+sms);
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
       

    }

