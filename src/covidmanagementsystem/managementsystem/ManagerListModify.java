/*
 *  Student's ID: 19127622
 *  Full name: Ngo Truong Tuyen
 *  Subject: Java Programming
 *  Assignment :
 *  Problem :
 */
package covidmanagementsystem.managementsystem;

import static covidmanagementsystem.managementsystem.ManagerList.DB_URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author zerotus
 */
public class ManagerListModify {
    static String DB_URL = "jdbc:mysql://ba789yyeviyfpuqmprn9-mysql.services.clever-cloud.com/ba789yyeviyfpuqmprn9";
    static String USER = "uuaeqsyvhif6hnzh";
    static String PASS = "87pjEZXsG2Wgsu5eDQNB";
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    public List<Manager> findAllManagers() {
        List<Manager> managers = new ArrayList<Manager>();
        
        String sqlSelect = "select * from Account where role = 2";
        int nums, count = 1;
        try{
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            pstmt = conn.prepareStatement(sqlSelect);
            rs = pstmt.executeQuery();
            
            ResultSetMetaData stData = rs.getMetaData();
            
            nums = stData.getColumnCount();
            
            while (rs.next()) {
                String username = rs.getString("username");
                int role = 2;
                int state = rs.getInt("state");
                Manager manager = new Manager(username, role, state);
                
                managers.add(manager);
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Could not be read!");
        }
        
        return managers;
    }
    
    Boolean existedUsername(String username) {
         String sqlSelect = "select * from Account where username = ?";
        
        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setString(1, username);
            
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

    public Manager findManager(String username) {
        Manager manager = new Manager();
        
        String sqlSelect = "select * from Account where username = ?";
        int nums;
        try{
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            boolean found = false;
            
            
            while (rs.next()) {
                found = true;
                int role = 2;
                int state = rs.getInt("state");
                manager.setUsername(username);
                manager.setRole(role);
                manager.setStatus(state);
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Could not be read!");
        }
        
        return manager;
    }
    
    public int addManager(Manager manager, String password) {
        int result = 0;
        if (!existedUsername(manager.getUsername())) {
            String sqlInsert = "insert into Account(username, password, role, state) values (?, ?, ?, ?)";
            SimpleMD5 md5 = new SimpleMD5();

            try {
                conn = DriverManager.getConnection(DB_URL,USER, PASS);
                pstmt = conn.prepareStatement(sqlInsert);
                pstmt.setString(1, manager.getUsername());
                String passwordHash = md5.hashPassword(password);
                pstmt.setString(2, passwordHash);
                pstmt.setInt(3, manager.getRole());
                pstmt.setInt(4, manager.getStatus());

                result = pstmt.executeUpdate();
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
        }
        
        return result;
    }

    public int lockManager(String username) {
        int result = 0;
            
        String sqlUpdate = "update Account set state = ? where username = ?";

        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            pstmt = conn.prepareStatement(sqlUpdate);
            pstmt.setInt(1, 0);
            pstmt.setString(2, username);

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
    
    public int unlockManager(String username) {
        int result = 0;
            
        String sqlUpdate = "update Account set state = ? where username = ?";

        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            pstmt = conn.prepareStatement(sqlUpdate);
            pstmt.setInt(1, 1);
            pstmt.setString(2, username);

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
