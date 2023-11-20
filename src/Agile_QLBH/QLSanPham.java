/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agile_QLBH;

import Agile_QLBH.Class.HoaDon;
import Agile_QLBH.Class.HoaDonChiTietSelect;
import Agile_QLBH.Class.SanPham;
import Agile_QLBH.Class.SanPhamModify;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ABC
 */
public class QLSanPham extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    List<SanPham> listSP = new ArrayList<>();
    List<HoaDonChiTietSelect> lishdct = new ArrayList<>();
    List<HoaDon> lishd = new ArrayList<>();
    List<SanPham> listSPFillAll = new ArrayList<>();
    int index;
    Connection con;

    public QLSanPham() {
        initComponents();
        setLocation(30, 5);
        ketNoi();

        System.out.println("siz hdct : " + lishdct.size());
        System.out.println("siz hd : " + lishd.size());
        model = (DefaultTableModel) tableList.getModel();
        fillToTable();
        txtMaSP.setEnabled(false);
        fillALLSP();
        System.out.println("san pham all : " + listSPFillAll.size());
//        lbcount.setText("Record : " + listSP.size());
        Random rd = new Random();
        int a = 10000 + rd.nextInt(99999);
        txtMaSP.setText("SP_" + a);
        System.out.println("hihiihihihihi");

    }

    protected void fillALLSP() {
        try {
            String sql = "select * from SANPHAM";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String masp = rs.getString("MaSP");
                SanPham sp = new SanPham(masp);
                listSPFillAll.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillToTable() {
        listSP = SanPhamModify.findAll();
        model.setRowCount(0);

        for (SanPham sp : listSP) {
            model.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getSoLuong(),
                sp.getGia(), sp.getMauSac(), sp.getManHinh(), sp.getCamera(), sp.getKetNoi(),
                sp.getTienIch(), sp.getDungLuongPin()});
        }
    }

    private boolean checkForm() {

        if (txtMaSP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã SP Ko Dể Trống !");
            txtMaSP.requestFocus();
            return false;
        } else {
            String checkTrung = txtMaSP.getText();
            for (int i = 0; i < listSPFillAll.size(); i++) {
                if (listSPFillAll.get(i).getMaSP().equals(checkTrung)) {
                    JOptionPane.showMessageDialog(this, "Mã Sản Phẩm Đã Tồn Tại  !");
                    txtMaSP.requestFocus();
                    txtMaSP.setText("");
                    return false;

                }
            }
        }

        if (txtTenSP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên SP Ko Dể Trống !");
            txtTenSP.requestFocus();
            return false;
        }

        if (txtSoLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Số Lượng SP Ko Dể Trống !");
            txtSoLuong.requestFocus();
            return false;
        } else {
            try {
                int so = Integer.parseInt(txtSoLuong.getText());
                if (so < 0) {
                    JOptionPane.showMessageDialog(this, "Số Lượng SP Phải Lớn Hơn 0 !");
                    txtSoLuong.requestFocus();
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Số Lượng SP Phải Là Số !");
                txtSoLuong.requestFocus();
                return false;
            }
        }

        if (txtGia.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Gía SP Ko Dể Trống !");
            txtGia.requestFocus();
            return false;
        } else {
            try {
                int so = Integer.parseInt(txtGia.getText());
                if (so < 0) {
                    JOptionPane.showMessageDialog(this, "Gía SP Phải Lớn Hơn 0 !");
                    txtGia.requestFocus();
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gía SP Phải Là Số !");
                txtGia.requestFocus();
                return false;
            }
        }

        if (txtManHinh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Màn Hình SP Ko Dể Trống !");
            txtManHinh.requestFocus();
            return false;
        }

        if (txtCamera.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Camera SP Ko Dể Trống !");
            txtCamera.requestFocus();
            return false;
        }

        if (txtKetNoi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Kết Nốt  Ko Dể Trống !");
            txtKetNoi.requestFocus();
            return false;
        }

        if (txtTienIch.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tiện ích  SP Ko Dể Trống !");
            txtTienIch.requestFocus();
            return false;
        }

        if (txtDungLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Dung Luong Pin SP Ko Dể Trống !");
            txtDungLuong.requestFocus();
            return false;
        }

        return true;
    }

    private boolean checkForm11() {

        if (txtMaSP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã SP Ko Dể Trống !");
            txtMaSP.requestFocus();
            return false;
        }

        if (txtTenSP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên SP Ko Dể Trống !");
            txtTenSP.requestFocus();
            return false;
        }

        if (txtSoLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Số Lượng SP Ko Dể Trống !");
            txtSoLuong.requestFocus();
            return false;
        } else {
            try {
                int so = Integer.parseInt(txtSoLuong.getText());
                if (so < 0) {
                    JOptionPane.showMessageDialog(this, "Số Lượng SP Phải Lớn Hơn 0 !");
                    txtSoLuong.requestFocus();
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Số Lượng SP Phải Là Số !");
                txtSoLuong.requestFocus();
                return false;
            }
        }

        if (txtGia.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Gía SP Ko Dể Trống !");
            txtGia.requestFocus();
            return false;
        } else {
            try {
                int so = Integer.parseInt(txtGia.getText());
                if (so < 0) {
                    JOptionPane.showMessageDialog(this, "Gía SP Phải Lớn Hơn 0 !");
                    txtGia.requestFocus();
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gía SP Phải Là Số !");
                txtGia.requestFocus();
                return false;
            }
        }

        if (txtManHinh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Màn Hình SP Ko Dể Trống !");
            txtManHinh.requestFocus();
            return false;
        }

        if (txtCamera.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Camera SP Ko Dể Trống !");
            txtCamera.requestFocus();
            return false;
        }

        if (txtKetNoi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Kết Nốt  Ko Dể Trống !");
            txtKetNoi.requestFocus();
            return false;
        }

        if (txtTienIch.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tiện ích  SP Ko Dể Trống !");
            txtTienIch.requestFocus();
            return false;
        }

        if (txtDungLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Dung Luong Pin SP Ko Dể Trống !");
            txtDungLuong.requestFocus();
            return false;
        }

        return true;
    }

    private void showDetail() {
        SanPham sp = listSP.get(index);

        txtMaSP.setText(sp.getMaSP());
        txtTenSP.setText(sp.getTenSP());
        txtSoLuong.setText(String.valueOf(sp.getSoLuong()));
        txtGia.setText(String.valueOf(sp.getGia()));
        txtManHinh.setText(sp.getManHinh());
        comboMau.setSelectedItem(sp.getMauSac());
        txtCamera.setText(sp.getCamera());
        txtTienIch.setText(sp.getTienIch());
        txtKetNoi.setText(sp.getKetNoi());
        txtDungLuong.setText(sp.getDungLuongPin());
//        lbcount.setText("Record : " + (index + 1) + "/" + listSP.size());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtManHinh = new javax.swing.JTextField();
        comboMau = new javax.swing.JComboBox<>();
        txtCamera = new javax.swing.JTextField();
        txtDungLuong = new javax.swing.JTextField();
        txtKetNoi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTienIch = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        btnSua = new javax.swing.JButton();
        btnTaoMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableList = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Quản Lý Sản Phẩm");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Mã SP");

        jLabel3.setText("Tên SP");

        jLabel4.setText("Số Lượng");

        jLabel5.setText("Gía");

        jLabel6.setText("Màu Sắc");

        jLabel7.setText("Màn Hình");

        jLabel8.setText("Camera");

        jLabel9.setText("Kết Nối");

        jLabel10.setText("Dung Lượng Pin");

        jLabel11.setText("Tiện ích");

        comboMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xám", "Xanh Lá", "Vàng Đồng", "Bạc", "Đen", "Trắng", "Đỏ", "Vàng", "Hồng" }));

        txtTienIch.setColumns(20);
        txtTienIch.setRows(5);
        jScrollPane2.setViewportView(txtTienIch);

        jPanel6.setBackground(new java.awt.Color(255, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(153, 0, 0));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/save (1).png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnTaoMoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTaoMoi.setForeground(new java.awt.Color(153, 0, 0));
        btnTaoMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/clear.png"))); // NOI18N
        btnTaoMoi.setText("Tạo Mới");
        btnTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(153, 0, 0));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/plus.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(153, 0, 0));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTaoMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnTaoMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(50, 50, 50))
        );

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Nhập Mã Sản Phẩm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(txtKetNoi, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(comboMau, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDungLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKetNoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDungLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel11)
                                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(comboMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Quản Lý Sản Phẩm");

        tableList.setBackground(new java.awt.Color(255, 255, 153));
        tableList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Số Lượng", "Giá", "Màu Sắc", "Màn Hình", "Camera", "Kết Nối", "Tiện ích", "Dung Lượng Pin"
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 424, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(391, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListMouseClicked
        index = tableList.getSelectedRow();
        if (index >= 0) {
            showDetail();
        }
    }//GEN-LAST:event_tableListMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        index = tableList.getSelectedRow();
        if (checkForm11()) {

            SanPham sp = listSP.get(index);
            String maSP = sp.getMaSP();

            String tensp = txtTenSP.getText();
            int soluong = Integer.parseInt(txtSoLuong.getText());
            int gia = Integer.parseInt(txtGia.getText());
            String manhinh = txtManHinh.getText();
            String ketnoi = txtKetNoi.getText();
            String tienich = txtTienIch.getText();
            String dungluong = txtDungLuong.getText();
            String camera = txtCamera.getText();
            String mausac = (String) comboMau.getSelectedItem();

            String sql = "update SANPHAM set TenSP =?, SoLuong =?,Gia=?,MauSac =?, ManHinh=?,Camera=?,KetNoi=?,TienIch=?,DungLuongPin=? where MaSP =?";

            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, tensp);
                ps.setInt(2, soluong);
                ps.setInt(3, gia);
                ps.setString(4, mausac);
                ps.setString(5, manhinh);
                ps.setString(6, camera);
                ps.setString(7, ketnoi);
                ps.setString(8, tienich);
                ps.setString(9, dungluong);
                ps.setString(10, maSP);
                ps.execute();
                fillToTable();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiActionPerformed
        clearForm();
    }//GEN-LAST:event_btnTaoMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        txtMaSP.setEnabled(true);
        if (checkForm()) {

            String masp = txtMaSP.getText();
            String tensp = txtTenSP.getText();
            int soluong = Integer.parseInt(txtSoLuong.getText());
            int gia = Integer.parseInt(txtGia.getText());
            String manhinh = txtManHinh.getText();
            String ketnoi = txtKetNoi.getText();
            String tienich = txtTienIch.getText();
            String dungluong = txtDungLuong.getText();
            String camera = txtCamera.getText();
            String mausac = (String) comboMau.getSelectedItem();

            SanPham sp = new SanPham(masp, tensp, soluong, gia, mausac, manhinh, camera,
                    ketnoi, tienich, dungluong);
            SanPhamModify.insert(sp);
            fillToTable();
//            lbcount.setText("Record : " + listSP.size());
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        index = tableList.getSelectedRow();
        if (index == -1) {
            return;
        }
        if (index >= 0) {

            try {

                SanPham sp = listSP.get(index);
                String masp = sp.getMaSP();
                String delete_at = String.valueOf(java.time.LocalDate.now() + " " + java.time.LocalTime.now());
                String delete_User = Login.tenDangNhap;

                int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sản phẩm này không ?");
                if (chon == JOptionPane.YES_OPTION) {

                    String sql = "update SANPHAM set Delete_at=?,Delete_Uuer=? where MaSP =?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, delete_at);
                    ps.setString(2, delete_User);
                    ps.setString(3, masp);
                    ps.execute();
                    JOptionPane.showMessageDialog(this, "Xóa Thành Công !");
                    fillToTable();
                    checkForm();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            String searchMaSP = txtSearch.getText();

            for (int i = 0; i < listSP.size(); i++) {
                if (listSP.get(i).getMaSP().equalsIgnoreCase(searchMaSP)) {
                    index = i;
                    showDetail();
                    tableList.setRowSelectionInterval(index, index);
                    return;
                }
            }
            clearForm();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtSearchKeyReleased
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

    private void clearForm() {
        Random rd = new Random();
        int a = 10000 + rd.nextInt(99999);
        txtMaSP.setText("SP_" + a);
        txtTenSP.setText("");
        txtSoLuong.setText("");
        txtCamera.setText("");
        txtGia.setText("");
        txtKetNoi.setText("");
        txtManHinh.setText("");
        txtTienIch.setText("");
        comboMau.setSelectedIndex(0);
        txtDungLuong.setText("");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaoMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> comboMau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableList;
    private javax.swing.JTextField txtCamera;
    private javax.swing.JTextField txtDungLuong;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtKetNoi;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtManHinh;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextArea txtTienIch;
    // End of variables declaration//GEN-END:variables
}
