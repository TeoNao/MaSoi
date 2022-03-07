/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.net.Socket;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author minha
 */
public class ServerDAO {
     public static ArrayList<Socket> listSockets = new ArrayList<>();
     public static ArrayList<UserAtRoom> listUser_atRoom = new ArrayList<>();
     public static ArrayList<Socket> listSocketsSV2 = new ArrayList<>();
     public static  ArrayList<Integer> listRandom_role = new ArrayList<>();
     public static  ArrayList<VoteUser> listVote = new ArrayList<>();
}
