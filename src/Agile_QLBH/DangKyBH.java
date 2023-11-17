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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ABC
 */
public class DangKyBH extends javax.swing.JInternalFrame {

    List<NhanVien> listNV = new ArrayList<>();
    Connection con;

    public DangKyBH() {
        initComponents();
        setLocation(80, 10);
        ketNoi();
        listNV = fillAll();
        System.out.println(listNV.size());

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

    private boolean checkForm() {

        if (txtmanv.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên:");
            txtmanv.requestFocus();
            return false;
        } else {
            String checkTrung = txtmanv.getText();
            for (int i = 0; i < listNV.size(); i++) {
                if (listNV.get(i).getMaNV().equals(checkTrung)) {
                    JOptionPane.showMessageDialog(this, "Ma NV ko duoc trung!");
                    txtmanv.setText("");
                    txtmanv.requestFocus();
                    return false;
                }
            }
        }
        
        if (txthoten.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập họ tên:");
            txthoten.requestFocus();
            return false;
        }

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
            JOptionPane.showMessageDialog(this, "Mat Khau ko de trong !");
            txtmatkhau.requestFocus();
            return false;
        }

        if (txtxacnhan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Xac Nhan Mat Khau chua nhap vao !");
            txtxacnhan.requestFocus();
            return false;
        } else {

            try {
                String checkComfirm = txtmatkhau.getText();
                if (!txtxacnhan.getText().equals(checkComfirm)) {
                    JOptionPane.showMessageDialog(this, "Xac Nhan Password ko dung voi Password nhap vao !");
                    txtxacnhan.requestFocus();
                    return false;
                }
            } catch (Exception e) {
            }
        }

        if (txtemail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Email ko de trong !");
            txtemail.requestFocus();
            return false;
        } else {
            try {
                String checkEmail = "\\w+@\\w+(\\.\\w+){1,2}";
                String checkTrung = txtemail.getText();
                if (!txtemail.getText().matches(checkEmail)) {
                    JOptionPane.showMessageDialog(this, "Email ko dung dinh dang : VD : abc123@gmail.com !");
                    txtemail.requestFocus();
                    return false;
                } else {
                    for (int i = 0; i < listNV.size(); i++) {
                        if (listNV.get(i).getEmail().equals(checkTrung)) {
                            JOptionPane.showMessageDialog(this, "Email ko duoc trung!");
                            txtemail.setText("");
                            txtemail.requestFocus();
                            return false;
                        }
                    }
                }
            } catch (Exception e) {

            }
        }

        

        if (txtsodt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SDT  ko de trong !");
            txtsodt.requestFocus();
            return false;
        } else {
            try {
                String checksdt = "0\\d{9}";
                String checkPhone = txtsodt.getText();
                if (!txtsodt.getText().matches(checksdt)) {
                    JOptionPane.showMessageDialog(this, "SDT phai 10 so  !");
                    txtsodt.requestFocus();
                    return false;
                } else {
                    for (int i = 0; i < listNV.size(); i++) {
                        if (listNV.get(i).getSdt().equals(checkPhone)) {
                            JOptionPane.showMessageDialog(this, "SDT ko de trung !");

                            txtsodt.requestFocus();
                            txtsodt.setText("");
                            return false;
                        }
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "SDT phai la so !");
            }
        }

        if (txtdiachi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ:");
            txtdiachi.requestFocus();
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pannel = new javax.swing.JPanel();
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
        txtsodt = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        cbochucvu = new javax.swing.JComboBox<>();
        cbogioitinh1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        Pannel.setBackground(new java.awt.Color(74, 31, 61));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Tên Đăng Nhập");

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
        jLabel2.setText("Mật Khẩu");

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
        jLabel3.setText("Xác Nhận Mật Khẩu");

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

        btndangky.setBackground(new java.awt.Color(255, 255, 255));
        btndangky.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btndangky.setForeground(new java.awt.Color(153, 0, 0));
        btndangky.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/plus.png"))); // NOI18N
        btndangky.setText("Đăng Ký");
        btndangky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangkyActionPerformed(evt);
            }
        });

        btnSingIn.setBackground(new java.awt.Color(255, 255, 255));
        btnSingIn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSingIn.setForeground(new java.awt.Color(153, 0, 0));
        btnSingIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/subjects.png"))); // NOI18N
        btnSingIn.setText("Đăng Nhập");
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
        txtemail.setText("abc123@gmail.com");
        txtemail.setBorder(null);
        txtemail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtemailFocusGained(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("Số Điện Thoại");

        txtsodt.setBackground(new java.awt.Color(74, 31, 61));
        txtsodt.setForeground(new java.awt.Color(204, 204, 204));
        txtsodt.setText("0123456789");
        txtsodt.setBorder(null);
        txtsodt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtsodtFocusGained(evt);
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

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 0));
        jLabel11.setText("Đăng Ký Tài Khoản");

        javax.swing.GroupLayout PannelLayout = new javax.swing.GroupLayout(Pannel);
        Pannel.setLayout(PannelLayout);
        PannelLayout.setHorizontalGroup(
            PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PannelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmatkhau)
                    .addComponent(jSeparator2)
                    .addComponent(txtxacnhan)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1)
                    .addComponent(txthoten, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(txttendangnhap)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110)
                .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PannelLayout.createSequentialGroup()
                        .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtsodt)
                            .addComponent(jSeparator9)
                            .addGroup(PannelLayout.createSequentialGroup()
                                .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                    .addGroup(PannelLayout.createSequentialGroup()
                        .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbogioitinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbochucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PannelLayout.createSequentialGroup()
                .addContainerGap(298, Short.MAX_VALUE)
                .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PannelLayout.createSequentialGroup()
                        .addComponent(btndangky, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnSingIn)
                        .addGap(323, 323, 323))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PannelLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(359, 359, 359))))
        );
        PannelLayout.setVerticalGroup(
            PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PannelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PannelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PannelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PannelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(13, 13, 13)
                        .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PannelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsodt, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbogioitinh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PannelLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PannelLayout.createSequentialGroup()
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PannelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(13, 13, 13)
                        .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PannelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(14, 14, 14)
                        .addComponent(cbochucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PannelLayout.createSequentialGroup()
                        .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndangky)
                    .addComponent(btnSingIn))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                String manv = txtmanv.getText();
                String username = txttendangnhap.getText();
                String password = txtmatkhau.getText();
                String email = txthoten.getText();
                String hoTen = txthoten.getText();
                String gioiTinh = cbogioitinh1.getSelectedItem().toString();
                String chucVu = cbochucvu.getSelectedItem().toString();
                String diaChi = txtdiachi.getText();
                String sdt = txtsodt.getText();

                String sql = "insert into NHANVIEN(MaNV,TenDangNhap,MatKhau,HoTenNV,GioiTinh,ChucVu,DChi,SDT,Email) values (?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, manv);
                ps.setString(2, username);
                ps.setString(3, password);
                ps.setString(4, hoTen);
                ps.setString(5, gioiTinh);
                ps.setString(6, chucVu);
                ps.setString(7, diaChi);
                ps.setString(8, sdt);
                ps.setString(9, email);
                ps.execute();

                JOptionPane.showMessageDialog(this, "Đăng Ký Thành Công !");

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_btndangkyActionPerformed

    private void btnSingInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSingInActionPerformed
        this.dispose();
        Login login = new Login();
        MainQLBH.deskTop.add(login);
        login.setVisible(true);
    }//GEN-LAST:event_btnSingInActionPerformed

    private void txtmanvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmanvFocusGained
        txtmanv.setText("");
    }//GEN-LAST:event_txtmanvFocusGained

    private void txtdiachiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdiachiFocusGained
        txtdiachi.setText("");
    }//GEN-LAST:event_txtdiachiFocusGained

    private void txtemailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemailFocusGained
        txtemail.setText("");
    }//GEN-LAST:event_txtemailFocusGained

    private void txtsodtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsodtFocusGained
        txtsodt.setText("");
    }//GEN-LAST:event_txtsodtFocusGained

    private void cbogioitinh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbogioitinh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbogioitinh1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pannel;
    private javax.swing.JButton btnSingIn;
    private javax.swing.JButton btndangky;
    private javax.swing.JComboBox<String> cbochucvu;
    private javax.swing.JComboBox<String> cbogioitinh1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtmanv;
    private javax.swing.JPasswordField txtmatkhau;
    private javax.swing.JTextField txtsodt;
    private javax.swing.JTextField txttendangnhap;
    private javax.swing.JPasswordField txtxacnhan;
    // End of variables declaration//GEN-END:variables
}
