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
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zerotus
 */
public class ManagerList extends javax.swing.JFrame {
    static String DB_URL = "jdbc:mysql://localhost:3306/ba789yyeviyfpuqmprn9";
    static String USER = "root";
    static String PASS = "zerotus";
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    /**
     * Creates new form ManagerList
     */
    public ManagerList() {
        initComponents();
        loadData();
    }
    
    void loadData() {
        ManagerModify managerListModify = new ManagerModify();
        List<Manager> managers = managerListModify.findAllManagers();
        
  
        int nums = managers.size();
        int col = 4;
        int count = 1;
        DefaultTableModel recordTable = (DefaultTableModel) tblManager.getModel();
        recordTable.setRowCount(0);
        

        for (int i = 0; i < nums; i++) {
            Vector columnData = new Vector();
            
            for (int j = 0; j < col; j++) {
                Manager manager = managers.get(i);
           
                columnData.add(count);

                columnData.add(manager.getUsername());
                columnData.add("manager");
                int state = manager.getStatus();
                if (state == 0) {
                    columnData.add("locked");
                } else {
                    columnData.add("normal");
                }
            }

            count++;
            recordTable.addRow(columnData);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnBlock = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblManager = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnAdd = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtSearchUsername = new javax.swing.JTextField();
        btnViewActivities = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnUnblock = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Covid Management Systems");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1520, 90));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBlock.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnBlock.setText("Block");
        btnBlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlockActionPerformed(evt);
            }
        });
        jPanel3.add(btnBlock, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 210, 60));

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblManager.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblManager.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Username", "Role", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblManager);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 850, 440));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 870, 460));

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Role");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 140, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Password");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 140, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Username");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 140, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("1: Manager");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 260, 40));

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel6.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 260, 40));

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel6.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 150, 50));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Add a manager");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 140, 40));

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel6.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 260, 40));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 590, 290));

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Username");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 140, 40));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel7.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 50));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Search a manager");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 180, 40));

        txtSearchUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(txtSearchUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 260, 40));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 590, 150));

        btnViewActivities.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnViewActivities.setText("View activities");
        btnViewActivities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActivitiesActionPerformed(evt);
            }
        });
        jPanel3.add(btnViewActivities, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 520, 210, 60));

        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel3.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 210, 60));

        btnUnblock.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnUnblock.setText("Unblock");
        btnUnblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnblockActionPerformed(evt);
            }
        });
        jPanel3.add(btnUnblock, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, 210, 60));

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel3.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 520, 210, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1520, 610));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Admin - Manager List");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlockActionPerformed
        DefaultTableModel recordTable = (DefaultTableModel)tblManager.getModel();
        int selectedRows = tblManager.getSelectedRow();
        
        String username = recordTable.getValueAt(selectedRows, 1).toString();
        ManagerModify managerListModify = new ManagerModify();
        
        int result = managerListModify.lockManager(username);
        
        if (result == 0) {
            JOptionPane.showMessageDialog(this, "There was a problem. Please try again later.");
        } else {
            loadData();
            JOptionPane.showMessageDialog(this, "Lock account successfully!");  
        }
        
    }//GEN-LAST:event_btnBlockActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        ManagerModify managerListModify = new ManagerModify();
        Manager manager = managerListModify.findManager(txtSearchUsername.getText());
        
        if (manager.getUsername() == null) {
            JOptionPane.showMessageDialog(this, "Username does not exist!");
            this.btnRefreshActionPerformed(evt);
        } else {
            DefaultTableModel recordTable = (DefaultTableModel) tblManager.getModel();
            recordTable.setRowCount(0);
            int col = 4;
        
            Vector columnData = new Vector();

            for (int j = 0; j < col; j++) {
                columnData.add(1);

                columnData.add(manager.getUsername());
                columnData.add("manager");
                int state = manager.getStatus();
                if (state == 0) {
                    columnData.add("locked");
                } else {
                    columnData.add("normal");
                }
            }

            recordTable.addRow(columnData);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnViewActivitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActivitiesActionPerformed
        DefaultTableModel recordTable = (DefaultTableModel)tblManager.getModel();
        int selectedRows = tblManager.getSelectedRow();
        
        String username = recordTable.getValueAt(selectedRows, 1).toString();
        
        ManagerActivities activities = new ManagerActivities();
        activities.managerId = username;
        activities.loadActivities();
        
        this.hide();
        activities.setVisible(true);
    }//GEN-LAST:event_btnViewActivitiesActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        DefaultTableModel recordTable = (DefaultTableModel) tblManager.getModel();
        recordTable.setRowCount(0);
        txtSearchUsername.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        
        loadData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        int role = 2, state = 1;
        Manager manager = new Manager(username, role, state);
        
        ManagerModify managerListModify = new ManagerModify();
        
        int result = managerListModify.addManager(manager, password);
        
        if (result != 0){
            JOptionPane.showMessageDialog(this, "Add new account successfully!");
            loadData();
        } else {
            JOptionPane.showMessageDialog(this, "Username have existed! Please enter a different username");
            txtUsername.setText("");
            txtPassword.setText("");
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUnblockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnblockActionPerformed
        DefaultTableModel recordTable = (DefaultTableModel)tblManager.getModel();
        int selectedRows = tblManager.getSelectedRow();
        
        String username = recordTable.getValueAt(selectedRows, 1).toString();
        ManagerModify managerListModify = new ManagerModify();
        
        int result = managerListModify.unlockManager(username);
        
        if (result == 0) {
            JOptionPane.showMessageDialog(this, "There was a problem. Please try again later.");
        } else {
            loadData();
            JOptionPane.showMessageDialog(this, "Unlock account successfully!");  
        }
        
    }//GEN-LAST:event_btnUnblockActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Admin_menu admin = new Admin_menu();
        this.hide();
        
        admin.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBlock;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUnblock;
    private javax.swing.JButton btnViewActivities;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblManager;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSearchUsername;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
