
package covidmanagementsystem.managementsystem;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserModify {
  static  String DB_URL = "jdbc:mysql://ba789yyeviyfpuqmprn9-mysql.services.clever-cloud.com/ba789yyeviyfpuqmprn9";
  static String USER = "uuaeqsyvhif6hnzh";
  static  String PASS = "87pjEZXsG2Wgsu5eDQNB";
  
    
  public static User viewInformation(String ID){
        List<User> userList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        User a = null;
        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String req = "select * from User where IDcard="+ID;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
                User newUser=new User(result.getString("idCard"),
                result.getString("userName"),
                result.getString("dob"),
                result.getString("address"),
                result.getInt("state"),
                result.getString("treatmentSite"));
                
             a = newUser;
                
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
       return a;
    }
  
    public static List<User> findAll(){
        List<User> userList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        User a = null;
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String req = "select * from User";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
                User newUser=new User(result.getString("idCard"),
                result.getString("userName"),
                result.getString("dob"),
                result.getString("address"),
                result.getInt("state"),
                result.getString("treatmentSite"));
                
             userList.add(newUser);   
                
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
        return userList;
    }
     
}
