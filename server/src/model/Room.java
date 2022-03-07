/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author minha
 */
public class Room {
    private String idRoom,nameRoom,passRoom,idUser;
   

    public Room() {
    }

    public Room(String idUser,String idRoom, String nameRoom, String passRoom) {
        this.idUser = idUser;
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.passRoom = passRoom;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getPassRoom() {
        return passRoom;
    }

    public void setPassRoom(String passRoom) {
        this.passRoom = passRoom;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    
 
}
