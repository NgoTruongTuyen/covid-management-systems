
package covidmanagementsystem.managementsystem;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserModify {
   
   
    public static User viewInformation(String ID){
        Connection conn = null;
        String DB_URL = "jdbc:mysql://localhost/java";
        String USER = "root";
        String PASS = "123456789"; 
        User a = null;
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String req = "select * from user where idCard =" + ID;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
                String id = result.getString("idCard");
                String name = result.getString("userName");
                String dob = result.getString("dob");
                int state = result.getInt("state");
                String related = result.getString("related");
                double dept = result.getDouble("debit");
                String add = result.getString("address");
                
                a = new User(id,name,dob,add,state,related,dept);
                
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
     
}
