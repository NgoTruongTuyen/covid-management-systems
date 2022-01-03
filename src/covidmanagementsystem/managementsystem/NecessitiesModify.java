
package covidmanagementsystem.managementsystem;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public interface NecessitiesModify {
    static String DB_URL = "jdbc:mysql://ba789yyeviyfpuqmprn9-mysql.services.clever-cloud.com/ba789yyeviyfpuqmprn9";
  static String USER = "uuaeqsyvhif6hnzh";
  static String PASS = "87pjEZXsG2Wgsu5eDQNB";
  
  public static List<Necessities> viewNecessities(){
        List<Necessities> nec = new ArrayList<>();

        Connection conn = null;
        ResultSet rs = null;
       
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String req = "select * from Necessities";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             Necessities temp = new Necessities(result.getString("id"),result.getString("name"),result.getInt("necessLimit"),
                     result.getInt("limitDate"),result.getInt("cost"));
             nec.add(temp);
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
        return nec;
    }
}
