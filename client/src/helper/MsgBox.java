/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author minha
 */
public class MsgBox {
    public static void alert(Component parent, String thongBao, int type){
        JOptionPane.showMessageDialog(parent,thongBao,"Thông báo",type);
    }
}
