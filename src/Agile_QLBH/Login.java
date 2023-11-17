/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agile_QLBH;

import Agile_QLBH.Class.NhanVien;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author ABC
 */
public class Login extends javax.swing.JInternalFrame {

    List<NhanVien> listnv = new ArrayList<>();
    Connection con;
    public static String tenDangNhap;
    public static String maHoaDon;
    public static String maKhachHang;

    public Login() {
        initComponents();
        setLocation(200, 100);
        ketNoi();
        listnv = fillAll();
        //labQuenMatKhau.setForeground(Color.blue);
    }

    private boolean cheeckForm() {

        if (txtUserName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên Đăng Nhập Không Để Trống !");
            txtUserName.requestFocus();
            return false;
        }

        if (txtPass.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mật Khẩu  Không Để Trống !");
            txtPass.requestFocus();
            return false;
        }

        return true;
    }

    public void ketNoi() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost\\DESKTOP-RPK6PAD\\SQLEXPRESS:1433;databaseName=QLBH102",
                    "sa", "888888");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Ko tim thay driver tuong thich !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ko tim thay driver tuong thich !");
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

        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtUserName = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSingUp1 = new javax.swing.JButton();
        btnSingUp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        labQuenMatKhau = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 153));
        setClosable(true);
        setDoubleBuffered(true);

        jPanel5.setBackground(new java.awt.Color(74, 31, 61));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/search (1).png"))); // NOI18N

        jLabel5.setBackground(new java.awt.Color(186, 79, 84));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(186, 79, 84));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("welcome");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addGap(67, 67, 67))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(186, 79, 84));

        txtUserName.setBackground(new java.awt.Color(186, 79, 84));
        txtUserName.setForeground(new java.awt.Color(204, 204, 204));
        txtUserName.setBorder(null);
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserNameFocusGained(evt);
            }
        });

        txtPass.setBackground(new java.awt.Color(186, 79, 84));
        txtPass.setForeground(new java.awt.Color(204, 204, 204));
        txtPass.setText("PassƯỏd");
        txtPass.setBorder(null);
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("UserName");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Password");

        btnSingUp1.setBackground(new java.awt.Color(204, 204, 204));
        btnSingUp1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSingUp1.setForeground(new java.awt.Color(255, 0, 0));
        btnSingUp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/add-group (1).png"))); // NOI18N
        btnSingUp1.setText("Đăng Ký");
        btnSingUp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSingUp1ActionPerformed(evt);
            }
        });

        btnSingUp.setBackground(new java.awt.Color(204, 204, 204));
        btnSingUp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSingUp.setForeground(new java.awt.Color(255, 0, 0));
        btnSingUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/subjects.png"))); // NOI18N
        btnSingUp.setText("Đăng Nhập");
        btnSingUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSingUpActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LOGIN");

        labQuenMatKhau.setBackground(new java.awt.Color(102, 0, 153));
        labQuenMatKhau.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labQuenMatKhau.setForeground(new java.awt.Color(74, 31, 61));
        labQuenMatKhau.setText("Quên Mật Khẩu ?");
        labQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labQuenMatKhauMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnSingUp, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSingUp1))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPass)
                                    .addComponent(jSeparator3)
                                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator4)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labQuenMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSingUp)
                    .addComponent(btnSingUp1))
                .addGap(26, 26, 26)
                .addComponent(labQuenMatKhau)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnSingUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSingUpActionPerformed

        String username = txtUserName.getText();
        String password = txtPass.getText();
        int i;
        int indexs = 0;
        try {
            if (cheeckForm()) {
                for (i = 0; i < listnv.size(); i++) {
                    if (listnv.get(i).getUsername().equalsIgnoreCase(username)
                            && listnv.get(i).getPassword().equals(password)
                            && listnv.get(i).getChucVu().equals("Boss")) {
                        JOptionPane.showMessageDialog(this, "Đăng Nhập Thành Công !");
                        indexs = i;
                        NhanVien nv = listnv.get(indexs);
                        String manv = nv.getMaNV();

                        Random rd = new Random();
                        int a = 10000 + rd.nextInt(99999);

                        maHoaDon = "HD_" + a;
                        maKhachHang = "KH_" + a;

                        tenDangNhap = manv;

                        System.out.println("----- " + tenDangNhap);
                        dispose();
                        //QLBanHang qlbh = new QLBanHang();
//                        MainQLBH.deskTop.add(qlbh);
                        //qlbh.setVisible(true);
                        MainQLBH.menuKhachHang.setEnabled(true);
                        MainQLBH.menuQuanLys.setEnabled(true);
                        MainQLBH.menuDoanhThu.setEnabled(true);
                        MainQLBH.menuThungRac.setEnabled(true);

                        return;
                    } else if (listnv.get(i).getUsername().equalsIgnoreCase(username)
                            && listnv.get(i).getPassword().equals(password)
                            && listnv.get(i).getChucVu().equals("Employee")) {
                        JOptionPane.showMessageDialog(this, "Đăng Nhập Thành Công !");
                        indexs = i;
                        NhanVien nv = listnv.get(indexs);
                        String manv = nv.getMaNV();

                        Random rd = new Random();
                        int a = 10000 + rd.nextInt(99999);

                        maHoaDon = "HD_" + a;
                        maKhachHang = "KH_" + a;

                        tenDangNhap = manv;

                        System.out.println("----- " + tenDangNhap);
                        dispose();
                        QLBanHang qlbh = new QLBanHang();
                        MainQLBH.deskTop.add(qlbh);
                        qlbh.setVisible(true);
                        MainQLBH.menuKhachHang.setEnabled(true);
                        MainQLBH.menuQuanLys.setEnabled(true);
                        return;
                    }
                }

                if (i == listnv.size()) {
                    JOptionPane.showMessageDialog(this, "Tên Đăng Nhập Hoặc Mật Khẩu  ko đúng !");
                    txtUserName.requestFocus();
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSingUpActionPerformed

    private void btnSingUp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSingUp1ActionPerformed

        this.dispose();
        DangKyBH dk = new DangKyBH();
        MainQLBH.deskTop.add(dk);
        dk.setVisible(true);

//        RegistrationForm regiterForm = new RegistrationForm();
//        regiterForm.setVisible(true);

    }//GEN-LAST:event_btnSingUp1ActionPerformed

    private void txtUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusGained

    }//GEN-LAST:event_txtUserNameFocusGained

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained
        txtPass.setText("");
    }//GEN-LAST:event_txtPassFocusGained

    private void labQuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labQuenMatKhauMouseClicked
        dispose();
        Forget forget = new Forget();
        MainQLBH.deskTop.add(forget);
        forget.setVisible(true);
    }//GEN-LAST:event_labQuenMatKhauMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSingUp;
    private javax.swing.JButton btnSingUp1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labQuenMatKhau;
    private javax.swing.JPasswordField txtPass;
    public static javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
