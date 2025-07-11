/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import codes.DBconnect;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;








public class BookCatelogueCashier extends javax.swing.JFrame {
    Connection conn=null;
    PreparedStatement pst =null;
    ResultSet rs;
    
    private  DefaultTableModel model;
    /**
     * Creates new form DashBord1
     */
    public BookCatelogueCashier() {
        initComponents();
        conn=DBconnect.connect();
        customJtable();
        loadData();
        DisplayupdateSell();
        
        //----------
        
        
        
        
        
    }
    private void customJtable(){
        table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable jtable,Object o,boolean bln,boolean bln1,int row,int column){
                
            super.getTableCellRendererComponent(jtable,o, bln, bln1, row, column);
            if(column!=4){
                setHorizontalAlignment(JLabel.LEFT);
                
            }
            return this;    
            }
            
            
        });

     table.getColumnModel().getColumn(3).setCellRenderer(new  ImageRenderer());
        
    }
    
    private void loadData(){
        try{
            model= (DefaultTableModel)table.getModel();
            model.setRowCount(0);
            //----------
            String query = "SELECT ISBN_NO,title,price,Image FROM `books` WHERE category=\"Biography\"";
            pst = conn.prepareStatement(query);
            //pst.setString(1, selectedCategory);
            rs = pst.executeQuery();
            
            
            
            
           /* byte[] imageBytes;
                public ImageIcon getImage(){
                    return new ImageIcon(imageBytes);
                }*/
            //-------------
            while(rs.next()){
                String ISBN_NO=rs.getString("ISBN_NO");
                String title=rs.getString("title");
                float price=rs.getFloat("price");
                byte[] imageBytes=rs.getBytes("Image");
                
                
                
                //image next
                 model.addRow(new Object[]{ISBN_NO,title,price,imageBytes});
              //  model.addRow(new Object[]{table.getRowCount()+1,ISBN_NO,title,price,null});
               // float price = rs.getFloat("price")
                
            }
            
            
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     private void DisplayupdateSell(){
        try{
            //--
            String selectedCategory = (String) categorybox.getSelectedItem();
           
            String query = "SELECT sellNo FROM `sell` WHERE category=?";
            pst = conn.prepareStatement(query);
            pst.setString(1,selectedCategory);
            //pst.setString(1, selectedCategory);
            rs = pst.executeQuery();
            
            if(rs.next()){
            int SN = rs.getInt("sellNo");
            sell.setText(String.valueOf(SN));
            }
           // int quantity = rs.getInt("quantity");
            //sell.setText(String.valueOf(quantity));
            
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    
    
    
     //------------
      private void loadData2(){
        try{
            //--
            String selectedCategory = (String) categorybox.getSelectedItem();
            //--
            model= (DefaultTableModel)table.getModel();
            model.setRowCount(0);
            //----------
            String query = "SELECT ISBN_NO,title,price,Image FROM `books` WHERE category=?";
            pst = conn.prepareStatement(query);
            pst.setString(1,selectedCategory);
            //pst.setString(1, selectedCategory);
            rs = pst.executeQuery();
            
            
            
            
           /* byte[] imageBytes;
                public ImageIcon getImage(){
                    return new ImageIcon(imageBytes);
                }*/
            //-------------
            while(rs.next()){
                String ISBN_NO=rs.getString("ISBN_NO");
                String title=rs.getString("title");
                float price=rs.getFloat("price");
                byte[] imageBytes=rs.getBytes("Image");
                
                
                
                //image next
                 model.addRow(new Object[]{ISBN_NO,title,price,imageBytes});
              //  model.addRow(new Object[]{table.getRowCount()+1,ISBN_NO,title,price,null});
               // float price = rs.getFloat("price")
                
            }
            
            
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //-------
    
   

  
    

    
     private class ImageRenderer extends DefaultTableCellRenderer {
        //public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        public Component getTableCellRendererComponent(JTable jtable,Object o,boolean bln,boolean bln1,int row,int column) {
        byte[] imageData = (byte[]) o; // Assuming the image data is stored as byte array (BLOB)
        ImageIcon imageIcon = new ImageIcon(imageData);
        Image scaledImage = imageIcon.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        return new JLabel(new ImageIcon(scaledImage));
        }
    }
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        txtisbn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        categorybox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        sell = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Perpetua", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 255));
        jLabel4.setText("Chapters");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 200, 60));

        jPanel2.setBackground(new java.awt.Color(0, 51, 255,80));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ISBN number", "Name", "Price", "Image"
            }
        ));
        table.setRowHeight(90);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 67, 640, 400));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ISBN_NO");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 485, 80, -1));

        btnSearch.setBackground(new java.awt.Color(0, 0, 0));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel2.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 485, -1, -1));

        txtisbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtisbnActionPerformed(evt);
            }
        });
        jPanel2.add(txtisbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 485, 166, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Shelf No");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 39, 63, -1));

        categorybox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biography", "Romance", "Education", "Fiction" }));
        categorybox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryboxActionPerformed(evt);
            }
        });
        jPanel2.add(categorybox, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 39, 162, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 40, 58, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CATEGORY");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 89, -1));

        sell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellActionPerformed(evt);
            }
        });
        jPanel2.add(sell, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 39, 125, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 660, 520));

        jLabel6.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Book Shop");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 150, 60));

        jLabel1.setForeground(new java.awt.Color(0, 255, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/Blu.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void categoryboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryboxActionPerformed
        // TODO add your handling code here:
        loadData2();
        DisplayupdateSell();
        
        
        
        
    }//GEN-LAST:event_categoryboxActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
       
    }//GEN-LAST:event_tableMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
         String ISBNNO = txtisbn.getText();
         ISBN_Search n=new ISBN_Search(ISBNNO);
         n.setVisible(true); 
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtisbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtisbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtisbnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                        setVisible(false);
                        CashierDashboardLast ob1=new CashierDashboardLast();
                        //ob1.setUpLoading();
                        ob1.setVisible(true);
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellActionPerformed

    
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
            java.util.logging.Logger.getLogger(BookCatelogueCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookCatelogueCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookCatelogueCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookCatelogueCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookCatelogueCashier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> categorybox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sell;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtisbn;
    // End of variables declaration//GEN-END:variables
}
