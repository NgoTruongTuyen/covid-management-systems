
package covidmanagementsystem.managementsystem;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserModify {
  static  String DB_URL = "jdbc:mysql://ba789yyeviyfpuqmprn9-mysql.services.clever-cloud.com/ba789yyeviyfpuqmprn9";
  static String USER = "uuaeqsyvhif6hnzh";
  static  String PASS = "87pjEZXsG2Wgsu5eDQNB";
  
    
  public static User viewInformation(String username){
        List<User> userList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        User a = null;
        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String temp = "'"+ username + "'";
            String req = "select * from User where account = " + temp;
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
                User newUser=new User(result.getString("idCard"),
                result.getString("userName"),
                result.getString("dob"),
                result.getString("address"),
                result.getInt("state"),
                result.getString("treatmentSite"), result.getString("related"), result.getInt("dept"));
                
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
                result.getString("related"), result.getDouble("dept"));
                
                
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
      
    public static List<Bill>viewPurchaseHistory(String username){
        List<Bill> billList = new ArrayList<>();

        Connection conn = null;
        ResultSet rs = null;
        
       
        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String temp = "'"+ username + "'";
            String req = "select * from Bill,User where User.account = " + temp +" and User.idCard = Bill.userId";
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
                Bill newBill=new Bill(result.getString("id"),
                result.getString("userId"),
                result.getString("necessities"),
                result.getString("amount"),
                result.getInt("totalCost"),
                result.getString("BillDate"));
                
                billList.add(newBill);
                
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
       return billList;
    }
    
    public static List<PaymentHistory>viewPaymentHistory(String username){
        List<PaymentHistory> List = new ArrayList<>();

        Connection conn = null;
        ResultSet rs = null;
        
       
        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String temp = "'"+ username + "'";
            String req = "select * from PayHistory,User where User.account = " + temp +" and User.idCard = PayHistory.id";
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
                PaymentHistory newPay=new PaymentHistory(result.getString("id"),
                result.getInt("money"),
                result.getString("date"));
                
                List.add(newPay);
                
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
       return List;
    }
    public static List<ManagementHistory>viewManagementHistory(String username){
        List<ManagementHistory> List = new ArrayList<>();

        Connection conn = null;
        ResultSet rs = null;
        
       
        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String temp = "'"+ username + "'";
            String req = "select * from StatusHistory,User where User.account = " + temp +" and User.idCard = StatusHistory.id";
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
                ManagementHistory newStatusHistory=new ManagementHistory(result.getString("id"),
                result.getString("content"),
                result.getString("day"));
                
                List.add(newStatusHistory);
                
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
       return List;
    }
    
    public int updateDebt(String idCard, int newDebt) {
        String sqlUpdate = "update User set dept = ? where idCard = ?";
        int result = 0;
        
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            pstmt = conn.prepareStatement(sqlUpdate);
            pstmt.setInt(1, newDebt);
            pstmt.setString(2, idCard);
            
            
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

    public int savePaymentHistory(String idCard, int money, String date) {
        int result = 0;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
          
        String sqlInsert = "insert into PayHistory(id, money, date) values (?, ?, ?)";
        
        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            pstmt = conn.prepareStatement(sqlInsert);
            pstmt.setString(1, idCard);
            pstmt.setInt(2, money);
            pstmt.setString(3, date);

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
