/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package covidmanagementsystem.managementsystem;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author MTBH
 */
public class UserNecessities extends javax.swing.JFrame {

    /**
     * Creates new form UserNecessities
     */
    String username;
    int rowCart = 0;
    String pName = "";
    public UserNecessities(String name) {
        this.username = name;
        initComponents();
        loadComboSort();
        loadComboPrice();
        loadComboLimitDate();
        viewNecessities();
        designCart();
    }
    public UserNecessities() {
        initComponents();
        loadComboSort();
        loadComboPrice();
        loadComboLimitDate();
        
        viewNecessities();
        
        designCart();
    }

    
    private void loadComboSort(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("...");
        model.addElement("A to Z");
        model.addElement("Z to A");
        model.addElement("Smaller to Larger");
        model.addElement("Larger to Smaller");
        jcbSort.setModel(model);
        
    }
    private void loadComboPrice(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("...");
        model.addElement("< 100000");
        model.addElement("100000 to 500000");
        model.addElement("> 500000");
        jcbPrice.setModel(model);
        
    }
    private void loadComboLimitDate(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("...");
        model.addElement("< 10");
        model.addElement("10 to 40");
        model.addElement("> 40");
        jcbStock.setModel(model);
        
    }
    private void designCart(){
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            jtCart.setDefaultRenderer(Object.class, centerRenderer);

            TableCellRenderer rendererFromHeader = jtCart.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) rendererFromHeader;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
    }
    private void doNecessities(List<Necessities> a){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jtNeccessitiesList.setDefaultRenderer(Object.class, centerRenderer);
        
        TableCellRenderer rendererFromHeader = jtNeccessitiesList.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        DefaultTableModel table = (DefaultTableModel) jtNeccessitiesList.getModel();
        table.setRowCount(0);
        
        for(Necessities temp : a){
            table.addRow(new Object[]{temp.getID(),temp.getName(),temp.getLimit(),temp.getLimitTime(),temp.getPrice()});
        }
    }
    private void viewNecessities(){
        List<Necessities> a = NecessitiesModify.viewNecessities();
        doNecessities(a);
    }
    private String[][] getTableData(){
    
    int nRow = jtCart.getRowCount(), nCol = jtCart.getColumnCount();
    String[][] tableData = new String[nRow][nCol];
    for (int i = 0 ; i < nRow ; i++)
        for (int j = 0 ; j < nCol ; j++)
            tableData[i][j] = jtCart.getValueAt(i,j).toString();
    return tableData;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtfAmount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbAdd = new javax.swing.JButton();
        jtfProductName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jbSearch = new javax.swing.JButton();
        jbSort = new javax.swing.JButton();
        jtfSearch = new javax.swing.JTextField();
        jcbSort = new javax.swing.JComboBox<>();
        jbFilter = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbPrice = new javax.swing.JComboBox<>();
        jcbStock = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtNeccessitiesList = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtCart = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jbInformation = new javax.swing.JButton();
        jbRefresh = new javax.swing.JButton();
        jbBuy = new javax.swing.JButton();
        jbDelete = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Covid Management Systems");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1520, 90));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("User - Necessities");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("ID");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 110, 40));

        jtfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIDActionPerformed(evt);
            }
        });
        jPanel5.add(jtfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 440, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Amount");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 40));
        jPanel5.add(jtfAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 440, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel4.setText("Necessities");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 12, 290, 33));

        jbAdd.setText("Add");
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });
        jPanel5.add(jbAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 122, 43));

        jtfProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfProductNameActionPerformed(evt);
            }
        });
        jPanel5.add(jtfProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 440, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Name");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 110, 40));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 630, 250));

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel3.setText("Necessities List");

        jbSearch.setText("Search");
        jbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchActionPerformed(evt);
            }
        });

        jbSort.setText("Sort");
        jbSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSortActionPerformed(evt);
            }
        });

        jcbSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbFilter.setText("Filter");
        jbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFilterActionPerformed(evt);
            }
        });

        jLabel5.setText("Price");

        jLabel6.setText("Limit per person");

        jcbPrice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbStock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtNeccessitiesList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Limit per person", "Limit date", "Price"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }
    );
    jtNeccessitiesList.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jtNeccessitiesListMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(jtNeccessitiesList);

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(235, 235, 235))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jbSearch)
                        .addComponent(jbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfSearch)
                        .addComponent(jcbSort, 0, 311, Short.MAX_VALUE))
                    .addGap(55, 55, 55)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jbFilter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jcbPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbStock, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2)))
            .addContainerGap())
    );
    jPanel7Layout.setVerticalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20, 20, 20)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbSearch)
                .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbFilter))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jcbPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jcbStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSort)
                    .addComponent(jcbSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(25, 25, 25)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 850, 520));

    jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

    jLabel7.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
    jLabel7.setText("Cart");

    jtCart.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Id", "Name", "Amount"
        }
    )
    {
        public boolean isCellEditable(int row, int column){
            return false;
        }
    }
    );
    jScrollPane3.setViewportView(jtCart);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(257, 257, 257))
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addGap(198, 198, 198)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(17, Short.MAX_VALUE))
    );

    jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 630, 260));

    jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jbInformation.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jbInformation.setText("Back");
    jbInformation.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jbInformationActionPerformed(evt);
        }
    });
    jPanel8.add(jbInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 160, 40));

    jbRefresh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jbRefresh.setText("Refresh");
    jbRefresh.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jbRefreshActionPerformed(evt);
        }
    });
    jPanel8.add(jbRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 150, 40));

    jbBuy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jbBuy.setText("Buy");
    jbBuy.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jbBuyActionPerformed(evt);
        }
    });
    jPanel8.add(jbBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 150, 40));

    jbDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jbDelete.setText("Delete");
    jbDelete.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jbDeleteActionPerformed(evt);
        }
    });
    jPanel8.add(jbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 150, 40));

    jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 1490, 60));

    jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1520, 610));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIDActionPerformed

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed
        String pname = jtfSearch.getText();
        if(pname.length() == 0) {
           JOptionPane.showMessageDialog(this, " You have to fill search text field"); 
        }
        else{
        List<Necessities> a = NecessitiesModify.searchNecessities(pname);
        doNecessities(a);
        }
    }//GEN-LAST:event_jbSearchActionPerformed

    private void jbInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInformationActionPerformed
        UserInfo connectInfo = new UserInfo(username);
        connectInfo.setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_jbInformationActionPerformed

    private void jtfProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfProductNameActionPerformed

    private void jbSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSortActionPerformed
        String rq = jcbSort.getSelectedItem().toString();
        if("A to Z".equals(rq)){
            List<Necessities> a = NecessitiesModify.sortNecessitiesAZ();
            doNecessities(a);
        }
        if("Z to A".equals(rq)){
            List<Necessities> a = NecessitiesModify.sortNecessitiesZA();
            doNecessities(a);
        }
        if("Smaller to Larger".equals(rq)){
            List<Necessities> a = NecessitiesModify.sortNecessitiesSmallToLarge();
            doNecessities(a);
        }
        if("Larger to Smaller".equals(rq)){
            List<Necessities> a = NecessitiesModify.sortNecessitiesLargeToSmall();
            doNecessities(a);
        }
    }//GEN-LAST:event_jbSortActionPerformed

    private void jbRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRefreshActionPerformed
        viewNecessities();
    }//GEN-LAST:event_jbRefreshActionPerformed

    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed
        String id = jtfID.getText();
        String name = jtfProductName.getText();
        String amount = jtfAmount.getText();
        if(id.length() == 0 || name.length() == 0 || amount.length() == 0 || NecessitiesModify.checkInt(amount) == false || NecessitiesModify.checkNecessitiesId(id) == false){
             JOptionPane.showMessageDialog(this, "Wrong information");
        }
        else{
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            jtCart.setDefaultRenderer(Object.class, centerRenderer);

            TableCellRenderer rendererFromHeader = jtCart.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) rendererFromHeader;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);

            DefaultTableModel table = (DefaultTableModel) jtCart.getModel();
            table.setRowCount(rowCart);
            rowCart++;
            table.addRow(new Object[]{id,name,amount});
        
        }
    }//GEN-LAST:event_jbAddActionPerformed
  
    private void jbBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuyActionPerformed
       String[][] a = getTableData();
       
       if(NecessitiesModify.buyNecessities(a, jtCart.getRowCount(), username)== false){
           JOptionPane.showMessageDialog(this, "Fail to buy necessities");
       }
       else{
           JOptionPane.showMessageDialog(this, "Buy necessities successfully");
           DefaultTableModel table = (DefaultTableModel) jtCart.getModel();
           table.setRowCount(0);
           rowCart = 0;
       }
    }//GEN-LAST:event_jbBuyActionPerformed

    private void jbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFilterActionPerformed
        String price = jcbPrice.getSelectedItem().toString();
        String stock = jcbStock.getSelectedItem().toString();
         List<Necessities> a = NecessitiesModify.filterNecessities(price,stock);
         doNecessities(a);
    }//GEN-LAST:event_jbFilterActionPerformed

    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
       int[] selectedRows = jtCart.getSelectedRows();
       DefaultTableModel table = (DefaultTableModel) jtCart.getModel();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                table.removeRow(selectedRows[i]);
                rowCart--;
            }
        } 
    }//GEN-LAST:event_jbDeleteActionPerformed

    private void jtNeccessitiesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtNeccessitiesListMouseClicked
        DefaultTableModel table = (DefaultTableModel) jtNeccessitiesList.getModel();
        int selectedRow = jtNeccessitiesList.getSelectedRow();
        if(selectedRow >= 0){
        jtfID.setText(table.getValueAt(selectedRow, 0).toString());
        jtfProductName.setText(table.getValueAt(selectedRow, 1).toString());
        } 
    }//GEN-LAST:event_jtNeccessitiesListMouseClicked

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
            java.util.logging.Logger.getLogger(UserNecessities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserNecessities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserNecessities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserNecessities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new UserNecessities().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbBuy;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbFilter;
    private javax.swing.JButton jbInformation;
    private javax.swing.JButton jbRefresh;
    private javax.swing.JButton jbSearch;
    private javax.swing.JButton jbSort;
    private javax.swing.JComboBox<String> jcbPrice;
    private javax.swing.JComboBox<String> jcbSort;
    private javax.swing.JComboBox<String> jcbStock;
    private javax.swing.JTable jtCart;
    private javax.swing.JTable jtNeccessitiesList;
    private javax.swing.JTextField jtfAmount;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfProductName;
    private javax.swing.JTextField jtfSearch;
    // End of variables declaration//GEN-END:variables
}
