
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
                result.getString("treatmentSite"),
                result.getString("related"));
                
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
     
    public static void delete(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
             connection = DriverManager.getConnection(DB_URL,USER, PASS);
            
         
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
      
    }
    
     public static void insert(User newUser) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
          connection = DriverManager.getConnection(DB_URL,USER, PASS);
            
          
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
    }
      public static void update(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = DriverManager.getConnection(DB_URL,USER, PASS);
            
       
            String sql = "update User set username=?,dob=?,address=?,state=?,treatmentSite=?,related=? where idCard = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, user.getName());
            statement.setString(2, user.getDOB());
            statement.setString(3, user.getAddress());
            statement.setInt(4, user.getState());
            statement.setString(5, user.getTreatmentSiteName());
            statement.setString(6, user.getRelated());
            statement.setString(7, user.getID());
            
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
       
    }
      
      public static List<User> findByFullname(String fullname) {
        List<User> userList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
           
              connection = DriverManager.getConnection(DB_URL,USER, PASS);
            
           
            String sql = "select * from User where username like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+fullname+"%");
            
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {                
                User std = new User(result.getString("idCard"),
                result.getString("userName"),
                result.getString("dob"),
                result.getString("address"),
                result.getInt("state"),
                result.getString("treatmentSite"),
                result.getString("related"));
               userList.add(std);
            }
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
       
        
        return userList;
    }
      
      
      public static List<User> findContact(String id) {
        List<User> userList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
           
              connection = DriverManager.getConnection(DB_URL,USER, PASS);
            
           
            String sql = "select * from User where related like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+id+"%");
            
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {                
                User std = new User(result.getString("idCard"),
                result.getString("userName"),
                result.getString("dob"),
                result.getString("address"),
                result.getInt("state"),
                result.getString("treatmentSite"));
               userList.add(std);
            }
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
       
        
        return userList;
    }
}
