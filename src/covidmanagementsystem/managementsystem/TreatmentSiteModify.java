
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
public class TreatmentSiteModify {   
    static  String DB_URL = "jdbc:mysql://ba789yyeviyfpuqmprn9-mysql.services.clever-cloud.com/ba789yyeviyfpuqmprn9";
    static String USER = "uuaeqsyvhif6hnzh";
    static  String PASS = "87pjEZXsG2Wgsu5eDQNB";
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
  
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
   
   Boolean existedName(String name) {
         String sqlSelect = "select * from TreatmentSite where tsName = ?";
        
        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setString(1, name);
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return true;
            }
            else {
                return false;
            }
            
        } catch (SQLException e) {
        }
        finally{
            try {
                conn.close();
                pstmt.close();
                rs.close();
            } catch (SQLException e) {
            }
        }
        
        return true;
    }
   
    public int addTreatmentSite(TreatmentSite treatmentSite) {
        int result = 0;
        if (!existedName(treatmentSite.getName())) {
            String sqlInsert = "insert into TreatmentSite(tsName, capacity, currentNumber) values (?, ?, ?)";
            

            try {
                conn = DriverManager.getConnection(DB_URL,USER, PASS);
                pstmt = conn.prepareStatement(sqlInsert);
                pstmt.setString(1, treatmentSite.getName());
                pstmt.setInt(2, treatmentSite.getCapacity());
                pstmt.setInt(3, treatmentSite.getCurrentNumber());

                result = pstmt.executeUpdate();
            } catch (SQLException e) {
            }
            finally{
                try {
                    conn.close();
                    pstmt.close();
                } catch (SQLException e) {
                }
            }
        }
        
        return result;
    }
    
    public int updateTreatmentSite(String name, int capacity, int currentNumber) {
        int result = 0;
        String sqlUpdate = "update TreatmentSite set capacity = ?, currentNumber = ? where tsName = ?";
        
        
        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            pstmt = conn.prepareStatement(sqlUpdate);
            pstmt.setInt(1, capacity);
            pstmt.setInt(2, currentNumber);
            pstmt.setString(3, name);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
        }
        finally{
            try {
                conn.close();
                pstmt.close();
            } catch (SQLException e) {
            }
        }
        
        return result;
    }
}
