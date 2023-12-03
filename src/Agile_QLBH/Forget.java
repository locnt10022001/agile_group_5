/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agile_QLBH;

import Agile_QLBH.Class.NhanVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ABC
 */
public class Forget extends javax.swing.JInternalFrame {

    List<NhanVien> listNV = new ArrayList<>();
    Connection con;
    int index;

    public Forget() {
        initComponents();
        setLocation(300, 80);
        ketNoi();
        listNV = fillAll();
        System.out.println("size : " + listNV.size());
        txtPassword.setEnabled(false);
        txtComfirmPasss.setEnabled(false);
        btnUpdate.setEnabled(false);
    }

    public void ketNoi() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLBH102",
                    "sa", "giang1999");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Ko tim thay driver tuong thich !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ko tim thay driver tuong thich !");
        }

    }

    private boolean checkForm() {
        if (txtUsername.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập  không để trống !");
            txtUsername.requestFocus();
            return false;
        }

        if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Email không để trống !");
            txtEmail.requestFocus();
            return false;
        } else {
            try {
                String checkEmail = "\\w+@\\w+(\\.\\w+){1,2}";
                if (!txtEmail.getText().matches(checkEmail)) {
                    JOptionPane.showMessageDialog(this, "Email không đúng định dạng : VD : abc123@gmail.com !");
                    txtEmail.requestFocus();
                    return false;
                }
            } catch (Exception e) {

            }
        }
        return true;

    }

    public boolean checkPassword() {
        if (txtPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mật Khẩu không để trống !");
            txtPassword.requestFocus();
            return false;
        }

        if (txtComfirmPasss.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Xác Nhân mật khẩu không để trống !");
            txtComfirmPasss.requestFocus();
            return false;
        } else {
            String checkPass = txtPassword.getText();
            if (!txtComfirmPasss.getText().equals(checkPass)) {
                JOptionPane.showMessageDialog(this, "Xác Nhân mật khẩu không khớp với mật khẩu đã nhâp !");
                txtComfirmPasss.requestFocus();
                return false;
            }
        }

        return true;
    }

    public void update(NhanVien regi) {
        PreparedStatement preStatement = null;

        try {

            String sql = "update NHANVIEN set MatKhau = ? where TenDangNhap =?";
            preStatement = con.prepareCall(sql);

            preStatement.setString(1, regi.getPassword());
            preStatement.setString(2, regi.getUsername());
            preStatement.execute();
        } catch (Exception e) {
        }
    }

    protected List<NhanVien> fillAll() {
        List<NhanVien> listNV1 = new ArrayList<>();
        try {
            String sql = "select * from NHANVIEN";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String manv = rs.getString("MaNV");
                String tenDN = rs.getString("TenDangNhap");
                String matKha = rs.getString("MatKhau");
                String hoTen = rs.getString("HoTenNV");
                String gt = rs.getString("GioiTinh");
                String chucVu = rs.getString("ChucVu");
                String diaChi = rs.getString("DChi");
                String sdt = rs.getString("SDT");
                String email = rs.getString("Email");

                NhanVien nv = new NhanVien(manv, tenDN, matKha, hoTen, gt, chucVu, diaChi, sdt, email);
                listNV1.add(nv);
            }

        } catch (Exception e) {
        }

        return listNV1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtEmail = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        txtComfirmPasss = new javax.swing.JPasswordField();
        btnSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(74, 31, 61));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Forget Password");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Tền Đăng Nhập");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Mật Khẩu");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Xác Nhận Mật Khẩu");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Email");

        txtUsername.setBackground(new java.awt.Color(74, 31, 61));
        txtUsername.setForeground(new java.awt.Color(204, 204, 204));
        txtUsername.setText("username");
        txtUsername.setBorder(null);
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
        });

        txtEmail.setBackground(new java.awt.Color(74, 31, 61));
        txtEmail.setForeground(new java.awt.Color(204, 204, 204));
        txtEmail.setText("abc123@gmail.com");
        txtEmail.setBorder(null);
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
        });

        txtPassword.setBackground(new java.awt.Color(74, 31, 61));
        txtPassword.setForeground(new java.awt.Color(204, 204, 204));
        txtPassword.setText("jPasswordField1");
        txtPassword.setBorder(null);
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });

        txtComfirmPasss.setBackground(new java.awt.Color(74, 31, 61));
        txtComfirmPasss.setForeground(new java.awt.Color(204, 204, 204));
        txtComfirmPasss.setText("jPasswordField1");
        txtComfirmPasss.setBorder(null);
        txtComfirmPasss.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtComfirmPasssFocusGained(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(153, 0, 0));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/search.png"))); // NOI18N
        btnSearch.setText("Tìm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(153, 0, 0));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/save (1).png"))); // NOI18N
        btnUpdate.setText("Cập Nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtUsername)
                                .addComponent(jSeparator1)
                                .addComponent(jSeparator2)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator3)
                                .addComponent(jSeparator4)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPassword)
                                .addComponent(txtComfirmPasss, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addGap(13, 13, 13)
                .addComponent(txtComfirmPasss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(btnUpdate))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        txtUsername.setText("");
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        txtEmail.setText("");
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        txtPassword.setText("");
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtComfirmPasssFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtComfirmPasssFocusGained
        txtComfirmPasss.setText("");
    }//GEN-LAST:event_txtComfirmPasssFocusGained

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            int index = 0;
            if (checkForm()) {
                String username = txtUsername.getText();
                String email = txtEmail.getText();
                for (int i = 0; i < listNV.size(); i++) {
                    if (listNV.get(i).getUsername().equalsIgnoreCase(username)
                            && listNV.get(i).getEmail().equalsIgnoreCase(email)) {
                        JOptionPane.showMessageDialog(this, "Tim thay Tai Khoan co : Tên Đăng Nhập : " + username
                                + " && Email : " + email + "\nMoi Nhap Mật Khẩu  moi");
                        index = i;
                        txtPassword.setEnabled(true);
                        txtComfirmPasss.setEnabled(true);
                        btnUpdate.setEnabled(true);
                        //                       
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Ko Tim thay Tai Khoan co : Tên Đăng Nhập : " + username
                        + " && Email : " + email);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {

            if (checkForm()) {

                try {

                    String username = txtUsername.getText();
                    String email = txtEmail.getText();
                    for (int i = 0; i < listNV.size(); i++) {
                        if (listNV.get(i).getUsername().equalsIgnoreCase(username)
                                && listNV.get(i).getEmail().equalsIgnoreCase(email)) {
                            //                        JOptionPane.showMessageDialog(this, "Tim thay Tai Khoan co : Username : " + username
                            //                                + " && Email : " + email + "\nMoi Nhap Password moi");
                            index = i;
                            txtPassword.setEnabled(true);
                            txtComfirmPasss.setEnabled(true);
                            btnUpdate.setEnabled(true);

                            if (txtPassword.getText().equals("")) {
                                JOptionPane.showMessageDialog(this, "Mật Khẩu không để trống !");
                                txtPassword.requestFocus();
                                return;
                            }

                            if (txtComfirmPasss.getText().equals("")) {
                                JOptionPane.showMessageDialog(this, "Xác Nhân mật khẩu không để trống !");
                                txtComfirmPasss.requestFocus();
                                return;
                            } else {
                                String checkPass = txtPassword.getText();
                                if (!txtComfirmPasss.getText().equals(checkPass)) {
                                    JOptionPane.showMessageDialog(this, "Xác Nhân mật khẩu không khớp với mật khẩu đã nhâp !");
                                    txtComfirmPasss.requestFocus();
                                    return;
                                }
                            }

                            try {

                                String pass = txtPassword.getText();

                                String sql = "update NHANVIEN set MatKhau = ? where TenDangNhap =?";
                                PreparedStatement preStatement = con.prepareCall(sql);

                                preStatement.setString(1, pass);
                                preStatement.setString(2, username);
                                preStatement.execute();
                                JOptionPane.showMessageDialog(this, "Mật Khẩu đã được cập nhật lại  !");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            this.dispose();
                            Login login = new Login();
                            MainQLBH.deskTop.add(login);
                            login.setVisible(true);
                            return;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPasswordField txtComfirmPasss;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
