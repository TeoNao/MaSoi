/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
/**
 *
 * @author minha
 */
public class ConnetServerDAO {

    private Socket socket;
    private String inetAddress = "26.204.84.167";
    //private String inetAddress = "localhost";
    private int port = 9999;

    public void connetServer() throws Exception{
        socket = null;
        try {
            socket = new Socket(inetAddress, port);
        } catch (Exception e) {
            throw new Exception("Không kết nối được với máy chủ!");
        }
    }
    public boolean checkConnet() throws Exception {
        if (socket==null){
            return false;
        }
        return true;
    }
    public void outputClinet(String str) {
        try {
            DataOutputStream dos = new DataOutputStream(this.socket.getOutputStream());
            dos.writeUTF(str);
            dos.flush();
        } catch (Exception e) {}
    }
    public String inputClient() throws Exception {
        try {
            DataInputStream dis = new DataInputStream(this.socket.getInputStream());
            String data = dis.readUTF();
            return data;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
