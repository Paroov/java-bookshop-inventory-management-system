
package interfaces;
import codes.DBconnect;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
//import java.sql.Date;
import java.util.Date;


public class ADD_EMPLOYEE extends javax.swing.JFrame {
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;

    public ADD_EMPLOYEE() {
        super("Add New Employee");
        initComponents();
        //conn=javaConnect.connecrDb();
        conn=DBconnect.connect();
         Calendar specificDate=Calendar.getInstance();
            specificDate.set(2000,Calendar.DECEMBER,18);
            DOB.setDate(specificDate.getTime());

    }
    String imgPath=null;
    public ImageIcon ResizeImage(String ImagePath, byte[] pic){
        ImageIcon MyImage=null;
        if(ImagePath !=null){
            MyImage=new ImageIcon(ImagePath);
        }else{
            MyImage=new ImageIcon(pic);
        }
        Image img =MyImage.getImage();
        Image newImg=img.getScaledInstance(lblPhoto.getWidth(),lblPhoto.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image=new ImageIcon(newImg);
        return image;
    }
    //age
     private void calculateAge() {
        if (DOB.getDate() != null) {
            Calendar dob = Calendar.getInstance();
            dob.setTime(DOB.getDate());

            Calendar today = Calendar.getInstance();

            int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

            if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
                age--;
            }
            txtAge.setText(String.valueOf(age));
            //txtAge.setText(age);
           // System.out.println("Age: " + age);
        } else {
            System.out.println("Please select a valid date of birth.");
        }
    }

    //
    
    
    public void cle(){
        //jTextArea3.setText(null);
        
        txtName.setText(null);
        DOB.setDate(null);
        txtAge.setText(null);
        txtAddress.setText(null);
        txtCon_No.setText(null);
        txtEmail.setText(null);
        txtQualifications.setText(null);
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboJob_Type = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        txtAge = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQualifications = new javax.swing.JTextArea();
        txtCon_No = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Signin = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtEmpId = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        lblPhoto = new javax.swing.JLabel();
        btnAttach = new javax.swing.JButton();
        DOB = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Employee Information");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 130, 30));

        jPanel5.setBackground(new java.awt.Color(0, 102, 255,80));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Add New Employee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 18), new java.awt.Color(0, 204, 204))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Job Type");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 382, 66, 16));

        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel5.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 83, 226, 31));

        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel5.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 337, 226, 28));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 91, 81, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Age");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 187, 81, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Email address");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 343, 107, 17));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Qulifications");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 421, -1, 26));

        comboJob_Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cashier", "Store Manager" }));
        comboJob_Type.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comboJob_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboJob_TypeActionPerformed(evt);
            }
        });
        jPanel5.add(comboJob_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 377, 226, 26));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Employee Id");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 51, -1, -1));

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(txtAddress);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 227, 226, 52));

        txtAge.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 180, 131, 28));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Address");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 242, 57, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Contact number");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 299, -1, 23));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Date Of Birth");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 132, -1, 18));

        txtQualifications.setColumns(20);
        txtQualifications.setRows(5);
        txtQualifications.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txtQualifications);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 421, 226, 58));

        txtCon_No.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCon_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCon_NoActionPerformed(evt);
            }
        });
        jPanel5.add(txtCon_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 297, 226, 26));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 83, 71, -1));

        Signin.setBackground(new java.awt.Color(0, 0, 0));
        Signin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Signin.setForeground(new java.awt.Color(255, 255, 255));
        Signin.setText("Add");
        Signin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SigninActionPerformed(evt);
            }
        });
        jPanel5.add(Signin, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 271, 109, 29));

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 216, -1, -1));

        txtEmpId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEmpId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpIdActionPerformed(evt);
            }
        });
        jPanel5.add(txtEmpId, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 45, 226, 26));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Profile photo");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 51, -1, -1));

        lblPhoto.setBackground(new java.awt.Color(204, 204, 204));
        lblPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel5.add(lblPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 83, 164, 170));

        btnAttach.setBackground(new java.awt.Color(0, 0, 0));
        btnAttach.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAttach.setForeground(new java.awt.Color(255, 255, 255));
        btnAttach.setText("Attach");
        btnAttach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttachActionPerformed(evt);
            }
        });
        jPanel5.add(btnAttach, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 43, 81, 34));

        DOB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(DOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 132, 226, 30));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Calculate");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 181, 60, 28));

        jLabel3.setText("jLabel3");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 640, 530));

        Back.setBackground(new java.awt.Color(0, 0, 0));
        Back.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Back");
        Back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 100, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blu.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtEmpIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpIdActionPerformed

    private void txtCon_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCon_NoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCon_NoActionPerformed

    private void SigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SigninActionPerformed
        // TODO add your handling code here:
        
        
        try{
            
            //int EId;
           // EId = txtEmpId.getInt();
            
            int EId;
            String  empId=txtEmpId.getText();
            EId = Integer.parseInt(empId);
            
           
            ///insert into books(ISBN_NO,title,author,category,publisher,publicationYear,price,languageOfBook,quantity,description,Image)values (?,?,?,?,?,?,?,?,?,?,?)
            String sqll="insert into employee(EmpId,Name,DOB,Age,Address,Contact_number,Email_Address,Job_Type,Qualifications,Profile_Photo)values (?,?,?,?,?,?,?,?,?,?)";
            
            pst=conn.prepareStatement(sqll);
            pst.setInt(1,EId);

            if (imgPath != null){
                try{
                    InputStream img=new FileInputStream(new File(imgPath));
                    pst.setBlob(1,img);
                }catch(Exception e){

                }
            }
            //pst.setString(1,jTextArea3.getText());
            //pst.setString(12,txtEmpId.getText());
            pst.setString(1,txtEmpId.getText());
            pst.setString(2,txtName.getText());
           // pst.setDate(3, (Date) DOB.getDate());
           
           java.util.Date utilDate=DOB.getDate();
           java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
           //pst.setDate(3,(Date)DOB.getDate());
           pst.setDate(3,sqlDate);
            pst.setString(4,txtAge.getText());
            pst.setString(5,txtAddress.getText());
            pst.setString(6,txtCon_No.getText());
            pst.setString(7,txtEmail.getText());
            pst.setString(8,(String) comboJob_Type.getSelectedItem());
            pst.setString(9,txtQualifications.getText());
            
            if (imgPath != null){
                try{
                   InputStream img=new FileInputStream(new File(imgPath)); 
                   pst.setBlob(10,img);
                }catch(Exception e){    
                }
            }
            
            pst.execute();
           
            JOptionPane.showMessageDialog(null,"Added new Employee...");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_SigninActionPerformed

    private void btnAttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttachActionPerformed
        // TODO add your handling code here:
        JFileChooser file=new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        //filter the files
        FileNameExtensionFilter filter=new FileNameExtensionFilter("*.Images","jpg","gif","png");
        file.addChoosableFileFilter(filter);
        int result=file.showSaveDialog(null);
        //if the user click on jFileChooser
        if (result== JFileChooser.APPROVE_OPTION){
            File selectedFile=file.getSelectedFile();
            String path=selectedFile.getAbsolutePath();
            lblPhoto.setIcon(ResizeImage(path,null));
            imgPath=path;
        }
    }//GEN-LAST:event_btnAttachActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        StoreManagerDashBoard ob=new StoreManagerDashBoard();
        ob.setVisible(true);

    }//GEN-LAST:event_BackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        setVisible(false);
        Employee_Accounts ob=new Employee_Accounts();
        ob.setVisible(true);
                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        calculateAge();
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboJob_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboJob_TypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboJob_TypeActionPerformed

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
            java.util.logging.Logger.getLogger(ADD_EMPLOYEE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADD_EMPLOYEE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADD_EMPLOYEE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADD_EMPLOYEE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADD_EMPLOYEE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private com.toedter.calendar.JDateChooser DOB;
    private javax.swing.JButton Signin;
    private javax.swing.JButton btnAttach;
    private javax.swing.JComboBox<String> comboJob_Type;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtCon_No;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtQualifications;
    // End of variables declaration//GEN-END:variables
}
