/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thaip
 */
public class test {
    // static boolean check = false;
    // static int ran;
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
    //     String str = "\u001B[31m Hệ thống: ";
    //     System.out.println(str + "Trò chơi bất đầu sau " );
    //     List<Integer> list = new ArrayList<>();
    //     Random random = new Random();
    //     String[] arr = {"1", "2", "3", "4", "5", "1", "2", "3", "4", "5", "1", "12"};
    //     ran = random.nextInt(arr.length);
    //     list.add(ran);
    //     try {
    //         for (int i = 0; i < arr.length-1;) {
    //             ran = random.nextInt(arr.length);
    //             for (Integer j : list) {
    //                 check = true;
    //                 if (ran == j){
    //                     check = false;
    //                     break;
    //                 }
    //             }
    //             if (check == true){
    //                 list.add(ran);
    //                 i++;
    //             }
    //         }
    //         System.out.println(list.toString());
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
//        String str = "vote 2 2";
//
//        String[] words = str.substring(5, str.length()).split("\\s");
//        String[][] arr = new String[2][2];
//        // arr[0][0] = "1";
//        // arr[0][1] = "2";
//
//
//        List<Integer> list = new ArrayList<>(); // danh id người chơi trong phòng
//        list.add(1);
//        list.add(2);
//
//        for (int i = 0; i < list.size(); i++) {
//            if (Integer.parseInt(words[1]) == list.get(i)){
//                System.out.println("vote player["+i+"] -------------");
//                boolean check = true;
//                int j = 0;
//                for (; j < arr.length; j++) {
//                    if (arr[i][j] == null){
//                        break;
//                    }
//                    if (arr[i][j].equals(words[0])){
//                        check = false;
//                        break;
//                    }
//                }
//                if(check){
//                    arr[i][j] = words[0];
//                }else{
//                    System.out.println("Vote đã có....");
//                }
//            }
//        }
//        int maxV = 0;
//        int idplayer = 0;
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println("player["+i+"] -------------");
//            int tong = 0;
//            for (int j = 0; j < arr.length; j++) {
//                System.out.println(arr[i][j]);
//                if (arr[i][j] != null){
//                    tong ++;
//                }
//            }
//            if (tong > maxV){
//                maxV = tong;
//                idplayer = i;
//            }
//            System.out.println("tổng: " + tong + " ID: " + i);
//        }
//        System.out.println("Người chơi vote nhiều nhất: " + list.get(idplayer));


//        InetAddress ip = InetAddress.getLocalHost();
//        System.out.print("My IP address is: ");
//        System.out.println(ip.getHostAddress());


//        Enumeration<NetworkInterface> interfaces = null;
//            try {
//                interfaces = NetworkInterface.getNetworkInterfaces();
//            } catch (SocketException ex) {
//                Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        while (interfaces.hasMoreElements()) {
//            NetworkInterface networkInterface = interfaces.nextElement();
//            // drop inactive
//            if (!networkInterface.isUp())
//                continue;
//
//            // smth we can explore
//            Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
//            while(addresses.hasMoreElements()) {
//                InetAddress addr = addresses.nextElement();
//                System.out.println(String.format("NetInterface: name [%s], ip [%s]",
//                networkInterface.getDisplayName(), addr.getHostAddress()));
//            }
//        }


//        try {
//            Process proc = Runtime.getRuntime().exec("arp -a ");
//
//            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//            BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
//
//            // read the output from the command
//            String s = null;
//
//            while ((s = stdInput.readLine()) != null) {
//                System.out.println(s);
//
//            // read any errors from the attempted command
//            while ((s = stdError.readLine()) != null) {
//                System.err.println(s);
//            }
//            }}catch (IOException ex) {
//            System.err.println(ex);
//        } 
    }
}
