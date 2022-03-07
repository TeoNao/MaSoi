/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author minha
 */
public class jdbc {
     static Connection connection; 
    public static void connect(){
         try {
             String url = "jdbc:sqlserver://MINHAN\\SQLEXPRESS:1433;databaseName=MaSoi;user=sa;password=123456789";
             connection = DriverManager.getConnection(url);
             System.out.println("kết nối thành công");
         } catch (SQLException ex) {
             Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public static  PreparedStatement preparedStatement(String sql,Object...args) throws SQLException{
        connect();
        PreparedStatement pstm = null;
        if (sql.trim().startsWith("{")) {
           pstm = connection.prepareCall(sql);
        }else{
            pstm = connection.prepareStatement(sql);
        }
        for (int i = 0; i <args.length; i++) {
             pstm.setObject(i+1,args[i]);
        }
        return pstm;
    }
    public static void excuteUpdate(String sql, Object...args) throws SQLException{       
             PreparedStatement pstm = preparedStatement(sql, args);
             pstm.executeUpdate();
         
    }
    public static ResultSet excuteQuery(String sql, Object...args) throws SQLException{
        PreparedStatement pstm = preparedStatement(sql, args);
        return pstm.executeQuery();
    }
}
