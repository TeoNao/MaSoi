/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;

/**
 *
 * @author thaip
 */
public class UserDAO {
    public String outputUser(User entity) {
        return 1 +" "+ entity.getUserName() +" "+ entity.getPass();
    }
    public String outputRegister(User entity) {
        return 2 +" "+ entity.getUserName()+" "+ entity.getPass()+" "+ entity.getEmail();
    }
}
