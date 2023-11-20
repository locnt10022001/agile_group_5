package Agile_QLBH;

import Agile_QLBH.Class.HoaDon;
import Agile_QLBH.Class.HoaDonChiTietSelect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QLDonHang extends javax.swing.JInternalFrame {

    List<HoaDon> lishd = new ArrayList<>();
    List<HoaDonChiTietSelect> lishdct = new ArrayList<>();
    int index;
    DefaultTableModel model1;
    DefaultTableModel model2;
    Connection con;

    public QLDonHang() {
        initComponents();
        setLocation(10, 10);
        ketNoi();

        lishd = fillAllHD();
        lishdct = fillAllHDCT();
        fillAllHD();

        System.out.println(lishd.size());
        System.out.println(lishdct.size());
        fillToTableHD();

    }

   public void ketNoi() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost\\DESKTOP-RPK6PAD\\SQLEXPRESS:1433;databaseName=QLBH102",
                    "sa", "123");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Ko tim thay driver tuong thich !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ko tim thay driver tuong thich !");
        }

    }

    private List<HoaDon> fillAllHD() {
        List<HoaDon> listKH = new ArrayList<>();
        try {

            String sql = "select *from HOADON where Delete_at is null ";
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

    private List<HoaDonChiTietSelect> fillAllHDCT() {
        List<HoaDonChiTietSelect> listKH = new ArrayList<>();
        try {

            String sql = "select * from HOADONCHITIET";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                HoaDonChiTietSelect kh = new HoaDonChiTietSelect(
                        rs.getString("MaHoaDonChiTiet"),
                        rs.getString("MaHoaDon"),
                        rs.getString("MaSP"),
                        rs.getInt("GiaBan"),
                        rs.getInt("SoLuongDH"),
                        rs.getInt("TongTien"));

                listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listKH;
    }

    protected void fillToTableHD() {
        model1 = (DefaultTableModel) tablistHD.getModel();
        lishd = fillAllHD();
        model1.setRowCount(0);
        for (HoaDon hd : lishd) {
            model1.addRow(new Object[]{
                hd.getMaHD(),
                hd.getMaKH(),
                hd.getMaNV(),
                hd.getNgayMua(),
                hd.getTongTien()});
        }
    }

    protected void fillToTableHDCT() {
        model2 = (DefaultTableModel) tableListHDCT.getModel();
        lishdct = fillAllHDCT();
        model2.setRowCount(0);
        for (HoaDonChiTietSelect hd : lishdct) {
            model2.addRow(new Object[]{
                hd.getMaHDCT(),
                hd.getMaHD(),
                hd.getMaSP(),
                hd.getGiaBan(),
                hd.getSoLuongDH(),
                hd.getTongTien()});
        }
    }

    protected void showDetail() {
        HoaDon hoaDon = lishd.get(index);
        txtMaHD.setText(hoaDon.getMaHD());
        txtMaKH.setText(hoaDon.getMaKH());
        txtMaNV.setText(hoaDon.getMaNV());
        txtTongTien.setText(String.valueOf(hoaDon.getTongTien()));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = hoaDon.getNgayMua();

        txtNgayMua.setText(sdf.format(d));

    }

    protected void clearform() {
        txtMaHD.setText("");
        txtMaKH.setText("");
        txtMaNV.setText("");
        txtTongTien.setText("");
        txtNgayMua.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        txtSearchMaHD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNgayMua = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListHDCT = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablistHD = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jSeparator1.setBackground(new java.awt.Color(102, 0, 102));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        jLabel14.setText("Hóa Đơn");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("Hóa Đơn Chi Tiết");

        jPanel15.setBackground(new java.awt.Color(204, 255, 204));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel36.setText("Mã Hóa Đơn");

        jLabel37.setText("Mã Khách Hàng");

        jLabel38.setText("Mã Nhân Viên");

        jLabel39.setText("Ngày Mua Hàng");

        jLabel40.setText("Tổng Tiền");

        jPanel14.setBackground(new java.awt.Color(153, 204, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        jLabel41.setText("Ma HD");

        txtSearchMaHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchMaHDKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/search.png"))); // NOI18N
        jLabel7.setText("Tìm Kiếm");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearchMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtSearchMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(txtNgayMua)
                                .addGap(2, 2, 2))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(67, 67, 67))
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(50, 50, 50)))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)))
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtNgayMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );

        tableListHDCT.setBackground(new java.awt.Color(153, 153, 0));
        tableListHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma HDCT", "Ma HD", "Ma SP", "Gía Bán", "So Lượng ", "Tổng Tiền"
            }
        ));
        jScrollPane1.setViewportView(tableListHDCT);

        tablistHD.setBackground(new java.awt.Color(255, 255, 51));
        tablistHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma HD", "Ma KH", "Ma NV", "Ngay Mua Hang", "Tong Tien"
            }
        ));
        tablistHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablistHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablistHD);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablistHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablistHDMouseClicked
        index = tablistHD.getSelectedRow();
        if (index >= 0) {
            showDetail();
        }

        try {

            HoaDon hoaDon = lishd.get(index);
            String maHD = hoaDon.getMaHD();

            String sql = "select * from HOADONCHITIET where MaHoaDon = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maHD);
            ResultSet rs = ps.executeQuery();
            model2 = (DefaultTableModel) tableListHDCT.getModel();
            model2.setRowCount(0);
            lishdct.clear();
            while (rs.next()) {

                String mahdct = rs.getString("MaHoaDonChiTiet");
                String mahd = rs.getString("MaHoaDon");
                String maSP = rs.getString("MaSP");
                int gia = rs.getInt("GiaBan");
                int soLuongDH = rs.getInt("SoLuongDH");
                int tongTien = rs.getInt("TongTien");

                HoaDonChiTietSelect hdct = new HoaDonChiTietSelect(mahdct, mahd, maSP, gia, soLuongDH, tongTien);
                lishdct.add(hdct);

                model2.addRow(new Object[]{
                    mahdct,
                    maHD,
                    maSP,
                    gia,
                    soLuongDH,
                    tongTien
                });

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tablistHDMouseClicked

    private void txtSearchMaHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchMaHDKeyReleased

        try {
            String maHoaDon = txtSearchMaHD.getText();
            int indexs = 0;
            for (int i = 0; i < lishd.size(); i++) {
                if (lishd.get(i).getMaHD().equalsIgnoreCase(maHoaDon)) {
                    indexs = i;
                    showDetail();
                    tablistHD.setRowSelectionInterval(indexs, indexs);
                    System.out.println("chayj vao day !");

                    return;
                }
            }
            clearform();
            try {
                String sql = "select *from HOADON where MaHoaDon like ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, "%" + maHoaDon + "%");
                ResultSet rs = ps.executeQuery();
                model1 = (DefaultTableModel) tablistHD.getModel();
                model1.setRowCount(0);
                lishd.clear();

                while (rs.next()) {

                    String mahd = rs.getString("MaHoaDon");
                    String makh = rs.getString("MaKH");
                    String manv = rs.getString("MaNV");
                    int tien = rs.getInt("TongTien");
                    Date ngayMua = rs.getDate("NgayMuaHang");
                    String delete_at = rs.getString("Delete_at");
                    String delete_user = rs.getString("Delete_Uuer");

                    HoaDon kh = new HoaDon(mahd, makh, manv, tien, ngayMua, delete_at, delete_user);
                    lishd.add(kh);
                    model1.addRow(new Object[]{
                        mahd,
                        makh,
                        manv,
                        ngayMua,
                        tien});

                    System.out.println("chayj vao day select HD !");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            try {

                String sql = "select * from HOADONCHITIET where MaHoaDon like ? ";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, "%" + maHoaDon + "%");
                ResultSet rs = ps.executeQuery();
                model2 = (DefaultTableModel) tableListHDCT.getModel();
                model2.setRowCount(0);
                lishdct.clear();
                while (rs.next()) {

                    String mahdct = rs.getString("MaHoaDonChiTiet");
                    String mahd = rs.getString("MaHoaDon");
                    String maSP = rs.getString("MaSP");
                    int gia = rs.getInt("GiaBan");
                    int soLuongDH = rs.getInt("SoLuongDH");
                    int tongTien = rs.getInt("TongTien");

                    HoaDonChiTietSelect hdct = new HoaDonChiTietSelect(mahdct, mahd, maSP, gia, soLuongDH, tongTien);
                    lishdct.add(hdct);

                    model2.addRow(new Object[]{
                        mahdct,
                        mahd,
                        maSP,
                        gia,
                        soLuongDH,
                        tongTien
                    });
                    System.out.println("chayj vao day select HDCT !");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
//         JOptionPane.showMessageDialog(this, "Không Tìm Thấy Ma HD : " + maHoaDon);
    }//GEN-LAST:event_txtSearchMaHDKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableListHDCT;
    private javax.swing.JTable tablistHD;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgayMua;
    private javax.swing.JTextField txtSearchMaHD;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
