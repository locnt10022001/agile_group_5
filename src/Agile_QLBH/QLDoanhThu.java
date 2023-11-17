package Agile_QLBH;

import Agile_QLBH.Class.HoaDon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ABC
 */
public class QLDoanhThu extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    Connection con;
    List<HoaDon> listHD = new ArrayList<>();

    public QLDoanhThu() {
        initComponents();
        setLocation(170, 30);
        ketNoi();
        listHD = fetchList();
        renderJTable();
        System.out.println(listHD.size());
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

    private ArrayList<HoaDon> fetchList() {
        ArrayList<HoaDon> result = new ArrayList<>();
        String query = "select * from HOADON";
        try {

            PreparedStatement ps = this.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String MaHD = rs.getString("MaHoaDon");
//                String TenSP = rs.getString("TenSP");
                String MaKH = rs.getString("MaKH");
                String MaNV = rs.getString("MaNV");
                Date ngay = rs.getDate("NgayMuaHang");
                int tongtien = rs.getInt("TongTien");
                String delete_at = rs.getString("Delete_at");
                String delete_User = rs.getString("Delete_Uuer");
                HoaDon hd = new HoaDon(MaHD, MaKH, MaNV, tongtien, ngay, delete_at, delete_User);
                result.add(hd);

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return result;

    }

    private void renderJTable() {
        model = (DefaultTableModel) this.tbldt.getModel();
        model.setRowCount(0);
        for (HoaDon hd : listHD) {

            model.addRow(new Object[]{
                hd.maHD, hd.getMaKH(), hd.getMaNV(), hd.getNgayMua(), hd.getTongTien()
            });
        }

    }

    private void tinhtien() {
        int sum = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            sum += (int) model.getValueAt(i, 4);
        }
        txttien.setText(sum + "  VNĐ");
    }

//    private void timkiem() {
//
//        try {
//            String ten = txtten.getText();
//            String query = "select * from HOADON where TenSP like '%" + ten + "%'";
//            PreparedStatement ps = this.con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//            model.setRowCount(0);
//            while (rs.next()) {
//                String MaHD = rs.getString("MaHoaDon");
//                String TenSP = rs.getString("TenSP");
//                String MaKH = rs.getString("MaKH");
//                String MaNV = rs.getString("MaNV");
//                Date ngay = rs.getDate("NgayMuaHang");
//                int tongtien = rs.getInt("TongTien");
//
//                model.addRow(new Object[]{TenSP, MaKH, MaNV, ngay, tongtien});
//            }
//            tinhtien();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btntim = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txttien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldt = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("TỔNG DOANH THU");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Từ Ngày");

        jLabel3.setText("Đến Ngày");

        btntim.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btntim.setForeground(new java.awt.Color(153, 0, 0));
        btntim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/search.png"))); // NOI18N
        btntim.setText("Tìm");
        btntim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 355, Short.MAX_VALUE)
                .addComponent(btntim, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btntim, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tổng Doanh Thu :");

        txttien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txttien.setText("0 VND");

        tbldt.setBackground(new java.awt.Color(255, 255, 51));
        tbldt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Mã Khách Hàng", "Mã Nhân Viên", "Thời Gian Giao  Dich", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbldt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txttien, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txttien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimActionPerformed
//        try {
//            Date date, date1;
//
//            date = cbotungay.getDate();
//            if (date == null) {
//
//                JOptionPane.showMessageDialog(null, "vui lòng chọn ngày bắt đầu", "Error", JOptionPane.ERROR_MESSAGE);
//                cbotungay.grabFocus();
//
//                return;
//            }
//
//            date1 = cbodenngay.getDate();
//
//            if (date1 == null) {
//                JOptionPane.showMessageDialog(null, "vui lòng chọn ngày đến", "Error", JOptionPane.ERROR_MESSAGE);
//                cbodenngay.grabFocus();
//
//                return;
//            }
//            Date ngayBatDau = new java.sql.Date(date.getTime());
//            Date ngayketThuc = new java.sql.Date(date1.getTime());
//            // Chỗ này coi như em tự query đc data theo ngày tháng
//            String query = "SELECT * FROM HOADON WHERE NgayMuaHang BETWEEN ? AND ?";
//            PreparedStatement ps = this.con.prepareStatement(query);
//            ps.setDate(1, new java.sql.Date(ngayBatDau.getTime()));
//            ps.setDate(2, new java.sql.Date(ngayketThuc.getTime()));
//            ps.execute();
//
//            ResultSet res = ps.getResultSet();
//            model.setRowCount(0);
//            while (res.next()) {
//                String MaHD = res.getString("MaHoaDon");
//                String MaKH = res.getString("MaKH");
//                String MaNV = res.getString("MaNV");
//                Date ngay = res.getDate("NgayMuaHang");
//                int tongtien = res.getInt("TongTien");
//
//                model.addRow(new Object[]{MaHD, MaKH, MaNV, ngay, tongtien});
//
//            }
//
//            tinhtien();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_btntimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btntim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbldt;
    private javax.swing.JTextField txttien;
    // End of variables declaration//GEN-END:variables
}
