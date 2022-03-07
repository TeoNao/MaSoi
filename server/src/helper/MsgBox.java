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
    public static void alert(Component thiss,String thongBao,String tieuDe, int type){
        JOptionPane.showMessageDialog(thiss,thongBao,tieuDe,type);
    }
}
