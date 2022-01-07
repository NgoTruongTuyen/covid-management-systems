/*
 *  Student's ID: 19127622
 *  Full name: Ngo Truong Tuyen
 *  Subject: Java Programming
 *  Assignment :
 *  Problem :
 */
package covidmanagementsystem.managementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author zerotus
 */
public class HomeScreenModify {
    static String DB_URL = "jdbc:mysql://ba789yyeviyfpuqmprn9-mysql.services.clever-cloud.com/ba789yyeviyfpuqmprn9";
    static String USER = "uuaeqsyvhif6hnzh";
    static String PASS = "87pjEZXsG2Wgsu5eDQNB";
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    
    public boolean existedAccount() {
        String sqlSelect = "select * from Account";
        int nums;
        boolean found = false;
        try{
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            pstmt = conn.prepareStatement(sqlSelect);
            rs = pstmt.executeQuery();
            
            ResultSetMetaData stData = rs.getMetaData();
            
            nums = stData.getColumnCount();
            
            while (rs.next()) {
                found = true;
                break;
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Could not be read!");
        } finally{
            try {
                conn.close();
                pstmt.close();
            } catch (SQLException e) {
            }
        }
        
        return found;
    }
    
    public int createAdminAccount() {
        int result = 0;
        String username = "admin";
        String password = "admin";
        int role = 1;
        int state = 1;
        String sqlInsert = "insert into Account(username, password, role, state) values (?, ?, ?, ?)";
        SimpleMD5 md5 = new SimpleMD5();

        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            pstmt = conn.prepareStatement(sqlInsert);
            pstmt.setString(1, username);
            String passwordHash = md5.hashPassword(password);
            pstmt.setString(2, passwordHash);
            pstmt.setInt(3, role);
            pstmt.setInt(4, state);

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
