/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testSV;

import dao.ServerDAO;
import java.util.ArrayList;
import java.util.List;
import model.UserAtRoom;

/**
 *
 * @author minha
 */
public class testjdbc {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
       list.add("1");
       list.add("1");
       list.add("2");
       list.add("1");
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).equals("1")) {
                list.remove(i);
               break;
            }
        }
        for (String i : list) {
            System.out.println(i);
        }
    }
}
