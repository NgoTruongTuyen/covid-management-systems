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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author zerotus
 */
public class PaymentService {
    static String DB_URL = "jdbc:mysql://ba789yyeviyfpuqmprn9-mysql.services.clever-cloud.com/ba789yyeviyfpuqmprn9";
    static String USER = "uuaeqsyvhif6hnzh";
    static String PASS = "87pjEZXsG2Wgsu5eDQNB";
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    String username = null;
    
    public PaymentAccount loadAccount(String id) {
        String sqlSelect = "select * from PaymentAccount where id = ?";
        int nums;
        PaymentAccount account = new PaymentAccount(id);
        try{
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
                       
            while (rs.next()) {
                int balance = rs.getInt("balance");
                account.setBalance(balance);
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Could not be read!");
        }
        
        return account;
    }
    
    public int pay(String id, int money) {
        String sqlUpdate = "update PaymentAccount set balance = ? where id = ?";
        int result = 0;
        
        PaymentAccount account = loadAccount(id);
        account.pay(money);
        
        try {
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            pstmt = conn.prepareStatement(sqlUpdate);
            pstmt.setInt(1, account.getBalance());
            pstmt.setString(2, account.getId());
            
            
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
    
    public List<PaymentAccount> findAllPaymentAccount() {
        List<PaymentAccount> accounts = new ArrayList<PaymentAccount>();
        
        String sqlSelect = "select * from PaymentAccount";
        int nums, count = 1;
        try{
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            pstmt = conn.prepareStatement(sqlSelect);
            rs = pstmt.executeQuery();
            
            ResultSetMetaData stData = rs.getMetaData();
            
            nums = stData.getColumnCount();
            
            while (rs.next()) {
                String id = rs.getString("id");
                int balance = rs.getInt("balance");
                
                PaymentAccount account = new PaymentAccount(id, balance);
                
                accounts.add(account);
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Could not be read!");
        }
        
        return accounts;
    }
    
//    public static void main(String args[]) {
//        PaymentService payment = new PaymentService();
//        
//        int result = payment.pay("1029312", 50000);
//        if (result != 0) {
//            System.out.println("Successful!");
//        }
//    }
}
