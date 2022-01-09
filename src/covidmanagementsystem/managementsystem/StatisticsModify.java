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
     static  String DB_URL = "jdbc:mysql://localhost:3306/covid_management_system";
  static String USER = "root";
  static  String PASS = "";
   
  
    
  public static HashMap<String, String> getUserStatistic() {
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
         
            keyword="thành";
            sql = "select state,count(*) as StatisticResult from User group by state";
            Statement ts = conn.createStatement();
            result = ts.executeQuery(sql);
            
            while(result.next()){
               statistic.put(result.getString("state"),result.getString("StatisticResult"));
                
            };
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
   public static HashMap<String, Integer> getNeccessitiesStatistic() {
        HashMap<String, Integer> statistic=new HashMap<String, Integer>();
        String keyword="";
      
        Connection conn = null;
        ResultSet rs = null;
        
        User a = null;
        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String sql = "select * from Bill";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            statistic.put("totalCost",0);
            statistic.put("totalSold",0);
            while(result.next()){
               String[] necessities=result.getString("necessities").split(",");
               String[] amounts=result.getString("amount").split(",");
               statistic.put("totalCost",statistic.get("totalCost")+Integer.parseInt(result.getString("totalCost")));
             
              
               if(necessities.length==amounts.length)
               {
                   for(int i=0;i<necessities.length;i++)
                   {
                       necessities[i]=necessities[i].trim();
                       statistic.put("totalSold",Integer.parseInt(amounts[i].replace(" ",""))+statistic.get("totalSold"));
                      if(statistic.get(necessities[i])==null)
                      {
                          statistic.put(necessities[i],0);
                      }
                      else
                       statistic.put(necessities[i],Integer.parseInt(amounts[i].replace(" ",""))+statistic.get(necessities[i]));
                      
                 
                   }
               }
                
            };
         
           
           
           
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
  
     public static HashMap<String, Integer> getDebitStatistic() {
        HashMap<String, Integer> statistic=new HashMap<String, Integer>();
        String keyword="";
      
        Connection conn = null;
        ResultSet rs = null;
        
        User a = null;
        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String sql = "select * from Bill";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            statistic.put("totalCost",0);
            statistic.put("totalSold",0);
            while(result.next()){
             
                
            };
         
           
           
           
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
