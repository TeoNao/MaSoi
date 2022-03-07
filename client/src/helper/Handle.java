/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


/**
 *
 * @author thaip
 */
public class Handle {

    public static boolean role;
    private Component UserJDialog;

    public static void checkNull(JTextField... args ) throws Null{
        for (int i = 0; i < args.length; i++) {
            if (args[i].getText().equals("")){
                throw new Null("Không để trống thông tin!");
            }
        }
    }
    public static void checkNullRegister(JTextField... args ) throws Null{
        Boolean check = true;
        for (int i = 0; i < args.length; i++) {
            if (args[i].getText().equals("")){
                args[i].setBorder(new LineBorder(Color.red,1));
                check = false;
            }
        }
        if (!check){
            throw new Null("Không để trống thông tin!");
        }
    }
    private static class Null extends Exception {
        public Null(String e) {
            super(e);
        }
    }
    public static boolean checkPass(JTextField JT1, JTextField JT2){
        if (!JT1.getText().equals(JT2.getText())){
            return false;
        }
        return true;
    }
    public static String[] role() {
        String[] arrRole = {"Sói đầu đàn", "Sói trẻ", "Sói tri", "Thầy đồng", "Tiên tri", "Thiên thần", "Bảo vệ", "Thợ săn", "Dân làng", "Pháp sư", "Sát thủ", "Ngố"};
        return arrRole;
    }
    public static void dataPlayer(String data, JLabel... lbl){
        String[] words = data.split("\\s");
        for (int i = 0; i < lbl.length; i++) {
            lbl[i].setText(null);
        }
        for (int i = 0; i < words.length; i+=3) {
            lbl[i].setText(words[i]);
            lbl[i+1].setText(words[i+1]);
            if (words[i+2].equals("true")){
                lbl[i+2].setText("Chuẩn bị");
            }
            if (words[i+2].equals("0")){
                lbl[i+2].setText("Chủ phòng");
            }
        }
    }
    public static void vote(String data, JLabel... lbl) {
        String[] words = data.substring(5, data.length()).split("\\s");
        for (int i = 0; i < lbl.length; i+=2) {
            if (lbl[i].getText() != null){
                if (lbl[i].getText().equals(words[0])){
                    lbl[i+1].setText(words[1]);
                }
            }
        }
    }
    public static void unvote(String data, JLabel... lbl) {
        String[] words = data.substring(7, data.length()).split("\\s");
        for (int i = 0; i < lbl.length; i+=2) {
            if (lbl[i].getText() != null){
                if (lbl[i].getText().equals(words[1])){
                    int vote = Integer.parseInt(lbl[i+1].getText())-1;
                    lbl[i+1].setText(vote+"");
                    System.out.println(vote+"da tru");
                }
            }
        }
    }
}
