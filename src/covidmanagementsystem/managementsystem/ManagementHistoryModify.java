/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidmanagementsystem.managementsystem;

import static covidmanagementsystem.managementsystem.UserModify.DB_URL;
import static covidmanagementsystem.managementsystem.UserModify.PASS;
import static covidmanagementsystem.managementsystem.UserModify.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 123
 */
public class ManagementHistoryModify {
  static  String DB_URL = "jdbc:mysql://ba789yyeviyfpuqmprn9-mysql.services.clever-cloud.com/ba789yyeviyfpuqmprn9";
  static String USER = "uuaeqsyvhif6hnzh";
  static  String PASS = "87pjEZXsG2Wgsu5eDQNB";
   public static List<ManagementHistory> findById(String id){
        List<ManagementHistory> ManagementList = new ArrayList<>();

       Connection connection = null;
       PreparedStatement statement = null;
        
    
        try {  
            connection = DriverManager.getConnection(DB_URL,USER, PASS);
            String sql = "select * from StatusHistory where id = ? ";
             
            statement = connection.prepareCall(sql);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            
//           statement.execute();
            while(result.next()){
                ManagementHistory newRecord=new ManagementHistory(result.getString("id"),
                result.getString("content"),
                result.getString("day"));
                
             ManagementList.add(newRecord);   
                
            }
           
           
        } catch (SQLException ex) {
            Logger.getLogger(ManagementHistoryModify.class.getName()).log(Level.SEVERE, null, ex);
        }
      if(connection != null){
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ManagementHistoryModify.class.getName()).log(Level.SEVERE, null, ex);
            }
      } 
        return ManagementList;
    }
  public static void insert(ManagementHistory newrecord) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
          connection = DriverManager.getConnection(DB_URL,USER, PASS);
            
          
            String sql = "insert into StatusHistory(Id,Content,day) values(?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, newrecord.getId());
            statement.setString(2, newrecord.getContent());
            statement.setString(3, newrecord.getDate());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ManagementHistoryModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManagementHistoryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManagementHistoryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
