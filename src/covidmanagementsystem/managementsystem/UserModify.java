
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
//     public static void insert(User std) {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        
//        try {
//            //lay tat ca danh sach sinh vien
//            connection = DriverManager.getConnection(DB_URL,USER, PASS);
//            
//            //query
//            String sql = "insert into User (fullname, gender, age, email, phone_number) values(?, ?, ?, ?, ?)";
//            statement = connection.prepareCall(sql);
//            
//            statement.setString(1, std.getFullname());
//            statement.setString(2, std.getGender());
//            statement.setInt(3, std.getAge());
//            statement.setString(4, std.getEmail());
//            statement.setString(5, std.getPhoneNumber());
//            
//            statement.execute();
//        } catch (SQLException ex) {
//            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if(statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        //ket thuc.
//    }
     
    public static void delete(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
             connection = DriverManager.getConnection(DB_URL,USER, PASS);
            
            //query
            String sql = "delete from User where idCard = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
     public static void insert(User newUser) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
          connection = DriverManager.getConnection(DB_URL,USER, PASS);
            
            //query
            String sql = "insert into User(IdCard,username, dob, address,state,treatmentSite,related,dept,account) values(?, ?, ?, ?, ?,?,?,?,?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, newUser.getID());
            statement.setString(2, newUser.getName());
            statement.setString(3, newUser.getDOB());
            statement.setString(4, newUser.getAddress());
            statement.setInt(5, newUser.getState());
            statement.setString(6, newUser.getTreatmentSiteName());
            statement.setString(7, newUser.getRelated());
            statement.setDouble(8, newUser.getDept());
            statement.setString(9, "user"+newUser.getID());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
}
