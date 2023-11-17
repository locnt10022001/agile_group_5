package Agile_QLBH;

import Agile_QLBH.Class.NhanVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DangKy extends javax.swing.JInternalFrame {

    List<NhanVien> listNV = new ArrayList<>();
    Connection con;

    public DangKy() {
        initComponents();

        btnSingIn.setEnabled(false);
    }

    private boolean checkForm() {
        if (txttendangnhap.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Username ko de trong !");
            txttendangnhap.requestFocus();
            return false;
        } else {
            String checkTrung = txttendangnhap.getText();
            for (int i = 0; i < listNV.size(); i++) {
                if (listNV.get(i).getUsername().equals(checkTrung)) {
                    JOptionPane.showMessageDialog(this, "Username ko duoc trung!");
                    txttendangnhap.setText("");
                    txttendangnhap.requestFocus();
                    return false;
                }
            }
        }

        if (txtmatkhau.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Password ko de trong !");
            txtmatkhau.requestFocus();
            return false;
        }

        try {
            String checkComfirm = txtmatkhau.getText();
            if (!txtxacnhan.getText().equals(checkComfirm)) {
                JOptionPane.showMessageDialog(this, "Confirm Password ko dung voi Password nhap vao !");
                txtxacnhan.requestFocus();
                return false;
            }
        } catch (Exception e) {
        }

        if (txthoten.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Email ko de trong !");
            txthoten.requestFocus();
            return false;
        } else {
            try {
                String checkEmail = "\\w+@\\w+(\\.\\w+){1,2}";
                String checkTrung = txthoten.getText();
                if (!txthoten.getText().matches(checkEmail)) {
                    JOptionPane.showMessageDialog(this, "Email ko dung dinh dang : VD : abc123@gmail.com !");
                    txthoten.requestFocus();
                    return false;
                } else {
                    for (int i = 0; i < listNV.size(); i++) {
                        if (listNV.get(i).getEmail().equals(checkTrung)) {
                            JOptionPane.showMessageDialog(this, "Email ko duoc trung!");
                            txthoten.setText("");
                            txthoten.requestFocus();
                            return false;
                        }
                    }
                }
            } catch (Exception e) {

            }
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txttendangnhap = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtmatkhau = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtxacnhan = new javax.swing.JPasswordField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        btndangky = new javax.swing.JButton();
        btnSingIn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtmanv = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        txtemail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail4 = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        cbochucvu = new javax.swing.JComboBox<>();
        cbogioitinh1 = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(74, 31, 61));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Username");

        txttendangnhap.setBackground(new java.awt.Color(74, 31, 61));
        txttendangnhap.setForeground(new java.awt.Color(204, 204, 204));
        txttendangnhap.setText("Username ");
        txttendangnhap.setBorder(null);
        txttendangnhap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txttendangnhapFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Password");

        txtmatkhau.setBackground(new java.awt.Color(74, 31, 61));
        txtmatkhau.setForeground(new java.awt.Color(204, 204, 204));
        txtmatkhau.setText("password");
        txtmatkhau.setBorder(null);
        txtmatkhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtmatkhauFocusGained(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Comfirm Password");

        txtxacnhan.setBackground(new java.awt.Color(74, 31, 61));
        txtxacnhan.setForeground(new java.awt.Color(204, 204, 204));
        txtxacnhan.setText("password");
        txtxacnhan.setBorder(null);
        txtxacnhan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtxacnhanFocusGained(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Email");

        txthoten.setBackground(new java.awt.Color(74, 31, 61));
        txthoten.setForeground(new java.awt.Color(204, 204, 204));
        txthoten.setText("Đặng Kỳ Thư");
        txthoten.setBorder(null);
        txthoten.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txthotenFocusGained(evt);
            }
        });

        btndangky.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btndangky.setForeground(new java.awt.Color(153, 0, 0));
        btndangky.setText("Đăng Ký");
        btndangky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangkyActionPerformed(evt);
            }
        });

        btnSingIn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSingIn.setForeground(new java.awt.Color(153, 0, 0));
        btnSingIn.setText("Thoát");
        btnSingIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSingInActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("Ma NV");

        txtmanv.setBackground(new java.awt.Color(74, 31, 61));
        txtmanv.setForeground(new java.awt.Color(204, 204, 204));
        txtmanv.setText("NV009");
        txtmanv.setBorder(null);
        txtmanv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtmanvFocusGained(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Họ Tên NV");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setText("Chức Vụ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("Địa Chỉ");

        txtdiachi.setBackground(new java.awt.Color(74, 31, 61));
        txtdiachi.setForeground(new java.awt.Color(204, 204, 204));
        txtdiachi.setText("Thạch Thất - Hà Nội");
        txtdiachi.setBorder(null);
        txtdiachi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtdiachiFocusGained(evt);
            }
        });

        txtemail.setBackground(new java.awt.Color(74, 31, 61));
        txtemail.setForeground(new java.awt.Color(204, 204, 204));
        txtemail.setText("Enter Email Arddress");
        txtemail.setBorder(null);
        txtemail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtemailFocusGained(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("Số Điện Thoại");

        txtEmail4.setBackground(new java.awt.Color(74, 31, 61));
        txtEmail4.setForeground(new java.awt.Color(204, 204, 204));
        txtEmail4.setText("0123456789");
        txtEmail4.setBorder(null);
        txtEmail4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmail4FocusGained(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 255, 255));
        jLabel10.setText("Giới Tính");

        cbochucvu.setBackground(new java.awt.Color(74, 31, 61));
        cbochucvu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbochucvu.setForeground(new java.awt.Color(74, 31, 61));
        cbochucvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boss", "Employee" }));
        cbochucvu.setBorder(null);

        cbogioitinh1.setBackground(new java.awt.Color(74, 31, 61));
        cbogioitinh1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbogioitinh1.setForeground(new java.awt.Color(74, 31, 61));
        cbogioitinh1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cbogioitinh1.setBorder(null);
        cbogioitinh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbogioitinh1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtmatkhau, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtxacnhan, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtmanv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txthoten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txttendangnhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail4)
                            .addComponent(jSeparator9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdiachi)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtemail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(68, 68, 68))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbogioitinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbochucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(72, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btndangky)
                .addGap(29, 29, 29)
                .addComponent(btnSingIn)
                .addGap(351, 351, 351))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(13, 13, 13)
                        .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail4, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbogioitinh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(13, 13, 13)
                        .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(14, 14, 14)
                        .addComponent(cbochucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndangky)
                    .addComponent(btnSingIn))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttendangnhapFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttendangnhapFocusGained
        txttendangnhap.setText("");
    }//GEN-LAST:event_txttendangnhapFocusGained

    private void txtmatkhauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmatkhauFocusGained
        txtmatkhau.setText("");
    }//GEN-LAST:event_txtmatkhauFocusGained

    private void txtxacnhanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtxacnhanFocusGained
        txtxacnhan.setText("");
    }//GEN-LAST:event_txtxacnhanFocusGained

    private void txthotenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txthotenFocusGained
        txthoten.setText("");
    }//GEN-LAST:event_txthotenFocusGained

    private void btndangkyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndangkyActionPerformed

        if (checkForm()) {
            try {
                String manv = "";
                String username = txttendangnhap.getText();
                String password = txtmatkhau.getText();
                String email = txthoten.getText();
                String hoTen = "";
                String gioiTinh = "";
                String chucVu = "";
                String diaChi = "";
                String sdt = "";

                String sql = "insert into NHANVIEN(MaNV,TenDangNhap,MatKhau,HoTenNV,GioiTinh,ChucVu,DChi,SDT,Email) values (?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, manv);
                
                JOptionPane.showMessageDialog(this, "Sing up Thanh cong !");
                btnSingIn.setEnabled(true);
            } catch (Exception e) {
            }

        }

    }//GEN-LAST:event_btndangkyActionPerformed

    private void btnSingInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSingInActionPerformed
        this.dispose();

//        LoginForm loginForm = new LoginForm();
//        loginForm.setVisible(true);
    }//GEN-LAST:event_btnSingInActionPerformed

    private void txtmanvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmanvFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmanvFocusGained

    private void txtdiachiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdiachiFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiachiFocusGained

    private void txtemailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemailFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailFocusGained

    private void txtEmail4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmail4FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmail4FocusGained

    private void cbogioitinh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbogioitinh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbogioitinh1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSingIn;
    private javax.swing.JButton btndangky;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbochucvu;
    private javax.swing.JComboBox<String> cbogioitinh1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField txtEmail4;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtmanv;
    private javax.swing.JPasswordField txtmatkhau;
    private javax.swing.JTextField txttendangnhap;
    private javax.swing.JPasswordField txtxacnhan;
    // End of variables declaration//GEN-END:variables
}
