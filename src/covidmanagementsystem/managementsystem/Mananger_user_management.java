/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidmanagementsystem.managementsystem;

import java.awt.Component;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 123
 */
public class Mananger_user_management extends javax.swing.JFrame {

    List<User> UserList = new ArrayList<>();
    List<String> TreatmentSiteNameList = new ArrayList<>();
    List<TreatmentSite> TreatmentSiteList = new ArrayList<>();
    List<String> CityList = new ArrayList<>();
    String currentStatus = "";
    String currentTreatmentSite = "";
    String currentContactList = "";
    String managerId;

    /**
     * Creates new form Manager_user_management
     */
    public Mananger_user_management() {
        initComponents();
        updateDB();
    }

    public void updateDB() {
        try {

            UserList = UserModify.findAll();
            TreatmentSiteNameList = TreatmentSiteModify.findAllTreatmentSiteName();
            TreatmentSiteList = TreatmentSiteModify.findAll();
            CityList = AddressModify.findAllCity();

            DefaultTableModel recordTable = (DefaultTableModel) TableModel.getModel();
            recordTable.setRowCount(0);

            UserList.forEach((user) -> {
                String status = "Đã hồi phục";
                if (user.getState() != -1) {
                    status = "F" + user.getState();
                }
                recordTable.addRow(new Object[]{user.getID(), user.getName(), user.getDOB(), user.getAddress(), status, user.getTreatmentSiteName(), user.getRelated()});
            });

            jComboBoxTreatmentSiteInput.removeAllItems();
            TreatmentSiteNameList.forEach((siteName) -> {
                jComboBoxTreatmentSiteInput.addItem(siteName);
            });

            jComboBoxCityInput.removeAllItems();
            CityList.forEach((cityName) -> {
                jComboBoxCityInput.addItem(cityName);
            });

            jComboBoxDistrictInput.setEnabled(false);
            jComboBoxVillageInput.setEnabled(false);
            idInputTxt.setEditable(false);
//            jComboBoxTreatmentSiteInput.setSelectedItem(TreatmentSiteNameList);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void checkCapacity(String siteName) {
        for (TreatmentSite site : TreatmentSiteList) {
            if (site.getName().equals(siteName)) {
                if ((site.getCurrentNumber() + 1) > site.getCapacity()) {
                    JOptionPane.showMessageDialog(new JFrame(), "This treatment site is full of user!!");
                }
            }
        }
    }

    public boolean checkId(String id) {
        for (User user : UserList) {
            if (user.getID().equals(id)) {
                JOptionPane.showMessageDialog(new JFrame(), "This ID card has already exist!!");
                return false;
            }

        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        fullNameInputTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        contactInputTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxTreatmentSiteInput = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        idInputTxt = new javax.swing.JTextField();
        jComboBoxVillageInput = new javax.swing.JComboBox<>();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jComboBoxCityInput = new javax.swing.JComboBox<>();
        jComboBoxDistrictInput = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dobInputTxt1 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableModel = new javax.swing.JTable();
        searchButton = new javax.swing.JButton();
        viewContactButton = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Covid Management System");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 700, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 1540, 90));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Full name");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 30));

        fullNameInputTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fullNameInputTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullNameInputTxtActionPerformed(evt);
            }
        });
        jPanel6.add(fullNameInputTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 240, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Covid contact");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, 30));

        contactInputTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        contactInputTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactInputTxtActionPerformed(evt);
            }
        });
        jPanel6.add(contactInputTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 230, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Status");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Village");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Treatment place");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 160, 30));

        jComboBoxTreatmentSiteInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxTreatmentSiteInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTreatmentSiteInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTreatmentSiteInputActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBoxTreatmentSiteInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 380, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("ID");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 30));

        idInputTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        idInputTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idInputTxtActionPerformed(evt);
            }
        });
        jPanel6.add(idInputTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 240, -1));

        jComboBoxVillageInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxVillageInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F0", "F1", "F2" }));
        jComboBoxVillageInput.setToolTipText("");
        jPanel6.add(jComboBoxVillageInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 230, -1));

        jComboBoxStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F0", "F1", "F2", "Đã hồi phục" }));
        jComboBoxStatus.setToolTipText("");
        jPanel6.add(jComboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        jComboBoxCityInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxCityInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F0", "F1", "F2" }));
        jComboBoxCityInput.setToolTipText("");
        jComboBoxCityInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCityInputActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBoxCityInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 230, -1));

        jComboBoxDistrictInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxDistrictInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F0", "F1", "F2" }));
        jComboBoxDistrictInput.setToolTipText("");
        jComboBoxDistrictInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDistrictInputActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBoxDistrictInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 230, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Address");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("City");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("District");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Date of birth");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 30));

        dobInputTxt1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dobInputTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobInputTxt1ActionPerformed(evt);
            }
        });
        jPanel6.add(dobInputTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 240, -1));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 410, 490));

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableModel.setAutoCreateRowSorter(true);
        TableModel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TableModel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Full Name", "Date of birth", "Address", "Status", "Treatement place", "Contact"
            }
        ));
        TableModel.setDoubleBuffered(true);
        TableModel.setDragEnabled(true);
        TableModel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableModelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableModel);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 63, 1050, 410));

        searchButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel10.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 110, 30));

        viewContactButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewContactButton.setText("View contact list and history");
        viewContactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewContactButtonActionPerformed(evt);
            }
        });
        jPanel10.add(viewContactButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 310, 30));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 1070, 490));

        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel11.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 220, 40));

        refreshButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        jPanel11.add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 220, 40));

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel11.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 220, 40));

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel11.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 220, 40));

        backButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel11.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 10, 220, 40));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 1510, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 157, 1570, 610));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("User management");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 11, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 95, 380, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fullNameInputTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullNameInputTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullNameInputTxtActionPerformed

    private void contactInputTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactInputTxtActionPerformed

    }//GEN-LAST:event_contactInputTxtActionPerformed

    private void idInputTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idInputTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idInputTxtActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String Id = idInputTxt.getText();
        String fullname = fullNameInputTxt.getText();
        String dob = dobInputTxt1.getText();
        String address = (String) jComboBoxVillageInput.getSelectedItem() + "," + (String) jComboBoxDistrictInput.getSelectedItem() + "," + (String) jComboBoxCityInput.getSelectedItem();
        String strStatus = (String) jComboBoxStatus.getSelectedItem();
        int status = -1;
        if (!strStatus.equals("Đã hồi phục")) {
            status = Integer.parseInt(strStatus.substring(strStatus.length() - 1));
        }
        String treatmentSite = (String) jComboBoxTreatmentSiteInput.getSelectedItem();
        String related = (String) contactInputTxt.getText();
        User newUser = new User(Id, fullname, dob, address, status, treatmentSite, related);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        
        ManagerModify managerModify = new ManagerModify();
        LocalDateTime localDateTime;
        String currentDateTime;
        String content;
//        System.out.println(dateFormat.format(date));
        if (!currentStatus.equals(strStatus)) {
            ManagementHistory newRecord1 = new ManagementHistory(Id, "Cập nhật : Từ" + currentStatus + "trở thành " + strStatus, dateFormat.format(date));
            ManagementHistoryModify.insert(newRecord1);
            
            localDateTime = LocalDateTime.now();
            currentDateTime = managerModify.formatDateTime(localDateTime);
            content = currentDateTime + ": " + Id + " - update state from " + currentStatus + "to " + strStatus;
            managerModify.saveHistory(managerId, content);
        }
        if (!currentTreatmentSite.equals(treatmentSite)) {
            ManagementHistory newRecord2 = new ManagementHistory(Id, "Chuyển từ khu cách ly " + currentTreatmentSite + " sang " + treatmentSite, dateFormat.format(date));
            ManagementHistoryModify.insert(newRecord2);
            
            localDateTime = LocalDateTime.now();
            currentDateTime = managerModify.formatDateTime(localDateTime);
            content = currentDateTime + ": " + Id + " - move treatmentsite from " + currentTreatmentSite + "to " + treatmentSite;
            managerModify.saveHistory(managerId, content);

        }
        if (!currentContactList.equals(related)) {
            ManagementHistory newRecord3 = new ManagementHistory(Id, "Cập nhật danh sách tiếp xúc: " + related, dateFormat.format(date));
            ManagementHistoryModify.insert(newRecord3);
            
            localDateTime = LocalDateTime.now();
            currentDateTime = managerModify.formatDateTime(localDateTime);
            content = currentDateTime + ": " + Id + " - update related person " + related;
            managerModify.saveHistory(managerId, content);
        }

        UserModify.update(newUser);
        updateDB();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String input = JOptionPane.showInputDialog(this, "Enter full name to search");
        if (input != null && input.length() > 0) {
            UserList = UserModify.findByFullname(input);

            DefaultTableModel recordTable = (DefaultTableModel) TableModel.getModel();
            recordTable.setRowCount(0);

            UserList.forEach((user) -> {
                recordTable.addRow(new Object[]{user.getID(), user.getName(), user.getDOB(), user.getAddress(), "F" + user.getState(), user.getTreatmentSiteName(), user.getRelated()});
            });
        } else {
            updateDB();
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void viewContactButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewContactButtonActionPerformed
        Manger_contact_list_and_treament_history contectManagement = new Manger_contact_list_and_treament_history();
        contectManagement.setVisible(true);
    }//GEN-LAST:event_viewContactButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = TableModel.getSelectedRow();
        if (selectedIndex >= 0) {
            User std = UserList.get(selectedIndex);

            int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this item?");
            System.out.println("option : " + option);

            if (option == 0) {
                UserModify.delete(std.getID());
                updateDB();
                
                ManagerModify managerModify = new ManagerModify();
                LocalDateTime localDateTime = LocalDateTime.now();
                String currentDateTime = managerModify.formatDateTime(localDateTime);
                String content = currentDateTime + ": delete user - " + std.getID();
                managerModify.saveHistory(managerId, content);
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jComboBoxDistrictInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDistrictInputActionPerformed
        jComboBoxVillageInput.setEnabled(true);
        String districtName = (String) jComboBoxDistrictInput.getSelectedItem();

        List<String> villageList = new ArrayList<>();
        villageList = AddressModify.findAllVillage(districtName);
        jComboBoxVillageInput.removeAllItems();
        villageList.forEach((villageName) -> {
            jComboBoxVillageInput.addItem(villageName);
        });
    }//GEN-LAST:event_jComboBoxDistrictInputActionPerformed

    private void jComboBoxCityInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCityInputActionPerformed
//        System.out.println((String)jComboBoxCityInput.getSelectedItem());
        jComboBoxDistrictInput.setEnabled(true);
        String cityName = (String) jComboBoxCityInput.getSelectedItem();

        List<String> districtList = new ArrayList<>();
        districtList = AddressModify.findAllDistrict(cityName);
//           System.out.println(districtList);
        jComboBoxDistrictInput.removeAllItems();
        districtList.forEach((districtName) -> {
            jComboBoxDistrictInput.addItem(districtName);
        });
    }//GEN-LAST:event_jComboBoxCityInputActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String Id = idInputTxt.getText();
        boolean isValiad = checkId(Id);
        if (isValiad) {
            String fullname = fullNameInputTxt.getText();
            String dob = dobInputTxt1.getText();
            String address = (String) jComboBoxVillageInput.getSelectedItem() + "," + (String) jComboBoxDistrictInput.getSelectedItem() + "," + (String) jComboBoxCityInput.getSelectedItem();
            String strStatus = (String) jComboBoxStatus.getSelectedItem();

            int status = -1;
            if (!strStatus.equals("Đã hồi phục")) {
                status = Integer.parseInt(strStatus.substring(strStatus.length() - 1));
            }

            String treatmentSite = (String) jComboBoxTreatmentSiteInput.getSelectedItem();
            checkCapacity(treatmentSite);

            String related = (String) contactInputTxt.getText();
            User newUser = new User(Id, fullname, dob, address, status, treatmentSite, related);

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
//        System.out.println(dateFormat.format(date));

            ManagementHistory newRecord1 = new ManagementHistory(Id, "Trở thành " + strStatus, dateFormat.format(date));
            ManagementHistory newRecord2 = new ManagementHistory(Id, "Được đưa vào khu cách ly " + treatmentSite, dateFormat.format(date));
            ManagementHistory newRecord3 = new ManagementHistory(Id, "Danh sách tiếp xúc: " + related, dateFormat.format(date));

            ManagementHistoryModify.insert(newRecord1);
            ManagementHistoryModify.insert(newRecord2);
            ManagementHistoryModify.insert(newRecord3);

            UserModify.insert(newUser);
            updateDB();
            
            ManagerModify managerModify = new ManagerModify();
            LocalDateTime localDateTime = LocalDateTime.now();
            String currentDateTime = managerModify.formatDateTime(localDateTime);
            String content = currentDateTime + ": add new user - " + Id;
            managerModify.saveHistory(managerId, content);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void TableModelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableModelMouseClicked

        DefaultTableModel recordTable = (DefaultTableModel) TableModel.getModel();
        int selectedRows = TableModel.getSelectedRow();

        currentStatus = new String(recordTable.getValueAt(selectedRows, 4).toString());
        currentTreatmentSite = new String(recordTable.getValueAt(selectedRows, 5).toString());

        idInputTxt.setText(recordTable.getValueAt(selectedRows, 0).toString());

        fullNameInputTxt.setText(recordTable.getValueAt(selectedRows, 1).toString());
        dobInputTxt1.setText(recordTable.getValueAt(selectedRows, 2).toString());

        String[] address = recordTable.getValueAt(selectedRows, 3).toString().split(",");
        System.out.println(address);
        jComboBoxCityInput.setSelectedItem(address[2]);
        jComboBoxDistrictInput.setSelectedItem(address[1]);
        jComboBoxVillageInput.setSelectedItem(address[0]);
        jComboBoxStatus.setSelectedItem(recordTable.getValueAt(selectedRows, 4).toString());
        jComboBoxTreatmentSiteInput.setSelectedItem(recordTable.getValueAt(selectedRows, 5).toString());
        if (recordTable.getValueAt(selectedRows, 6) != null) {
            currentContactList = new String(recordTable.getValueAt(selectedRows, 6).toString());
            contactInputTxt.setText(recordTable.getValueAt(selectedRows, 6).toString());
        } else {
            contactInputTxt.setText("");
        }

    }//GEN-LAST:event_TableModelMouseClicked

    private void dobInputTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobInputTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobInputTxt1ActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed

        idInputTxt.setText("");
        idInputTxt.setEditable(true);
        fullNameInputTxt.setText("");
        dobInputTxt1.setText("");

//        searchIdtxt.setText("");
        contactInputTxt.setText("");

//        DefaultTableModel RecordTable = (DefaultTableModel) TableModel.getModel();
//        RecordTable.setRowCount(0);

    }//GEN-LAST:event_refreshButtonActionPerformed

    private void jComboBoxTreatmentSiteInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTreatmentSiteInputActionPerformed


    }//GEN-LAST:event_jComboBoxTreatmentSiteInputActionPerformed

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
            java.util.logging.Logger.getLogger(Mananger_user_management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mananger_user_management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mananger_user_management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mananger_user_management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mananger_user_management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableModel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField contactInputTxt;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField dobInputTxt1;
    private javax.swing.JTextField fullNameInputTxt;
    private javax.swing.JTextField idInputTxt;
    private javax.swing.JComboBox<String> jComboBoxCityInput;
    private javax.swing.JComboBox<String> jComboBoxDistrictInput;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JComboBox<String> jComboBoxTreatmentSiteInput;
    private javax.swing.JComboBox<String> jComboBoxVillageInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton viewContactButton;
    // End of variables declaration//GEN-END:variables
}
