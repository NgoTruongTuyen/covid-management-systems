
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
            String req = "select * from Necessities order by id ASC";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             Necessities temp = new Necessities(result.getString("id"),result.getString("name"),result.getInt("limitNecess"),
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
            String req = "select * from Necessities where name like " + tmp;
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             Necessities temp = new Necessities(result.getString("id"),result.getString("name"),result.getInt("limitNecess"),
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
            String req = "select * from Necessities order by name ASC";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             Necessities temp = new Necessities(result.getString("id"),result.getString("name"),result.getInt("limitNecess"),
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
            String req = "select * from Necessities order by name DESC";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             Necessities temp = new Necessities(result.getString("id"),result.getString("name"),result.getInt("limitNecess"),
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
            String req = "select * from Necessities order by cost ASC ";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             Necessities temp = new Necessities(result.getString("id"),result.getString("name"),result.getInt("limitNecess"),
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
            String req = "select * from Necessities order by cost DESC";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             Necessities temp = new Necessities(result.getString("id"),result.getString("name"),result.getInt("limitNecess"),
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
    public static List<Necessities> filterNecessities(String price , String limit){
        List<Necessities> nec = new ArrayList<>();

        Connection conn = null;
        ResultSet rs = null;
        String req1 = "";
        String req2 = "";
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            if("< 100000".equals(price)){
                req1 = " cost < 100000 ";
            }
            if("100000 to 500000".equals(price)){
                req1 = " cost >= 100000 and cost <= 500000 ";
            }
            if("> 500000".equals(price)){
                req1 = " cost > 500000 ";
            }
            if("< 10".equals(limit)){
                req2 = " and limitNecess < 10 ";
            }
            if("10 to 40".equals(limit)){
                req2 = " and limitNecess >= 10 and limitNecess <= 40 ";
            }
            if("> 40".equals(limit)){
                req2 = " and limitNecess > 40 ";
            }
            if("...".equals(price)){
                req2 = req2.replace("and","");
            }
            
            String req = "select * from Necessities where " + req1 + req2;
            System.out.println(req);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            while(result.next()){
             Necessities temp = new Necessities(result.getString("id"),result.getString("name"),result.getInt("limitNecess"),
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
    public static boolean checkStock(String id, String amount, String username){
        
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
                am = getAmountHadBought(username,result.getString("name"),result.getString("limitDate"));
              
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
    public static String getTime(String limitTime){
        String temp[] = limitTime.split(" ");
        int numDay = 0;
        int num = Integer.valueOf(temp[0]);
        
        if("day".equals(temp[1])){
            numDay = num;
        }
        if("week".equals(temp[1])){
            numDay = num * 7;
        }
        if("month".equals(temp[1])){
            numDay = num*30;
        }
        numDay= -numDay;
        
        LocalDateTime ldt = LocalDateTime.now().plusDays(numDay);
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        String formatter = formmat1.format(ldt);
        return formatter;
    }
    public static int getAmountHadBought(String username, String productName, String limitTime){
        String id = getUserId(username);
        String time = getTime(limitTime);
        Connection conn = null;
        ResultSet rs = null;
        int sum = 0;
        
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String tmp = "'"+ id + "'";
            String rq = "'"+ time + "'";
            String req = "select * from Bill where billDate >= " + rq + " and userId =" + tmp;
            
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            
           while(result.next()){
               
              String list[] = result.getString("necessities").split(", ");
                for (int i = 0; i<list.length;i++) {
                    if (list[i] == null ? productName == null : list[i].equals(productName)) {
                        String amount[] = result.getString("amount").split(", ");
                        sum+=Integer.valueOf(amount[i]);
                        break;
                    }
                }
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
       return sum; 
        
    }
    public static int getLimitNecess(String id){
        
        Connection conn = null;
        ResultSet rs = null;
        int stock = 0;
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String tmp = "'"+ id + "'";
            String req = "select * from Necessities where id =" + tmp;
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            
           while(result.next()){
               
              stock = result.getInt("limitNecess");
              
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
            String req = "select * from Necessities where id =" + tmp;
            
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
                if(checkStock(a[i][0],a[i][2],username) == false){
                    return false;
                } 
        }
        int total = 0;
        for(int i = 0 ;i < row ; i++){ 
            
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
    public static boolean checkInt(String a){
        try{
            int tmp = Integer.parseInt(a);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    public static boolean checkNecessitiesId(String i){
        Connection conn = null;
        ResultSet rs = null;
        boolean id = false;
        String tmp = "";
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            tmp = "'" + i + "'";
            String req = "select * from Necessities where id = " + tmp;
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(req);
            
           while(result.next()){ 
              id = true;
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
    public static boolean updateNecessities(String oldid , String id, String name, int limit, String limitDate, int price ){
        Connection conn = null;
        ResultSet rs = null;
       
        String tmp = "";
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String sqlUpdate = "UPDATE Necessities "
                + "SET id = ? , name = ? , limitNecess = ? , limitDate = ? , cost = ? "
                + "WHERE id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, limit);
            pstmt.setString(4, limitDate);
            pstmt.setInt(5, price);
            pstmt.setString(6, oldid);
            System.out.println(pstmt);
            int rowAffected = pstmt.executeUpdate();
            
           if(rowAffected == 1){
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
       return false; 
    }
    public static boolean addNecessities(String id, String name, int limit, String limitDate, int price ){
        Connection conn = null;
        ResultSet rs = null;
        
        String tmp = "";
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String sql = "INSERT INTO Necessities(id,name,limitNecess,limitDate,cost) "
            + "VALUES(?,?,?,?,?)";;

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, limit);
            pstmt.setString(4, limitDate);
            pstmt.setInt(5, price);
            
            int rowAffected = pstmt.executeUpdate();
            
           if(rowAffected == 1){
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
       return false; 
    }
    public static boolean deleteNecessities(String id ){
        Connection conn = null;
        ResultSet rs = null;
        
        String tmp = "";
        try {  
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            String sql = "DELETE FROM Necessities WHERE id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            
            int rowAffected = pstmt.executeUpdate();
            
           if(rowAffected == 1){
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
       return false; 
    }
}
