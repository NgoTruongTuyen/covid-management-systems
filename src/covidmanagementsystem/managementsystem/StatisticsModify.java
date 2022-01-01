/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidmanagementsystem.managementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 123
 */
public class StatisticsModify {
     static  String DB_URL = "jdbc:mysql://ba789yyeviyfpuqmprn9-mysql.services.clever-cloud.com/ba789yyeviyfpuqmprn9";
  static String USER = "uuaeqsyvhif6hnzh";
  static  String PASS = "87pjEZXsG2Wgsu5eDQNB";
   
  
    
  public static HashMap<String, String> getCurrentStatistic() {
       HashMap<String, String> statistic=new HashMap<String, String>();
        String keyword="";
      
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        User a = null;
        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            keyword="thành";
            String sql = "select count(*) as StatisticResult from StatusHistory where content like ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, "%"+keyword+"%");
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
               statistic.put("statusChange",result.getString("StatisticResult"));
                
            };
            keyword="chuyển";
            sql = "select count(*) as StatisticResult from StatusHistory where content like ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, "%"+keyword+"%");
            
            result = statement.executeQuery();
            
            while(result.next()){
               
                
                statistic.put("treatmentChange",result.getString("StatisticResult"));
               
                
                
            }
            keyword="hồi phục";
            sql = "select count(*) as StatisticResult from StatusHistory where content like ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, "%"+keyword+"%");
            
            result = statement.executeQuery();
            
            while(result.next()){
               
                
                statistic.put("recovered",result.getString("StatisticResult"));
               
                
                
            }
           
           
        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        }
      if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
            }
      } 
      return statistic;
    }
}
