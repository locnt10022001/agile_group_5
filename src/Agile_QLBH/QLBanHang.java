package Agile_QLBH;

import Agile_QLBH.Class.HoaDon;
import Agile_QLBH.Class.HoaDonChiTiet;
import Agile_QLBH.Class.KhachHang;
import Agile_QLBH.Class.SanPham;
import Agile_QLBH.Class.SanPhamClick;
import Agile_QLBH.Class.SanPhamModify;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QLBanHang extends javax.swing.JInternalFrame {

    Connection con;
    DefaultTableModel model1;
    DefaultTableModel model2;
    List<SanPham> listSP = new ArrayList<>();
    List<SanPhamClick> listSPC = new ArrayList<>();
    List<HoaDon> listHD = new ArrayList<>();
    List<KhachHang> listKH = new ArrayList<>();
    List<KhachHang> listKHFindAll = new ArrayList<>();
    int tongTien = 0;
    int index;

    List<HoaDonChiTiet> listHDCT = new ArrayList<>();

    public QLBanHang() {
        initComponents();
        ketNoi();
        setLocation(15, 10);
        listHD = fillAllHD();
        model1 = (DefaultTableModel) tableListSP.getModel();
        fillToTable();
        System.out.println(listHDCT.size());

        String maNV = Login.tenDangNhap;
        String maHD = Login.maHoaDon;
        String maKH = Login.maKhachHang;
        txtManv.setText(maNV);
        txtMahd.setText(maHD);
        txtMaKH.setText(maKH);
        txtNgayMua.setText(String.valueOf(java.time.LocalDate.now()));
        System.out.println("ten dăng nhap : " + listHD.size());

        txtMaKH.setEnabled(false);
        txtMahd.setEnabled(false);
        txtManv.setEnabled(false);
        txtNgayMua.setEnabled(false);

        fillAllKH();
        System.out.println("Khách Hàng : " + listKH.size());
        fillAllKHALL();
        System.out.println("Khách Hàng : " + listKHFindAll.size());

    }

    private List<HoaDon> fillAllHD() {
        List<HoaDon> listKH = new ArrayList<>();
        try {

            String sql = "select *from HOADON";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                HoaDon kh = new HoaDon(
                        rs.getString("MaHoaDon"),
                        rs.getString("MaKH"),
                        rs.getString("MaNV"),
                        rs.getInt("TongTien"),
                        rs.getDate("NgayMuaHang"),
                        rs.getString("Delete_at"),
                        rs.getString("Delete_Uuer"));

                listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listKH;
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

    private void fillToTable() {
        listSP = SanPhamModify.findAll();
        model1.setRowCount(0);

        for (SanPham sp : listSP) {
            model1.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(),
                sp.getGia(), sp.getMauSac()
            });
        }
    }

    private void fillAllKH() {

        try {

            String sql = "select * from KHACHHANG where Delete_at is null ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String maKH = rs.getString("MaKH");
                String tenKH = rs.getString("TenKH");
                String sdt = rs.getString("SDT");
                String dChi = rs.getString("DChi");
                String delete_at = rs.getString("Delete_at");
                String delete_User = rs.getString("Delete_Uuer");

                KhachHang kh = new KhachHang(maKH, tenKH, sdt, dChi, delete_at, delete_User);

                listKH.add(kh);
                comboDanhSachKH.addItem(tenKH);
            }
        } catch (Exception e) {
        }

    }

    private void fillAllKHALL() {

        try {

            String sql = "select * from KHACHHANG  ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String maKH = rs.getString("MaKH");
                String tenKH = rs.getString("TenKH");
                String sdt = rs.getString("SDT");
                String dChi = rs.getString("DChi");
                String delete_at = rs.getString("Delete_at");
                String delete_User = rs.getString("Delete_Uuer");

                KhachHang kh = new KhachHang(maKH, tenKH, sdt, dChi, delete_at, delete_User);

                listKHFindAll.add(kh);
            }
        } catch (Exception e) {
        }

    }

    protected boolean checkForm() {

        if (txtMahd.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ko duoc de trong !");
            txtMahd.requestFocus();
            return false;
        } else {
            String mahd = txtMahd.getText();
            for (HoaDon hd : listHD) {
                if (hd.getMaHD().equals(mahd)) {
                    JOptionPane.showMessageDialog(this, "Ma HD Ko duoc de trong !");
                    txtMahd.requestFocus();
                    return false;
                }
            }
        }

//        if (txtManv.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Ko duoc de trong !");
//            txtManv.requestFocus();
//            return false;
//        } else {
//            String manv = txtMahd.getText();
//            for (HoaDon hd : listHD) {
//                if (hd.getMaHD().equals(manv)) {
//                    JOptionPane.showMessageDialog(this, "Ma NV Ko duoc de trong !");
//                    txtManv.requestFocus();
//                    return false;
//                }
//            }
//        }
        if (txtMaKH.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ko duoc de trong !");
            txtMaKH.requestFocus();
            return false;
        }

        if (txtTenKH.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ko duoc de trong !");
            txtTenKH.requestFocus();
            return false;
        }

        if (txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ko duoc de trong !");
            txtSDT.requestFocus();
            return false;
        }

        if (txtNgayMua.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ko duoc de trong !");
            txtNgayMua.requestFocus();
            return false;
        }

        if (txtDiaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ko duoc de trong !");
            txtDiaChi.requestFocus();
            return false;
        }

        return true;
    }

    protected void insertKH() {

        try {
            String makh = txtMaKH.getText();
            String tenKH = txtTenKH.getText();
            String sdt = txtSDT.getText();
            String diaChi = txtDiaChi.getText();

            ketNoi();
            String sql = "insert into KHACHHANG(MaKH,TenKH,SDT,DChi) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, makh);
            ps.setString(2, tenKH);
            ps.setString(3, sdt);
            ps.setString(4, diaChi);

            KhachHang kh = new KhachHang(makh, tenKH, sdt, diaChi);
            listKH.add(kh);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void insertHD() {

        try {

            String msHD = txtMahd.getText();
            String maKH = txtMaKH.getText();
            String maNV = txtManv.getText();

            String ngayMuaHang = txtNgayMua.getText();
            int tongTien = this.tongTien;
            ketNoi();
            String sql = "insert into HOADON(MaHoaDon,MaKH,MaNV,NgayMuaHang,TongTien)  values (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, msHD);
            ps.setString(2, maKH);
            ps.setString(3, maNV);
            ps.setString(4, ngayMuaHang);
            ps.setInt(5, tongTien);
            ps.execute();

        } catch (Exception e) {
        }

    }

    protected void insertHDCT() {

        for (HoaDonChiTiet hdct : listHDCT) {

            Random rd = new Random();
            int a = 10000 + rd.nextInt(99999);

            //              SanPham sp1 = listSP.get(index);
            String maHDCT = "HD" + a;
            String maHD = txtMahd.getText();
            String maSP = hdct.getMaSP();
            int giaBan = hdct.getGiaBan();
            int soLuong = hdct.getSoLuongDH();
            double giamGia = 0;
            double tongTien = hdct.getTongTien();

            try {
                ketNoi();
                String sql = "insert into HOADONCHITIET(MaHoaDonChiTiet,MaHoaDon,MaSP,GiaBan,SoLuongDH,GiamGia,TongTien) values(?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, maHDCT);
                ps.setString(2, maHD);
                ps.setString(3, maSP);
                ps.setInt(4, giaBan);
                ps.setInt(5, soLuong);
                ps.setDouble(6, giamGia);
                ps.setDouble(7, tongTien);
                ps.execute();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNgayMua = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtManv = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMahd = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        comboDanhSachKH = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListSP = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableListHD = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        lbThanhTien = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Ma KH");

        jLabel2.setText("Tên KH");

        jLabel4.setText("Số Điện Thoại");

        jLabel3.setText("Địa Chỉ");

        jLabel7.setText("Ngày Mua Hàng");

        jLabel5.setText("Số Lượng");

        jLabel6.setText("Mã NV");

        jLabel10.setText("Mã HD");

        btnOK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOK.setForeground(new java.awt.Color(153, 0, 0));
        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/ok.png"))); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane3.setViewportView(txtDiaChi);

        comboDanhSachKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên Khách Hàng" }));
        comboDanhSachKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDanhSachKHActionPerformed(evt);
            }
        });

        jLabel12.setText("KH Quen");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtManv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMahd)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDanhSachKH, 0, 143, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayMua, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOK))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btnOK))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNgayMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtManv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboDanhSachKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableListSP.setBackground(new java.awt.Color(0, 153, 204));
        tableListSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Gía", "Mau"
            }
        ));
        tableListSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableListSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableListSP);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Danh Sách Sản Phẩm");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tạo Hóa Đơn Mới");

        tableListHD.setBackground(new java.awt.Color(255, 255, 51));
        tableListHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Gía", "Số Lượng", "Thành Tiền"
            }
        ));
        tableListHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableListHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableListHD);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Tổng Tiền :");

        lbThanhTien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbThanhTien.setText("0 VND");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/plus.png"))); // NOI18N
        jButton1.setText("Tạo Hóa Đơn Mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(153, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/save (1).png"))); // NOI18N
        jButton5.setText("Lưu Hóa Đơn");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Nhập Tên SP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(26, 26, 26)
                                .addComponent(jButton5)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(319, 319, 319)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton5)
                    .addComponent(jLabel11)
                    .addComponent(lbThanhTien))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        String makh = txtMaKH.getText();
//
//        for (KhachHang kh : listKH) {
//            if (kh.getMaKH().equals(makh)) {
//                System.out.println("ds khachs hangf : " + kh.toString());
//                System.out.println("Makhachs hangf : " + kh.getMaKH());
//                return;
//            }
//        }

        tongTien = 0;
        Random rd = new Random();
        int a = 10000 + rd.nextInt(99999);
        txtMahd.setText("HD_" + a);
        txtMaKH.setText("KH_" + a);

        txtManv.setText(Login.tenDangNhap);
        txtDiaChi.setText("");
        txtNgayMua.setText(String.valueOf(java.time.LocalDate.now()));
        txtSDT.setText("");
        txtTenKH.setText("");
        txtSoLuong.setText("");
        txtMahd.requestFocus();
        model2 = (DefaultTableModel) tableListHD.getModel();
        model2.setRowCount(0);
        lbThanhTien.setText(String.valueOf(tongTien));
        comboDanhSachKH.setSelectedIndex(0);
        txtMaKH.setEnabled(false);
        txtMahd.setEnabled(false);
        txtManv.setEnabled(false);
        txtNgayMua.setEnabled(false);
        listHDCT.removeAll(listHDCT);
        for (HoaDonChiTiet hdct : listHDCT) {
            model2.addRow(new Object[]{hdct.getMaSP(), "", hdct.getGiaBan(), hdct.getSoLuongDH(), hdct.getTongTien()});
        }

        System.out.println(listHDCT.size());


    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableListSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListSPMouseClicked
        index = tableListSP.getSelectedRow();
        if (index == -1) {
            return;
        }

        if (index >= 0) {

            model2 = (DefaultTableModel) tableListHD.getModel();

            SanPham sp1 = listSP.get(index);
            int soLuong = 0;

            model2.addRow(new Object[]{
                sp1.getMaSP(),
                sp1.getTenSP(),
                sp1.getGia(),
                soLuong,
                sp1.thanhTien(soLuong)}
            );

        }
    }//GEN-LAST:event_tableListSPMouseClicked

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        index = tableListSP.getSelectedRow();

        try {

            model2 = (DefaultTableModel) tableListHD.getModel();
            int soLuong = Integer.parseInt(txtSoLuong.getText());

            SanPham sp1 = listSP.get(index);

            model2.setValueAt(sp1.getMaSP(), tableListHD.getSelectedRow(), 0);
            model2.setValueAt(sp1.getTenSP(), tableListHD.getSelectedRow(), 1);
            model2.setValueAt(sp1.getGia(), tableListHD.getSelectedRow(), 2);
            model2.setValueAt(soLuong, tableListHD.getSelectedRow(), 3);
            model2.setValueAt(sp1.thanhTien(soLuong), tableListHD.getSelectedRow(), 4);
//              

            for (int i = 0;; i++) {

                tongTien += sp1.thanhTien(soLuong);
                i++;

                break;
            }
            lbThanhTien.setText(String.valueOf(tongTien) + " VND");

            Random rd = new Random();
            int a = 10000 + rd.nextInt(99999);

            String maHDCT = "HD" + a;
            String mahd = txtMahd.getText();
            String maSP = sp1.getMaSP();
            int gia = sp1.getGia();
            int soLuongDH = soLuong;
            float giamGia = 0;
            double tien = sp1.thanhTien(soLuong);

            HoaDonChiTiet hdct = new HoaDonChiTiet(maHDCT, mahd, maSP, gia, soLuongDH, tien, giamGia);
            listHDCT.add(hdct);

            System.out.println(listHDCT.size());

            for (HoaDonChiTiet hdct1 : listHDCT) {
                System.out.println(hdct1.toString());
            }
            txtSoLuong.setText("");

        } catch (Exception e) {
            e.printStackTrace();

        }

    }//GEN-LAST:event_btnOKActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            String makh = txtMaKH.getText();

            if (checkForm()) {
                System.out.println("Khachs hangf : " + listKH.size());

                System.out.println("Ma KH : " + makh);
                for (KhachHang kh : listKHFindAll) {
                    if (kh.getMaKH().equals(makh)) {

                        System.out.println("DS Khách Hàng :" + kh.getMaKH());
                        insertHD();
                        insertHDCT();
                        JOptionPane.showMessageDialog(this, "Đã Lưu Hóa Đơn !");
                        return;
                    }
                }

                System.out.println("xin chào : ");
                insertKH();
                insertHD();
                insertHDCT();
                JOptionPane.showMessageDialog(this, "Đã Lưu Hóa Đơn !");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tableListHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListHDMouseClicked
        index = tableListHD.getSelectedRow();
        if (index >= 0) {
            txtSoLuong.requestFocus();
        }
    }//GEN-LAST:event_tableListHDMouseClicked

    private void comboDanhSachKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDanhSachKHActionPerformed
        String tenKH = comboDanhSachKH.getSelectedItem().toString();
        for (int i = 0; i < listKH.size(); i++) {
            KhachHang itemKH = listKH.get(i);
            if (itemKH.getTenKH().equals(tenKH)) {
                txtMaKH.setText(itemKH.getMaKH());
                txtTenKH.setText(itemKH.getTenKH());
                txtSDT.setText(itemKH.getSdt());
                txtDiaChi.setText(itemKH.getdChi());
            }
        }
    }//GEN-LAST:event_comboDanhSachKHActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            String timKiem = txtSearch.getText();

            String sql = "select * from SANPHAM where  Delete_at is  null and TenSP like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + timKiem + "%");

            ResultSet rs = ps.executeQuery();
            model1 = (DefaultTableModel) tableListSP.getModel();
            model1.setRowCount(0);
            while (rs.next()) {
                String maSP = rs.getString("MaSP");
                String tenSP = rs.getString("TenSP");
                int gia = rs.getInt("Gia");
                String mau = rs.getString("MauSac");

                model1.addRow(new Object[]{
                    maSP,
                    tenSP,
                    gia,
                    mau});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboDanhSachKH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel lbThanhTien;
    private javax.swing.JTable tableListHD;
    private javax.swing.JTable tableListSP;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMahd;
    public javax.swing.JTextField txtManv;
    private javax.swing.JTextField txtNgayMua;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
