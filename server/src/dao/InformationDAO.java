/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import helper.*;
import java.sql.SQLException;
import model.*;
import java.sql.*;
/**
 *
 * @author minha
 */
public class InformationDAO {
    jdbc jdbcHelper = new jdbc();
    public void Insert(Information model) throws SQLException{
        String sql = "insert into information values (?,?,?)";
        jdbcHelper.excuteUpdate(sql,model.getUserName(),model.getPass(),model.getEmail());
    }
    public ResultSet SelectByID(String userName) throws SQLException {
        String sql = "select ID FROM information WHERE userName = ?";
        return jdbcHelper.excuteQuery(sql,userName);
    }
    public ResultSet SelectByID(int idUser) throws SQLException {
        String sql = "select ID,userName FROM information WHERE ID = ?";
        return jdbcHelper.excuteQuery(sql,idUser);
    } 
}
