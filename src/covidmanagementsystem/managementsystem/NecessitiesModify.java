
package covidmanagementsystem.managementsystem;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
            String req = "select * from Necessities where limitDate >= CURRENT_DATE() order by id ASC";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             Necessities temp = new Necessities(result.getString("id"),result.getString("name"),result.getInt("stock"),
                     result.getString("limitDate"),result.getInt("cost"));
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
  public static List<Necessities> searchNecessities(String name){
        List<Necessities> nec = new ArrayList<>();

        Connection conn = null;
        ResultSet rs = null;
       
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String tmp = "'%"+ name + "%'";
            String req = "select * from Necessities where limitDate >= CURRENT_DATE() and name like " + tmp;
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             Necessities temp = new Necessities(result.getString("id"),result.getString("name"),result.getInt("stock"),
                     result.getString("limitDate"),result.getInt("cost"));
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
    public static List<Necessities> sortNecessitiesAZ(){
        List<Necessities> nec = new ArrayList<>();

        Connection conn = null;
        ResultSet rs = null;
       
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String req = "select * from Necessities where limitDate >= CURRENT_DATE() order by name ASC";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             Necessities temp = new Necessities(result.getString("id"),result.getString("name"),result.getInt("stock"),
                     result.getString("limitDate"),result.getInt("cost"));
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
    public static List<Necessities> sortNecessitiesZA(){
        List<Necessities> nec = new ArrayList<>();

        Connection conn = null;
        ResultSet rs = null;
       
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String req = "select * from Necessities where limitDate >= CURRENT_DATE() order by name DESC";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             Necessities temp = new Necessities(result.getString("id"),result.getString("name"),result.getInt("stock"),
                     result.getString("limitDate"),result.getInt("cost"));
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
    public static List<Necessities> sortNecessitiesSmallToLarge(){
        List<Necessities> nec = new ArrayList<>();

        Connection conn = null;
        ResultSet rs = null;
       
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String req = "select * from Necessities where limitDate >= CURRENT_DATE() order by cost ASC ";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             Necessities temp = new Necessities(result.getString("id"),result.getString("name"),result.getInt("stock"),
                     result.getString("limitDate"),result.getInt("cost"));
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
    public static List<Necessities> sortNecessitiesLargeToSmall(){
        List<Necessities> nec = new ArrayList<>();

        Connection conn = null;
        ResultSet rs = null;
       
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String req = "select * from Necessities where limitDate >= CURRENT_DATE() order by cost DESC";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             Necessities temp = new Necessities(result.getString("id"),result.getString("name"),result.getInt("stock"),
                     result.getString("limitDate"),result.getInt("cost"));
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
    public static List<Necessities> filterNecessities(String price , String stock){
        List<Necessities> nec = new ArrayList<>();

        Connection conn = null;
        ResultSet rs = null;
        String req1 = "";
        String req2 = "";
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            if("< 100000".equals(price)){
                req1 = " and cost < 100000 ";
            }
            if("100000 to 500000".equals(price)){
                req1 = " and cost >= 100000 and cost <= 500000 ";
            }
            if("> 500000".equals(price)){
                req1 = " and cost > 500000 ";
            }
            if("< 100".equals(stock)){
                req2 = " and stock < 100 ";
            }
            if("100 to 200".equals(stock)){
                req2 = " and stock >= 100 and stock <= 200 ";
            }
            if("> 200".equals(stock)){
                req2 = " and stock > 200 ";
            }
            String req = "select * from Necessities where limitDate >= CURRENT_DATE()" + req1 + req2;
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             Necessities temp = new Necessities(result.getString("id"),result.getString("name"),result.getInt("stock"),
                     result.getString("limitDate"),result.getInt("cost"));
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
    public static boolean checkStock(String id, String amount){
        
        Connection conn = null;
        ResultSet rs = null;
        int am = 0;
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String tmp = "'" + id + "'";
            String req = "select * from Necessities where id = " + tmp;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
              am = result.getInt("stock");
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
        if(am - Integer.parseInt(amount) >= 0){
            return true;
        }
        else{
            return false;
        }
    }
    public static int getStock(String id){
        
        Connection conn = null;
        ResultSet rs = null;
        int stock = 0;
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String tmp = "'"+ id + "'";
            String req = "select * from Necessities where limitDate >= CURRENT_DATE() and id =" + tmp;
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            
           while(result.next()){
               
              stock = result.getInt("stock");
              
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
       return stock; 
    }
    public static int getPrice(String id){
        Connection conn = null;
        ResultSet rs = null;
        int price = 0;
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String tmp = "'"+ id + "'";
            String req = "select * from Necessities where limitDate >= CURRENT_DATE() and id =" + tmp;
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            
           while(result.next()){
               
              price = result.getInt("cost");
              
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
       return price; 
    }
    public static void updateStock(String id, String amount){
        Connection conn = null;
        ResultSet rs = null;
        
        try { 
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String sqlUpdate = "UPDATE Necessities "
                + "SET stock = ? "
                + "WHERE id = ?";
 
            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
            
            int stock = getStock(id) - Integer.parseInt(amount);
            pstmt.setInt(1, stock);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
           
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
        
    }
    public static int getDept(String account){
        Connection conn = null;
        ResultSet rs = null;
        int price = 0;
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String tmp = "'"+ account + "'";
            String req = "select * from User where account =" + tmp;
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            
           while(result.next()){
               
              price = result.getInt("dept");
              
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
       return price; 
    }
    public static String getUserId(String account){
        Connection conn = null;
        ResultSet rs = null;
        String id = "";
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String tmp = "'"+ account + "'";
            String req = "select * from User where account =" + tmp;
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            
           while(result.next()){
               
              id = result.getString("idCard");
              
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
       return id; 
    }
    public static void updateDept(String username, int amount){
        Connection conn = null;
        ResultSet rs = null;
        
        try { 
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String sqlUpdate = "UPDATE User "
                + "SET dept = ? "
                + "WHERE account = ?";
 
            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
            
           
            pstmt.setInt(1, amount + getDept(username));
            pstmt.setString(2, username);
            pstmt.executeUpdate();
           
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
        
    }
    public static String getMaxIdBill(){
        Connection conn = null;
        ResultSet rs = null;
        int id = 0;
        String tmp = "";
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            
            String req = "select MAX(CAST(id as SIGNED)) as id from Bill";
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            
           while(result.next()){ 
              id = result.getInt("id"); 
            }
           id+=1;
           tmp = String.valueOf(id) ;
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
       return tmp; 
    }
    
    public static boolean buyNecessities(String a[][], int row , String username){
        List<Necessities> nec = new ArrayList<>();
        for(int i = 0 ;i < row ; i++){          
                if(checkStock(a[i][0],a[i][2]) == false){
                    return false;
                } 
        }
        int total = 0;
        for(int i = 0 ;i < row ; i++){ 
            updateStock(a[i][0],a[i][2]);
            total += getPrice(a[i][0]) * Integer.parseInt(a[i][2]);  
        }
        
        updateDept(username,total);
        String id = getMaxIdBill();
        String userId = getUserId(username);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime now = LocalDateTime.now();
        String date = now.toString();
        date = date.substring(0,10);  
        String listNecess = "";
        String listAmount = "";
        for(int i = 0 ;i < row ; i++){                  
            listNecess+=a[i][1];
            listAmount+=a[i][2];
            if(i!=row-1){
                listNecess+= ", ";
                listAmount+= ", ";
            }
        }
        
                
        Connection conn = null;
        ResultSet rs = null;
       
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String sql = "INSERT INTO Bill(id,userid,necessities,amount,totalCost,billDate) "+ "VALUES(?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, id);
            pstmt.setString(2, userId);
            pstmt.setString(3, listNecess);
            pstmt.setString(4, listAmount);
            pstmt.setInt(5, total);
            pstmt.setDate(6, java.sql.Date.valueOf(date));
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {
              return true;
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
        return true;
    }
}
