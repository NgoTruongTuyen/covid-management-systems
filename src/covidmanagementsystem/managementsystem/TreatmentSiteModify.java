
package covidmanagementsystem.managementsystem;
import static covidmanagementsystem.managementsystem.UserModify.DB_URL;
import static covidmanagementsystem.managementsystem.UserModify.PASS;
import static covidmanagementsystem.managementsystem.UserModify.USER;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author 123
 */
public class TreatmentSiteModify
{  static  String DB_URL = "jdbc:mysql://ba789yyeviyfpuqmprn9-mysql.services.clever-cloud.com/ba789yyeviyfpuqmprn9";
  static String USER = "uuaeqsyvhif6hnzh";
  static  String PASS = "87pjEZXsG2Wgsu5eDQNB";
  
  
  public static List<TreatmentSite> findAll(){
        List<TreatmentSite> TreatmentSiteList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        User a = null;
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String req = "select * from TreatmentSite";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
                TreatmentSite newTreatmentSite=new TreatmentSite(result.getString("tsName"),
               
                result.getInt("capacity"),
                result.getInt("currentNumber"));
              
             TreatmentSiteList.add(newTreatmentSite);   
                
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
        return TreatmentSiteList;
    }
  
   public static List<String> findAllTreatmentSiteName(){
        List<String> TreatmentSiteNameList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        User a = null;
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String req = "select tsName from TreatmentSite";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             TreatmentSiteNameList.add(result.getString("tsName"));   
                
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
        return TreatmentSiteNameList;
    }
}
