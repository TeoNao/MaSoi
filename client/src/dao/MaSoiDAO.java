/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Room;
import helper.Auth;

import java.util.*;

/**
 *
 * @author thaip
 */
public class MaSoiDAO {
    public String outputRoom(Room entity) {
        return 3 +" "+ Auth.user.getId() +" "+ entity.getIdRoom() +" "+ entity.getNameRoom() +" "+ entity.getPassword();
    }
    public List<Room> inputRoom(String data){
        List<Room> list = new ArrayList();
        String[] words = data.split("\\s");
            for (int i = 0; i < words.length; i += 3) {
                Room room = new Room();
                room.setIdRoom(Integer.parseInt(words[i]));
                room.setNameRoom(words[i + 1]);
                room.setPassword(words[i + 2]);
                list.add(room);
            }
        return list;
    }
}
