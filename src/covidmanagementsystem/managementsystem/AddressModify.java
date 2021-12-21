package covidmanagementsystem.managementsystem;
import static covidmanagementsystem.managementsystem.AddressModify.DB_URL;
import static covidmanagementsystem.managementsystem.AddressModify.PASS;
import static covidmanagementsystem.managementsystem.AddressModify.USER;
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
public class AddressModify {
  static String DB_URL = "jdbc:mysql://ba789yyeviyfpuqmprn9-mysql.services.clever-cloud.com/ba789yyeviyfpuqmprn9";
  static String USER = "uuaeqsyvhif6hnzh";
  static String PASS = "87pjEZXsG2Wgsu5eDQNB";
  
  public static List<String> findAllCity(){
        List<String> cityList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        User a = null;
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String req = "select DISTINCT city from Address";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             cityList.add(result.getString("city"));      
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
        return cityList;
    }
  
   public static List<String> findAllDistrict(String cityName){
        List<String> districtList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        User a = null;
        try {  
            connection = DriverManager.getConnection(DB_URL,USER, PASS);
            String req = "select DISTINCT distric from Address where city =? ";
            statement = connection.prepareCall(req);
            
            statement.setString(1, cityName);
            
             ResultSet resultSet = statement.executeQuery();
            if(resultSet!=null)
            {
            while(resultSet.next()){
             districtList.add(resultSet.getString("distric"));      
            }
            }
           
           
        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        }
      if(connection != null){
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
            }
      } 
        return districtList;
    }
   
   
    public static List<String> findAllVillage(String districtName){
        List<String> villagetList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        User a = null;
        try {  
            connection = DriverManager.getConnection(DB_URL,USER, PASS);
            String req = "select DISTINCT ward from Address where distric =? ";
            statement = connection.prepareCall(req);
            
            statement.setString(1, districtName);
            
             ResultSet resultSet = statement.executeQuery();
            if(resultSet!=null)
            {
            while(resultSet.next()){
             villagetList.add(resultSet.getString("ward"));      
            }
            }
           
           
        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        }
      if(connection != null){
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
            }
      } 
        return villagetList;
    }
}



