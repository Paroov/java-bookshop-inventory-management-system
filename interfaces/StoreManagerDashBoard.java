
package interfaces;

import codes.DBconnect;
import java.sql.Connection;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import com.mysql.cj.jdbc.Driver;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
//import com.sun.jdi.connect.spi.Connection;
//import com.mysql.jdbc.Driver;
import java.awt.Image;
import java.io.InputStream;
import java.io.*;
import javax.swing.ImageIcon;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import java.io.IOException;
import javax.swing.JTextField;       
        
        
        

public class StoreManagerDashBoard extends javax.swing.JFrame {
    Connection conn=null;
    PreparedStatement pst =null;
    ResultSet rs;
    
    
    
        //String bookId;
        String ISBN_NO;
        String title;
        String author;
        String category;
        String publisher;
        int publicationYear;
        float price;
        String languageOfBook;
        int quantity;
        String discription;
        
       
        public void cle(){
        
        txtISBN_NO.setText(null);
        //txtISBNno.setText(null);
        //jTextArea3.setText(null);
        txtTitle.setText(null);
        txtAuthor.setText(null);
        comboboxCategory.setSelectedIndex(-1);
        txtPublisher.setText(null);
        YearChooser.setYear(2000);
        txtPrice.setText(null);
        txtLanguage.setText(null);
        txtQty.setText(null);
        txtDescription.setText(null);
        //lblCoverPhoto.setIcon(null);
        //lblCoverPhoto.setIcon(new ImageIcon());
        lblCoverPhoto.setIcon(null);
        
        }
    public StoreManagerDashBoard() {
        initComponents();
        conn=DBconnect.connect();
        
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
        Image newImg=img.getScaledInstance(lblCoverPhoto.getWidth(),lblCoverPhoto.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image=new ImageIcon(newImg);
        return image;
    }
    
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtISBN_NO = new javax.swing.JTextField();
        txtTitle = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        txtPublisher = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtLanguage = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnSearchBook = new javax.swing.JButton();
        comboboxCategory = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        YearChooser = new com.toedter.calendar.JYearChooser();
        jLabel14 = new javax.swing.JLabel();
        lblCoverPhoto = new javax.swing.JLabel();
        btnAddBook = new javax.swing.JButton();
        btnSelectBook = new javax.swing.JButton();
        btnRemoveBook = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 255,80));

        jPanel2.setBackground(new java.awt.Color(0, 51, 204,80));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ISBN_NO");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("title");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("author");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("publisher");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("publication year");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("category");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("price");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("language");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("description");

        txtISBN_NO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtISBN_NOActionPerformed(evt);
            }
        });

        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });

        txtPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPublisherActionPerformed(evt);
            }
        });

        txtLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLanguageActionPerformed(evt);
            }
        });

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        btnSearchBook.setBackground(new java.awt.Color(0, 0, 0));
        btnSearchBook.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearchBook.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchBook.setText("Search");
        btnSearchBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 2));
        btnSearchBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchBookActionPerformed(evt);
            }
        });

        comboboxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("quantity");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel8)
                    .addComponent(jLabel13)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTitle)
                    .addComponent(jScrollPane1)
                    .addComponent(txtAuthor)
                    .addComponent(txtPublisher)
                    .addComponent(txtPrice)
                    .addComponent(txtLanguage)
                    .addComponent(txtISBN_NO)
                    .addComponent(comboboxCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtQty)
                    .addComponent(YearChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtISBN_NO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboboxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(YearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cover Image");

        lblCoverPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnAddBook.setBackground(new java.awt.Color(0, 0, 0));
        btnAddBook.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddBook.setForeground(new java.awt.Color(255, 255, 255));
        btnAddBook.setText("Add");
        btnAddBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 2));
        btnAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookActionPerformed(evt);
            }
        });

        btnSelectBook.setBackground(new java.awt.Color(0, 0, 0));
        btnSelectBook.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSelectBook.setForeground(new java.awt.Color(255, 255, 255));
        btnSelectBook.setText("select");
        btnSelectBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 2));
        btnSelectBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectBookActionPerformed(evt);
            }
        });

        btnRemoveBook.setBackground(new java.awt.Color(0, 0, 0));
        btnRemoveBook.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRemoveBook.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveBook.setText("Remove");
        btnRemoveBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 2));
        btnRemoveBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveBookActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Clear Data");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 2));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemoveBook, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(btnSelectBook, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCoverPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(btnSelectBook))
                .addGap(18, 18, 18)
                .addComponent(lblCoverPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnRemoveBook, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 700, 500));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("Chapters Book Shop");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 60));

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Log Out");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, 100, 30));

        jPanel4.setBackground(new java.awt.Color(0, 0, 153,80));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Catelogue");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Update");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Manage");
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 220, 500));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SMbluee.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 590));

        jButton2.setText("Remove Book");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 140, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
                        setVisible(false);
                        StartingDashBoardEmp ob1=new StartingDashBoardEmp();
                        //ob1.setUpLoading();
                        ob1.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void btnAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookActionPerformed
        
        
        try {
        ISBN_NO = txtISBN_NO.getText();
       
        } catch (NullPointerException e) {
             ISBN_NO = txtISBN_NO.getText();
             if (ISBN_NO== null || ISBN_NO.isEmpty()) {
             JOptionPane.showMessageDialog(null, "Please enter a valid ISBN_NO.", "Error", JOptionPane.ERROR_MESSAGE);
             }else{
                JOptionPane.showMessageDialog(null, "Error occurred.", "Error", JOptionPane.ERROR_MESSAGE); 
             }      
         
        }
       
       
        //ISBN_NO=txtISBN_NO.getText();
        title=txtTitle.getText();
        author=txtAuthor.getText();
        category=comboboxCategory.getSelectedItem().toString();
        publisher=txtPublisher.getText();
        publicationYear=YearChooser.getYear();
        
        try {
            price = Float.parseFloat(txtPrice.getText());
}       catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid price value.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop execution of the method
}
        languageOfBook=txtLanguage.getText();
        quantity=Integer.parseInt(txtQty.getText());
        discription=txtDescription.getText();
        
        try{
            //String sql= "insert into books(bookId,ISBN_NO,title,author,category,publisher,publicationYear,price,languageOfBook,quantity,description,imagePath)values ('"+bookId+"','"+ISBN_NO+"','"+title+"','"+author+"','"+category+"','"+publisher+"','"+publicationYear+"','"+price+"','"+languageOfBook+"','"+quantity+"','"+discription+"','"+imagePath+"')";
           String sql= "insert into books(ISBN_NO,title,author,category,publisher,publicationYear,price,languageOfBook,quantity,description,Image)values (?,?,?,?,?,?,?,?,?,?,?)";
           pst = conn.prepareStatement(sql);
          // pst.setString(1, bookId);
           pst.setString(1, ISBN_NO);
           pst.setString(2, title);
           pst.setString(3, author);
           pst.setString(4, category);
           pst.setString(5, publisher);
           pst.setInt(6, publicationYear);
           pst.setFloat(7, price);
           pst.setString(8, languageOfBook);
           pst.setInt(9, quantity);
           pst.setString(10, discription);
           if (imgPath != null){
                try{
                   InputStream img=new FileInputStream(new File(imgPath)); 
                   pst.setBlob(11,img);
                }catch(Exception e){    
                }
            }
           
           pst.executeUpdate();
           pst = conn.prepareStatement(sql);
            
           JOptionPane.showMessageDialog(null, "Successfully added.");
        }catch(Exception e){
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
              JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        
        
    }//GEN-LAST:event_btnAddBookActionPerformed

    private void btnSelectBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectBookActionPerformed
        // TODO add your handling code here:
        // Inside the btnChooseImageActionPerformed method                                          
   /* JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png");
    fileChooser.setFileFilter(filter);
    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        String absoluteImagePath=selectedFile.getAbsolutePath();
        //if(!absoluteImagePath.startsWith("/")){
           // absoluteImagePath="/"+absoluteImagePath;
        //}//
        
       //absoluteImagePath
       imagePath.setText(absoluteImagePath);
       

        ImageIcon coverPhoto = new ImageIcon(absoluteImagePath);
        Image scaledImage = coverPhoto.getImage().getScaledInstance(lblCoverPhoto.getWidth(), lblCoverPhoto.getHeight(), Image.SCALE_SMOOTH);
        lblCoverPhoto.setIcon(new ImageIcon(scaledImage));       
     
    }*/
    JFileChooser file=new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        //filter the files
        FileNameExtensionFilter filter=new FileNameExtensionFilter("*.Images","jpg","gif","png");
        file.addChoosableFileFilter(filter);
        int result=file.showSaveDialog(null);
        if (result== JFileChooser.APPROVE_OPTION){
            File selectedFile=file.getSelectedFile();
            String path=selectedFile.getAbsolutePath();
            lblCoverPhoto.setIcon(ResizeImage(path,null));
            imgPath=path;
        }
        
    }//GEN-LAST:event_btnSelectBookActionPerformed

    private void btnSearchBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBookActionPerformed
     
        // TODO add your handling code here:

    ISBN_NO = txtISBN_NO.getText(); // Get the book ID to search for

    try {
        String sql = "SELECT * FROM books WHERE ISBN_NO = ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,ISBN_NO );
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            // Retrieve data from the result set
            //String bookId = rs.getString("bookId");
            String ISBN_NO = rs.getString("ISBN_NO");
            String title = rs.getString("title");
            String author = rs.getString("author");
            String category = rs.getString("category");
            String publisher = rs.getString("publisher");
            int publicationYear = rs.getInt("publicationYear");
            float price = rs.getFloat("price");
            String languageOfBook = rs.getString("languageOfBook");
            int quantity = rs.getInt("quantity");
            String description = rs.getString("description");
            //String imagePath = rs.getString("imagePath");

            // Display retrieved data in your form fields
            //txtISBN_NO.setText(bookId);
            txtISBN_NO.setText(ISBN_NO);
            txtTitle.setText(title);
            txtAuthor.setText(author);
            comboboxCategory.setSelectedItem(category);
            txtPublisher.setText(publisher);
            YearChooser.setValue(publicationYear);
            txtPrice.setText(String.valueOf(price));
            txtLanguage.setText(languageOfBook);
            txtQty.setText(String.valueOf(quantity));
            txtDescription.setText(description);
            lblCoverPhoto.setIcon(ResizeImage(null,rs.getBytes("Image")));
            
        } else {
            JOptionPane.showMessageDialog(null, "Book with ID " + ISBN_NO + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    
    
    
        
    }//GEN-LAST:event_btnSearchBookActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        cle();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPublisherActionPerformed

    private void txtLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLanguageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLanguageActionPerformed

    private void btnRemoveBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveBookActionPerformed
        // TODO add your handling code here:
        
        String sql="DELETE FROM `books` WHERE ISBN_NO=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,txtISBN_NO.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Book is deleted....");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);   
        }
        
        cle();
    }//GEN-LAST:event_btnRemoveBookActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
                        setVisible(false);
                        Login ob1=new Login();
                        //ob1.setUpLoading();
                        ob1.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
                //setVisible(false);
                UPDATES ob1=new UPDATES();
                //ob1.setUpLoading();
                ob1.setVisible(true);
                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtISBN_NOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtISBN_NOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtISBN_NOActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        //ADD_EMPLOYEE
                ADD_EMPLOYEE ob1=new ADD_EMPLOYEE();
                //ob1.setUpLoading();
                ob1.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed
 
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
            java.util.logging.Logger.getLogger(StoreManagerDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StoreManagerDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StoreManagerDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StoreManagerDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StoreManagerDashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser YearChooser;
    private javax.swing.JButton btnAddBook;
    private javax.swing.JButton btnRemoveBook;
    private javax.swing.JButton btnSearchBook;
    private javax.swing.JButton btnSelectBook;
    private javax.swing.JComboBox<String> comboboxCategory;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCoverPhoto;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtISBN_NO;
    private javax.swing.JTextField txtLanguage;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtPublisher;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
