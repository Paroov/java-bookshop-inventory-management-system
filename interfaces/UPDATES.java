/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;
//import codes.DBconnect;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import javax.swing.JOptionPane;
import com.mysql.cj.jdbc.Driver;




/////////////////
import codes.DBconnect;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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

////////////////

/**
 *
 * @author ASUS
 * 
 * 
 */






public class UPDATES extends javax.swing.JFrame {

    Connection conn=null;
    PreparedStatement pst =null;
    ResultSet rs;
    private  DefaultTableModel model;
    private  DefaultTableModel model1;
    
    private int x=0;
     private int y=0;
    /**
     * Creates new form UPDATES
     */
    public UPDATES() {
        initComponents();
        conn=DBconnect.connect();
        customJtable();
        loadData();
        //---
        customJtable2();
        loadDataa();
        
    }

    public void cle(){
           txtISBN.setText(null); 
           txtOQ.setText(null); 
           txtOp.setText(null); 
           txtQ.setText(null); 
           txtPrice.setText(null); 
        }
    
    private void customJtable(){
        table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable jtable,Object o,boolean bln,boolean bln1,int row,int column){
                
            super.getTableCellRendererComponent(jtable,o, bln, bln1, row, column);
            if(column!=5){
                setHorizontalAlignment(JLabel.LEFT);
                
            }
            return this;    
            }
            
            
        });

    // table.getColumnModel().getColumn(3).setCellRenderer(new  StartingDashBoardEmp.ImageRenderer());
       table.getColumnModel().getColumn(3).setCellRenderer(new  UPDATES.ImageRenderer());  
    }
    
    //for t 2
    private void customJtable2(){
        table2.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
           // @Override
            public Component getTableCellRendererComponent2(JTable jtable,Object o,boolean bln,boolean bln1,int row,int column){
                
            super.getTableCellRendererComponent(jtable,o, bln, bln1, row, column);
            if(column!=5){
                setHorizontalAlignment(JLabel.LEFT);
                
            }
            return this;    
            }
            
            
        });

    // table.getColumnModel().getColumn(3).setCellRenderer(new  StartingDashBoardEmp.ImageRenderer());
       table2.getColumnModel().getColumn(3).setCellRenderer(new  UPDATES.ImageRenderer2());  
    }
    //------
    private void loadData(){
        try{
            model= (DefaultTableModel)table.getModel();
            model.setRowCount(0);
            //----------
            String query = "SELECT ISBN_NO,title,price,Image FROM `books` WHERE Quantity<5";
            //String query = "SELECT ISBN_NO,title,price,Image FROM `books` WHERE category=\"Item 1\"";
            
            pst = conn.prepareStatement(query);
            //pst.setString(1, selectedCategory);
            rs = pst.executeQuery();
            
          
            //-------------
            while(rs.next()){
                String ISBN_NO=rs.getString("ISBN_NO");
                String title=rs.getString("title");
                float price=rs.getFloat("price");
                byte[] imageBytes=rs.getBytes("Image");
                
                 model.addRow(new Object[]{ISBN_NO,title,price,imageBytes});
             
            }
              
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //for 
    private void loadDataa(){
       try{
            model1= (DefaultTableModel)table2.getModel();
            model1.setRowCount(0);
            //----------
           // String query = "SELECT ISBN_NO,title,price,Image FROM `books` WHERE Quantity<5";
            //String query = "SELECT ISBN_NO,title,price,Image FROM `books` WHERE category=\"Item 1\"";
            String query = "SELECT Did,Drate,Reason,duration,amount FROM `discounts`";
            
            
            pst = conn.prepareStatement(query);
            //pst.setString(1, selectedCategory);
            rs = pst.executeQuery();
            
          
            //-------------
            while(rs.next()){
                int Did =rs.getInt("Did");
                float Drate=rs.getFloat("Drate");

                String Reason=rs.getString("Reason");
                String duration=rs.getString("duration");
                float amount=rs.getFloat("amount");
                //byte[] imageBytes=rs.getBytes("Image");
                

                 model1.addRow(new Object[]{Did,Drate,Reason,duration,amount});
             
                
            }
                        
          
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //----
    
    private  int  oldQ(){
        String  isbn1=txtISBN.getText();
        //int x=0;
        try {
        String sql = "SELECT quantity FROM books WHERE ISBN_NO = ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,isbn1 );
        ResultSet rs = pst.executeQuery();

        //int x;
        
        if (rs.next()) {
            int quantity = rs.getInt("quantity");
           
            txtOQ.setText(String.valueOf(quantity));
            x=quantity;
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Book with ID " + isbn1 + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        } catch (Exception e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return x;
       
    }
    
    
    //---
    
    private int newQ(){
        String  isbn=txtISBN.getText();
        int quantity;
        String  Quantity=txtQ.getText();
        quantity = Integer.parseInt(Quantity);
        
        y=x+quantity;
        return y;
    }
    
    private void add(){
         String sql2="update books set quantity=? where ISBN_NO=?";
        String  isbn=txtISBN.getText();
        int quantity;
        String  Quantity=txtQ.getText();
        
        
       try{
          
           
            quantity = Integer.parseInt(Quantity);
            pst = conn.prepareStatement(sql2);
            pst.setFloat(1, y);
            pst.setString(2, isbn);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Updated");
            } else {
                JOptionPane.showMessageDialog(null, "No records updated");
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Not updated correctly: " + e.getMessage());
        }
     }
    //--------
    
    /* private void add(){
         String sql2="update books set quantity=? where ISBN_NO=?";
        String  isbn=txtISBN.getText();
        int quantity;
        String  Quantity=txtQ.getText();
        //quantity = Integer.parseInt(Quantity);
        
       try{
          
           
            quantity = Integer.parseInt(Quantity);
            pst = conn.prepareStatement(sql2);
            pst.setFloat(1, quantity);
            pst.setString(2, isbn);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Updated");
            } else {
                JOptionPane.showMessageDialog(null, "No records updated");
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Not updated correctly: " + e.getMessage());
        }
     }
     */
    //----
     
    
    //---------
     private void loadData2(){
        try{
            //--
            //String selectedCategory = (String) categorybox.getSelectedItem();
            //--
            model= (DefaultTableModel)table.getModel();
            model.setRowCount(0);
            //----------
            
           
            String query = "SELECT ISBN_NO,title,price,Image FROM `books` WHERE Quantity<5";
            pst = conn.prepareStatement(query);
           // pst.setString(1,selectedCategory);
            //pst.setString(1, selectedCategory);
            rs = pst.executeQuery();
            
            
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
     //---------
     //for t2
      private void loadDataa2(){
        try{
            //--
            //String selectedCategory = (String) categorybox.getSelectedItem();
            //--
            model1= (DefaultTableModel)table2.getModel();
            model1.setRowCount(0);
            //----------
            
           //"SELECT Did,Drate,Reason,duration,amount FROM `discounts`";
           
            String query ="SELECT Did,Drate,Reason,duration,amount FROM `discounts`";

            //String query = "SELECT ISBN_NO,title,price,Image FROM `books` WHERE Quantity<5";
            pst = conn.prepareStatement(query);
           // pst.setString(1,selectedCategory);
            //pst.setString(1, selectedCategory);
            rs = pst.executeQuery();
            
            
            //-------------
          /*  while(rs.next()){
                String ISBN_NO=rs.getString("ISBN_NO");
                String title=rs.getString("title");
                float price=rs.getFloat("price");
                byte[] imageBytes=rs.getBytes("Image");
                */
           while(rs.next()){
                int Did =rs.getInt("Did");
                float Drate=rs.getFloat("Drate");

                String Reason=rs.getString("Reason");
                String duration=rs.getString("duration");
                float amount=rs.getFloat("amount");    
                
                //image next
                // model.addRow(new Object[]{ISBN_NO,title,price,imageBytes});
              //  model.addRow(new Object[]{table.getRowCount()+1,ISBN_NO,title,price,null});
               // float price = rs.getFloat("price")
                 model1.addRow(new Object[]{Did,Drate,Reason,duration,amount});
            }
            
            
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

     private class ImageRenderer extends DefaultTableCellRenderer {
        //public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        public Component getTableCellRendererComponent(JTable jtable,Object o,boolean bln,boolean bln1,int row,int column) {
        byte[] imageData = (byte[]) o; // Assuming the image data is stored as byte array (BLOB)
        ImageIcon imageIcon = new ImageIcon(imageData);
        Image scaledImage = imageIcon.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        return new JLabel(new ImageIcon(scaledImage));
        }
    }
     private class ImageRenderer2 extends DefaultTableCellRenderer {
        //public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        public Component getTableCellRendererComponent2(JTable jtable,Object o,boolean bln,boolean bln1,int row,int column) {
        byte[] imageData = (byte[]) o; // Assuming the image data is stored as byte array (BLOB)
        ImageIcon imageIcon = new ImageIcon(imageData);
        Image scaledImage = imageIcon.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        return new JLabel(new ImageIcon(scaledImage));
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtQ = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtISBN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnCle = new javax.swing.JButton();
        txtOQ = new javax.swing.JTextField();
        txtOp = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtA = new javax.swing.JTextField();
        txtRemove = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtDct = new javax.swing.JTextField();
        txtD = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtR = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtRate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 255,80));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ISBN_NO", "Name", "Price", "Photo"
            }
        ));
        table.setRowHeight(90);
        jScrollPane1.setViewportView(table);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(252, 248, 248));
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ISBN-NO");

        txtQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantity");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Price");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(252, 248, 248));
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setForeground(new java.awt.Color(252, 248, 248));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCle.setBackground(new java.awt.Color(0, 0, 0));
        btnCle.setForeground(new java.awt.Color(255, 204, 204));
        btnCle.setText("Clear");
        btnCle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setForeground(new java.awt.Color(252, 248, 248));
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 204, 204,80));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dicount");

        btnRemove.setBackground(new java.awt.Color(0, 0, 0));
        btnRemove.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 204, 204));
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Reason");

        btnAdd.setBackground(new java.awt.Color(0, 0, 0));
        btnAdd.setForeground(new java.awt.Color(252, 248, 248));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Discount_ID");

        txtR.setColumns(20);
        txtR.setRows(5);
        jScrollPane3.setViewportView(txtR);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Duration");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("amount");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Discount_ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDct, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtRate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtD, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Previous");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("New");

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Discount ID", "Rate", "Reason", "Duration", "amount"
            }
        ));
        jScrollPane2.setViewportView(table2);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Books need to buy");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Existing Discount Rates");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtOp, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnBack)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtOQ, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(12, 12, 12)
                                                    .addComponent(txtQ, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addComponent(jLabel5)
                                                    .addGap(51, 51, 51)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jButton5)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnCle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(6, 6, 6))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5)
                            .addComponent(btnCle))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(txtOQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jButton1)
                            .addComponent(txtOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(btnBack))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(57, 57, 57))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 890, 550));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Updatesbluee.jpg"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -6, 950, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String sql="update books set price=? where ISBN_NO=?";
        
        
        String  isbn=txtISBN.getText();
        Float price;
        String  priceText=txtPrice.getText();
        price=Float.parseFloat(priceText);
        
        try{
            price = Float.parseFloat(priceText);
            pst = conn.prepareStatement(sql);
            pst.setFloat(1, price);
            pst.setString(2, isbn);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Updated");
            } else {
                JOptionPane.showMessageDialog(null, "No records updated");
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Not updated correctly: " + e.getMessage());
        }
    
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        oldQ();
        newQ();
        add();
        customJtable();
        loadData();

       /* String  isbn1=txtISBN.getText();
        try {
        String sql = "SELECT quantity FROM books WHERE ISBN_NO = ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,isbn1 );
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int quantity = rs.getInt("quantity");
            //float price = rs.getFloat("price");
            
            
            
            //txtOp.setText(String.valueOf(price));
            
            txtOQ.setText(String.valueOf(quantity));
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Book with ID " + isbn1 + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        } catch (Exception e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        */
        
        
        
        //------------/
        /*
        String sql2="update books set quantity=? where ISBN_NO=?";
        String  isbn=txtISBN.getText();
        int quantity;
        String  Quantity=txtQ.getText();
        //quantity = Integer.parseInt(Quantity);
        
       try{
         
           
            quantity = Integer.parseInt(Quantity);
            pst = conn.prepareStatement(sql2);
            pst.setFloat(1, quantity);
            pst.setString(2, isbn);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Updated");
            } else {
                JOptionPane.showMessageDialog(null, "No records updated");
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Not updated correctly: " + e.getMessage());
        }
       //---after added
       //customJtable();
       //loadData();
        */
    }//GEN-LAST:event_jButton2ActionPerformed

   
       
    
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
                        setVisible(false);
                        StoreManagerDashBoard ob1=new StoreManagerDashBoard();
                        //ob1.setUpLoading();
                        ob1.setVisible(true);
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleActionPerformed
        // TODO add your handling code here:
        cle();
        
    }//GEN-LAST:event_btnCleActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        String  isbn=txtISBN.getText();
        try {
        String sql = "SELECT quantity,price FROM books WHERE ISBN_NO = ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,isbn );
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int quantity = rs.getInt("quantity");
            float price = rs.getFloat("price");
            
            
            
            txtOp.setText(String.valueOf(price));
            
            txtOQ.setText(String.valueOf(quantity));
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Book with ID " + isbn + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtQActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        String sql="DELETE FROM `discounts` WHERE Did=?";
        try{
            pst=conn.prepareStatement(sql);
            int Did=Integer.parseInt(txtRemove.getText());
            pst.setInt(1, Did);
           // pst.setString(1,txtISBN_NO.getText());
            pst.execute();
            txtRemove.setText(null);
            JOptionPane.showMessageDialog(null,"Discount is removed!....");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);   
        }
        customJtable2();
        loadDataa();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
        
        try{
            
            int Did=Integer.parseInt(txtDct.getText());
            float Drate = Float.parseFloat(txtRate.getText());
            String Reason=txtR.getText();
            String duration=txtD.getText();
            float amount = Float.parseFloat(txtA.getText());
            
            
            String sql2="insert into discounts(Did,Drate,Reason,duration,amount)values (?,?,?,?,?)";
            
            pst=conn.prepareStatement(sql2);
            
            pst.setInt(1, Did);
            pst.setFloat(2, Drate);
            pst.setString(3,Reason);
            pst.setString(4,duration);
            pst.setFloat(5, amount);
            
            
           pst.executeUpdate();
           pst = conn.prepareStatement(sql2);
            
            //pst.execute();
            txtDct.setText(null);
            txtRate.setText(null);
            txtR.setText(null);
            txtD.setText(null);
            txtA.setText(null);
            
            
           
            JOptionPane.showMessageDialog(null,"Successfully added");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        customJtable2();
        loadDataa();

    }//GEN-LAST:event_btnAddActionPerformed
   
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
            java.util.logging.Logger.getLogger(UPDATES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UPDATES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UPDATES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UPDATES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UPDATES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCle;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table;
    private javax.swing.JTable table2;
    private javax.swing.JTextField txtA;
    private javax.swing.JTextField txtD;
    private javax.swing.JTextField txtDct;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtOQ;
    private javax.swing.JTextField txtOp;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQ;
    private javax.swing.JTextArea txtR;
    private javax.swing.JTextField txtRate;
    private javax.swing.JTextField txtRemove;
    // End of variables declaration//GEN-END:variables
}
