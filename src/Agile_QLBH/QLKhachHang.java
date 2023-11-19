/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agile_QLBH;

import Agile_QLBH.Class.HoaDon;
import Agile_QLBH.Class.KhachHang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QLKhachHang extends javax.swing.JInternalFrame {

    Connection con;
    protected List<KhachHang> listKH = new ArrayList<>();
    List<HoaDon> lishd = new ArrayList<>();
    protected DefaultTableModel model;
    int index;

    public QLKhachHang() {
        initComponents();
        setLocation(165, 30);
        System.out.println("hello");
        ketNoi();
        System.out.println("Hoa Don " + lishd.size());

        model = (DefaultTableModel) tableList.getModel();
        fillTotable();

        System.out.println("Khachs Hanh " + listKH.size());

        String delete_at = String.valueOf(java.time.LocalDate.now());
        String manv = Login.tenDangNhap;

        System.out.println("Ngay h " + delete_at);
        System.out.println("Ma NV  " + manv);

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
                        rs.getDate("NgayMuaHang"));

                listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listKH;
    }
    private boolean checkFrom() {
        if (txtMaKH.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã Khách Hàng Ko để Trống !");
            txtMaKH.requestFocus();
            return false;
        } else {
            String checkMakh = txtMaKH.getText();
            for (int i = 0; i < listKH.size(); i++) {
                if (listKH.get(i).getMaKH().equals(checkMakh)) {
                    JOptionPane.showMessageDialog(this, "Ma KH ko duoc trung !");
                    txtMaKH.requestFocus();
                    txtMaKH.setText("");
                    return false;
                }
            }
        }

        if (txtTenKH.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên Khách Hàng Ko để Trống !");
            txtTenKH.requestFocus();
            return false;
        }

        if (txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SĐT Ko để Trống !");
            txtSDT.requestFocus();
            return false;
        } else {
            String checkSDT = "0\\d{9}";
            if (!txtSDT.getText().matches(checkSDT)) {
                JOptionPane.showMessageDialog(this, "Số Điện phải bắt đầu bằng số 0 && có 10 số! VD : 0923456789");
                txtSDT.requestFocus();
                return false;
            }
        }
//
//       

        if (txtDiaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Địa Chỉ ko de trong !");
            txtDiaChi.requestFocus();
            return false;
        }

        return true;
    }

    private boolean checkFrom11() {
        if (txtMaKH.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã Khách Hàng Ko để Trống !");
            txtMaKH.requestFocus();
            return false;
        }

        if (txtTenKH.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên Khách Hàng Ko để Trống !");
            txtTenKH.requestFocus();
            return false;
        }

        if (txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SĐT Ko để Trống !");
            txtSDT.requestFocus();
            return false;
        } else {
            String checkSDT = "0\\d{9}";
            if (!txtSDT.getText().matches(checkSDT)) {
                JOptionPane.showMessageDialog(this, "Số Điện phải bắt đầu bằng số 0 && có 10 số! VD : 0923456789");
                txtSDT.requestFocus();
                return false;
            }
        }

//        
        if (txtDiaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Địa Chỉ ko de trong !");
            txtDiaChi.requestFocus();
            return false;
        }

        return true;
    }

    private List<KhachHang> fillAll() {
        List<KhachHang> listKH = new ArrayList<>();
        try {

            String sql = "select * from KHACHHANG where Delete_at is null ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                KhachHang kh = new KhachHang(
                        rs.getString("MaKH"),
                        rs.getString("TenKH"),
                        rs.getString("SDT"),
                        rs.getString("DChi"),
                        rs.getString("Delete_at"),
                        rs.getString("Delete_Uuer")
                );
                listKH.add(kh);
            }
        } catch (Exception e) {
        }

        return listKH;
    }

    protected void fillTotable() {
        listKH = fillAll();
        model.setRowCount(0);

        for (KhachHang sk : listKH) {
            model.addRow(new Object[]{model.getRowCount() + 1,
                sk.getMaKH(),
                sk.getTenKH(),
                sk.getSdt(),
                sk.getdChi()
            });
        }
    }

    private void showDetail() {
        KhachHang kh = listKH.get(index);
        System.out.println("List kh showDEtail : "+listKH.size());
        txtMaKH.setText(kh.getMaKH());
        txtTenKH.setText(kh.getTenKH());
        txtDiaChi.setText(kh.getdChi());

        txtSDT.setText(kh.getSdt());

    }

    protected void clearForm() {
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtDiaChi.setText("");

        txtSDT.setText("");
    }

//
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableList = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Danh Sách Khách Hàng");

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Danh Sách Khách Hàng");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane2.setViewportView(txtDiaChi);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel4.setText("Nhập Tên");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/search.png"))); // NOI18N
        jLabel7.setText("Tìm Kiếm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(153, 0, 0));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/save (1).png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(153, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/delete.png"))); // NOI18N
        jButton3.setText("Xóa ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnUpdate)
                .addGap(27, 27, 27)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Mã Khách Hàng");

        jLabel3.setText("Tên Khách Hàng");

        jLabel5.setText("Số Điện Thoại");

        jLabel6.setText("Số Điện Thoại");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(48, 48, 48)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tableList.setBackground(new java.awt.Color(255, 255, 153));
        tableList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã KH", "Tên KH", "Số Điện Thoại", "Số Điện Thoại"
            }
        ));
        tableList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        index = tableList.getSelectedRow();
        if (index == -1) {
            return;
        }
        if (index >= 0) {
            if (checkFrom11()) {
                try {
                    KhachHang kh = listKH.get(index);
                    String makh = kh.getMaKH();

                    String teKH = txtTenKH.getText();
                    String sdt = txtSDT.getText();

                    String diaChi = txtDiaChi.getText();

                    String sql = "update KHACHHANG set TenKH=?,SDT=?,DChi=? where MaKH =?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, teKH);
                    ps.setString(2, sdt);
                    ps.setString(3, diaChi);
                    ps.setString(4, makh);
                    ps.execute();
                    fillTotable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        index = tableList.getSelectedRow();
        try {

            KhachHang kh = listKH.get(index);
            String makh = kh.getMaKH();

            String delete_at = String.valueOf(java.time.LocalDate.now() + " " + java.time.LocalTime.now());
            String manv = Login.tenDangNhap;

            int chon = JOptionPane.showConfirmDialog(this, "Ban co muon xoa ko ?");
            if (chon == JOptionPane.YES_OPTION) {

                String sql = "update KHACHHANG set Delete_at = ?,Delete_Uuer =? where MaKH =?";

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, delete_at);
                ps.setString(2, manv);
                ps.setString(3, makh);
                ps.execute();

                JOptionPane.showMessageDialog(this, "Xóa Thành Công !");

                fillTotable();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tableListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListMouseClicked
        index = tableList.getSelectedRow();
        if (index >= 0) {
            showDetail();
        }
    }//GEN-LAST:event_tableListMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            String tenKH = txtSearch.getText();
            int index;
            for (int i = 0; i < listKH.size(); i++) {
                if (listKH.get(i).getTenKH().equalsIgnoreCase(tenKH)) {
                    index = i;
                    showDetail();
                    tableList.setRowSelectionInterval(index, index);
                    return;
                }
            }
            clearForm();
            String sql = "select * from KHACHHANG  where Delete_at is null and TenKH like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + tenKH + "%");

            ResultSet rs = ps.executeQuery();
            model.setRowCount(0);
            listKH.clear();
            while (rs.next()) {
                String maKH = rs.getString("MaKH");
                String tenKHang = rs.getString("TenKH");
                String sdt = rs.getString("SDT");
                String dChi = rs.getString("DChi");
                String delete_at = rs.getString("Delete_at");
                String delete_user = rs.getString("Delete_Uuer");

                KhachHang kh = new KhachHang(maKH, tenKHang, sdt, dChi, delete_at, delete_user);
                listKH.add(kh);
                System.out.println("list KH : " + listKH.size());
                model.addRow(new Object[]{model.getRowCount() + 1,
                    maKH,
                    tenKHang,
                    sdt,
                    dChi
                });

            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    protected javax.swing.JTable tableList;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
