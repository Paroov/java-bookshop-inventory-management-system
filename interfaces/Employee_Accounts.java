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
import java.security.Timestamp;
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
import java.sql.Date;
import javax.swing.JOptionPane;
//import java.sql.Timestamp;


public class Employee_Accounts extends javax.swing.JFrame {
    Connection conn=null;
    PreparedStatement pst =null;
    ResultSet rs;
    private  DefaultTableModel model;
    /**
     * Creates new form Employee_Accounts
     */
    public Employee_Accounts() {
        
        initComponents();
        conn=DBconnect.connect();
        customJtable();
        loadData();
        
    }

    private void customJtable(){
        table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable jtable,Object o,boolean bln,boolean bln1,int row,int column){
                
            super.getTableCellRendererComponent(jtable,o, bln, bln1, row, column);
            if(column!=6){
                setHorizontalAlignment(JLabel.LEFT);
                
            }
            return this;    
            }
            
            
        });

     table.getColumnModel().getColumn(5).setCellRenderer(new  ImageRenderer());
        
    }
    
    private void loadData(){
        try{
            model= (DefaultTableModel)table.getModel();
            model.setRowCount(0);
            //----------
            String query = "SELECT EmpId,Name,Contact_number,Email_Address,Address,Profile_Photo FROM `employee` WHERE job_Type=\"cashier\"";
            pst = conn.prepareStatement(query);
             //pst.setString(1,(String) categorybox.getSelectedItem());
           // pst.setString(1, selectedCategory);
            rs = pst.executeQuery();
            
            //SELECT * FROM `employee` WHERE job_Type="Librarian"
            
            
           /* byte[] imageBytes;
                public ImageIcon getImage(){
                    return new ImageIcon(imageBytes);
                }*/
            //-------------
            while(rs.next()){
                String EmpId=rs.getString("EmpId");
                String Name =rs.getString("Name");
                String Contact_number=rs.getString("Contact_number");
                String Email_Address=rs.getString("Email_Address");
                String Address=rs.getString("Address");
               // Date DOB=rs.getDate(" DOB");
               
                byte[] imageBytes=rs.getBytes("Profile_Photo");
                
                
                
                //image next
                 model.addRow(new Object[]{EmpId,Name,Contact_number,Email_Address,Address,imageBytes});
              //  model.addRow(new Object[]{table.getRowCount()+1,ISBN_NO,title,price,null});
               // float price = rs.getFloat("price")
                
            }
            
            
            
            
            
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
            String query = "SELECT EmpId,Name,Contact_number,Email_Address,Address,Profile_Photo FROM `employee` WHERE Job_Type=?";
            pst = conn.prepareStatement(query);
            pst.setString(1,selectedCategory);
            //pst.setString(1, selectedCategory);
            rs = pst.executeQuery();
            
            
            
            
           /* byte[] imageBytes;
                public ImageIcon getImage(){
                    return new ImageIcon(imageBytes);
                }*/
            //-------------
          
            //v
            while(rs.next()){
                String EmpId=rs.getString("EmpId");
                String Name =rs.getString("Name");
                String Contact_number=rs.getString("Contact_number");
                String Email_Address=rs.getString("Email_Address");
                String Address=rs.getString("Address");
                //Date DOB=rs.getDate("DOB");
               
                byte[] imageBytes=rs.getBytes("Profile_Photo");
                
                
                
                //image next
                 model.addRow(new Object[]{EmpId,Name,Contact_number,Email_Address,Address,imageBytes});
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        categorybox = new javax.swing.JComboBox<>();
        txtEmp = new javax.swing.JTextField();
        removebtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 255,80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "EmpID", "Name", "Contact no", "Email Address", "Address", "Photo"
            }
        ));
        table.setRowHeight(90);
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 780, 390));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 30, 80, 30));

        categorybox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cashier", "Store Manager", " " }));
        categorybox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryboxActionPerformed(evt);
            }
        });
        jPanel1.add(categorybox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 251, -1));

        txtEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 492, 98, 30));

        removebtn.setBackground(new java.awt.Color(0, 0, 0));
        removebtn.setForeground(new java.awt.Color(255, 204, 204));
        removebtn.setText("Remove");
        removebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removebtnActionPerformed(evt);
            }
        });
        jPanel1.add(removebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 493, -1, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employee ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, 80, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 820, 540));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blu.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpActionPerformed

    private void removebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebtnActionPerformed
        // TODO add your handling code here:
        String sql="DELETE FROM `employee` WHERE EmpId=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,txtEmp.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Employee is rermoved....");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);   
        }
        customJtable();
        loadData();
    }//GEN-LAST:event_removebtnActionPerformed

    private void categoryboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryboxActionPerformed
        // TODO add your handling code here:
        loadData2();
    }//GEN-LAST:event_categoryboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
                        setVisible(false);
                        ADD_EMPLOYEE ob1=new ADD_EMPLOYEE();
                        //ob1.setUpLoading();
                        ob1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Employee_Accounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee_Accounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee_Accounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee_Accounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee_Accounts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> categorybox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removebtn;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtEmp;
    // End of variables declaration//GEN-END:variables
}
