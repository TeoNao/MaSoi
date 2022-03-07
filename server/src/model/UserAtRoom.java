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
public class UserAtRoom {
    private String id,name;
    private boolean ready;

    public UserAtRoom(String id, String name, boolean ready) {
        this.id = id;
        this.name = name;
        this.ready = ready;
    }
//    public UserAtRoom(String id, String name) {
//        this.id = id;
//        this.name = name;
//        
//    }
    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
