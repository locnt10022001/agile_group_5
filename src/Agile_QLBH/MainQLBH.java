package Agile_QLBH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class MainQLBH extends javax.swing.JFrame implements Runnable {

    private Thread thread;

    public MainQLBH() {
        initComponents();
        setLocationRelativeTo(null);

        lblSoftwareName.setForeground(Color.GREEN);
        lbRunTiem.setForeground(Color.GREEN);
        setLocationRelativeTo(null);
        menuQuanLys.setEnabled(false);
        menuKhachHang.setEnabled(false);
        menuDoanhThu.setEnabled(false);
        menuThungRac.setEnabled(false);

        System.out.println("------- " + java.time.LocalDate.now() + " " + java.time.LocalTime.now());
        System.out.println("Ngay va gio : " + java.time.LocalDateTime.now());
        Start();
        System.out.println("kết nối thành công");
    }

    private void Start() {
        try {
            if (thread == null) {
                thread = new Thread(this);
                thread.start();
            }
        } catch (Exception e) {
        }

    }

    private void Update() {
        lbRunTiem.setForeground(Color.GREEN);
        lbRunTiem.setLocation(lbRunTiem.getX() - 1, lbRunTiem.getY());
        if (lbRunTiem.getX() + lbRunTiem.getWidth() < 0) {
            lbRunTiem.setLocation(this.getWidth(), lbRunTiem.getY());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deskTop = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("src/Imge/Tổng-hợp-các-hình-ảnh-background-đẹp-nhất-51.jpg");
            public void paintComponent(Graphics g){

                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, this);
                setOpaque(false);
                super.paintComponent(g);
            }};
            lblSoftwareName = new javax.swing.JLabel();
            lbRunTiem = new javax.swing.JLabel();
            jPanel2 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jPanel3 = new javax.swing.JPanel();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            jLabel7 = new javax.swing.JLabel();
            jLabel8 = new javax.swing.JLabel();
            jPanel4 = new javax.swing.JPanel();
            jLabel9 = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();
            jLabel11 = new javax.swing.JLabel();
            jLabel12 = new javax.swing.JLabel();
            jLabel13 = new javax.swing.JLabel();
            jLabel14 = new javax.swing.JLabel();
            jPanel5 = new javax.swing.JPanel();
            jLabel15 = new javax.swing.JLabel();
            jLabel16 = new javax.swing.JLabel();
            jLabel17 = new javax.swing.JLabel();
            jLabel18 = new javax.swing.JLabel();
            jLabel19 = new javax.swing.JLabel();
            jLabel20 = new javax.swing.JLabel();
            jLabel21 = new javax.swing.JLabel();
            jLabel22 = new javax.swing.JLabel();
            jSeparator1 = new javax.swing.JSeparator();
            jSeparator2 = new javax.swing.JSeparator();
            jMenuBar1 = new javax.swing.JMenuBar();
            menuTrangChu = new javax.swing.JMenu();
            menuThoat = new javax.swing.JMenu();
            menuDangNhapHT = new javax.swing.JMenuItem();
            menuDangKyHT = new javax.swing.JMenuItem();
            menuThoatHT = new javax.swing.JMenuItem();
            menuQuanLys = new javax.swing.JMenu();
            menuSanPham = new javax.swing.JMenuItem();
            menuBanHang = new javax.swing.JMenuItem();
            menuDonHang = new javax.swing.JMenuItem();
            menuDoanhThu = new javax.swing.JMenuItem();
            menuThungRac = new javax.swing.JMenuItem();
            menuKhachHang = new javax.swing.JMenu();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jPanel1.setForeground(new java.awt.Color(153, 0, 0));

            lblSoftwareName.setFont(new java.awt.Font("Times New Roman", 1, 38)); // NOI18N
            lblSoftwareName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblSoftwareName.setText("Phần Mềm Quản Lý Của Hàng Bán Điện Thoại");

            lbRunTiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
            lbRunTiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbRunTiem.setText("Cửa Hàng Số 1 Thế Giới : Đường 29 Hàm Nghi - Q. 5 Bà Trưng - TP. Hà Nội . Điện Thoại : 09001009 . Email : xamsidu.support@gmail.com");

            jPanel2.setBackground(new java.awt.Color(153, 204, 255));
            jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            jPanel2.setForeground(new java.awt.Color(153, 153, 255));
            jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jPanel2MouseClicked(evt);
                }
            });

            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/factory.png"))); // NOI18N

            jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(102, 0, 0));
            jLabel2.setText("Thêm Sản Phẩm");

            jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(102, 0, 0));
            jLabel3.setText("Chỉnh sửa Sản Phẩm");

            jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            jLabel4.setForeground(new java.awt.Color(102, 0, 0));
            jLabel4.setText("Xóa Sản Phẩm");

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(20, Short.MAX_VALUE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel4)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jPanel3.setBackground(new java.awt.Color(0, 0, 153));
            jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            jPanel3.setForeground(new java.awt.Color(0, 0, 204));

            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/law.png"))); // NOI18N

            jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            jLabel6.setForeground(new java.awt.Color(102, 0, 0));
            jLabel6.setText("Bán Lẻ");

            jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            jLabel7.setForeground(new java.awt.Color(102, 0, 0));
            jLabel7.setText("Bán Buôn");

            jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            jLabel8.setForeground(new java.awt.Color(102, 0, 0));
            jLabel8.setText("Xem Hóa Đơn");

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(20, Short.MAX_VALUE))
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel8)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jPanel4.setBackground(new java.awt.Color(102, 255, 204));
            jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            jPanel4.setForeground(new java.awt.Color(153, 153, 255));

            jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/add-group.png"))); // NOI18N

            jLabel10.setBackground(new java.awt.Color(204, 255, 204));
            jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            jLabel10.setForeground(new java.awt.Color(102, 0, 0));
            jLabel10.setText("Xem Khách Hàng");

            jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            jLabel11.setForeground(new java.awt.Color(102, 0, 0));
            jLabel11.setText("Thêm Nhân Viên");

            jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            jLabel12.setForeground(new java.awt.Color(102, 0, 0));
            jLabel12.setText("Tìm Khách Hàng");

            jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            jLabel13.setForeground(new java.awt.Color(102, 0, 0));
            jLabel13.setText("Chỉnh Sửa Khách Hàng");

            jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            jLabel14.setForeground(new java.awt.Color(102, 0, 0));
            jLabel14.setText("Xóa Khách Hàng");

            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))
                            .addGap(0, 0, Short.MAX_VALUE))))
            );
            jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(jLabel10)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel11)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel12)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel13)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel14)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jPanel5.setBackground(new java.awt.Color(0, 255, 51));
            jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            jPanel5.setForeground(new java.awt.Color(153, 153, 255));

            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/growth.png"))); // NOI18N

            jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            jLabel16.setForeground(new java.awt.Color(102, 0, 0));
            jLabel16.setText("Báo Cáo Hóa Đơn");

            jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            jLabel17.setForeground(new java.awt.Color(102, 0, 0));
            jLabel17.setText("Báo Cáo Doanh Thu");

            jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            jLabel18.setForeground(new java.awt.Color(102, 0, 0));
            jLabel18.setText("Bảng Gía Sản Phẩm");

            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
            jPanel5.setLayout(jPanel5Layout);
            jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(20, Short.MAX_VALUE))
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            );
            jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel16)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel17)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel18)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel19.setForeground(new java.awt.Color(255, 255, 0));
            jLabel19.setText("Kho Hàng");

            jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel20.setForeground(new java.awt.Color(255, 255, 0));
            jLabel20.setText("Nhân Viên - Khách Hàng");

            jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel21.setForeground(new java.awt.Color(255, 255, 0));
            jLabel21.setText("Bán Hàng");

            jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel22.setForeground(new java.awt.Color(255, 255, 0));
            jLabel22.setText("Báo Cáo");

            jSeparator1.setBackground(new java.awt.Color(0, 0, 102));

            jSeparator2.setBackground(new java.awt.Color(0, 0, 102));

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbRunTiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSoftwareName, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(120, 120, 120))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator1)
                    .addContainerGap())
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator2)
                    .addContainerGap())
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(165, 165, 165)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(150, 150, 150))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(787, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(601, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(351, 351, 351)))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(lblSoftwareName)
                    .addGap(30, 30, 30)
                    .addComponent(jLabel19)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel22))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(39, 39, 39)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(4, 4, 4)
                    .addComponent(lbRunTiem)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel21)
                        .addContainerGap(490, Short.MAX_VALUE)))
            );

            deskTop.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

            javax.swing.GroupLayout deskTopLayout = new javax.swing.GroupLayout(deskTop);
            deskTop.setLayout(deskTopLayout);
            deskTopLayout.setHorizontalGroup(
                deskTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deskTopLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(10, 10, 10))
            );
            deskTopLayout.setVerticalGroup(
                deskTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deskTopLayout.createSequentialGroup()
                    .addGap(120, 120, 120)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            menuTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/webpage.png"))); // NOI18N
            menuTrangChu.setText("Trang Chủ");
            menuTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            menuTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    menuTrangChuMouseClicked(evt);
                }
            });
            jMenuBar1.add(menuTrangChu);

            menuThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/account.png"))); // NOI18N
            menuThoat.setText("Tài Khoản");
            menuThoat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

            menuDangNhapHT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/account.png"))); // NOI18N
            menuDangNhapHT.setText("Đăng Nhập");
            menuDangNhapHT.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    menuDangNhapHTActionPerformed(evt);
                }
            });
            menuThoat.add(menuDangNhapHT);

            menuDangKyHT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/man.png"))); // NOI18N
            menuDangKyHT.setText("Đăng Ký");
            menuDangKyHT.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    menuDangKyHTActionPerformed(evt);
                }
            });
            menuThoat.add(menuDangKyHT);

            menuThoatHT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/cross.png"))); // NOI18N
            menuThoatHT.setText("Thoát");
            menuThoat.add(menuThoatHT);

            jMenuBar1.add(menuThoat);

            menuQuanLys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/project.png"))); // NOI18N
            menuQuanLys.setText("Quản Lý");
            menuQuanLys.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

            menuSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/milk.png"))); // NOI18N
            menuSanPham.setText("Quản Lý Sản Phẩm");
            menuSanPham.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    menuSanPhamActionPerformed(evt);
                }
            });
            menuQuanLys.add(menuSanPham);

            menuBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/supermarket.png"))); // NOI18N
            menuBanHang.setText("Quản Lý Bán Hàng");
            menuBanHang.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    menuBanHangActionPerformed(evt);
                }
            });
            menuQuanLys.add(menuBanHang);

            menuDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/law (1).png"))); // NOI18N
            menuDonHang.setText("Quản Lý Đơn Hàng");
            menuDonHang.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    menuDonHangActionPerformed(evt);
                }
            });
            menuQuanLys.add(menuDonHang);

            menuDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/revenue.png"))); // NOI18N
            menuDoanhThu.setText("Quản Lý Doanh Thu");
            menuDoanhThu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    menuDoanhThuActionPerformed(evt);
                }
            });
            menuQuanLys.add(menuDoanhThu);

            menuThungRac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/delete.png"))); // NOI18N
            menuThungRac.setText("Thùng Rác");
            menuThungRac.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    menuThungRacActionPerformed(evt);
                }
            });
            menuQuanLys.add(menuThungRac);

            jMenuBar1.add(menuQuanLys);

            menuKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imge/add-group (1).png"))); // NOI18N
            menuKhachHang.setText("Khách Hàng");
            menuKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            menuKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    menuKhachHangMouseClicked(evt);
                }
            });
            jMenuBar1.add(menuKhachHang);

            setJMenuBar(jMenuBar1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(deskTop)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(deskTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void menuDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDoanhThuActionPerformed
        QLDoanhThu qldt = new QLDoanhThu();
        deskTop.add(qldt);
        qldt.setVisible(true);
    }//GEN-LAST:event_menuDoanhThuActionPerformed

    private void menuDangNhapHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDangNhapHTActionPerformed
        Login lg = new Login();
        deskTop.add(lg);
        lg.setVisible(true);

    }//GEN-LAST:event_menuDangNhapHTActionPerformed

    private void menuDangKyHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDangKyHTActionPerformed
        DangKyBH dk = new DangKyBH();
        deskTop.add(dk);
        dk.setVisible(true);
    }//GEN-LAST:event_menuDangKyHTActionPerformed

    private void menuSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSanPhamActionPerformed
        QLSanPham qlsp = new QLSanPham();
        deskTop.add(qlsp);
        qlsp.setVisible(true);
    }//GEN-LAST:event_menuSanPhamActionPerformed

    private void menuBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBanHangActionPerformed
        QLBanHang qlbh = new QLBanHang();
        deskTop.add(qlbh);
        qlbh.setVisible(true);
    }//GEN-LAST:event_menuBanHangActionPerformed

    private void menuDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDonHangActionPerformed

        QLDonHang qldh = new QLDonHang();
        deskTop.add(qldh);
        qldh.setVisible(true);
    }//GEN-LAST:event_menuDonHangActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
//        QLDonHang qldh = new QLDonHang();
//        deskTop.add(qldh);
//        qldh.setVisible(true);
    }//GEN-LAST:event_jPanel2MouseClicked

    private void menuThungRacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuThungRacActionPerformed
        QuanLyLichSuXoa qlls = new QuanLyLichSuXoa();
        deskTop.add(qlls);
        qlls.setVisible(true);
    }//GEN-LAST:event_menuThungRacActionPerformed

    private void menuTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTrangChuMouseClicked
        dispose();
        MainQLBH main = new MainQLBH();
        main.setVisible(true);
    }//GEN-LAST:event_menuTrangChuMouseClicked

    private void menuKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuKhachHangMouseClicked
        QLKhachHang qlkh = new QLKhachHang();
        deskTop.add(qlkh);
        qlkh.setVisible(true);
    }//GEN-LAST:event_menuKhachHangMouseClicked

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
            java.util.logging.Logger.getLogger(MainQLBH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainQLBH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainQLBH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainQLBH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainQLBH().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane deskTop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbRunTiem;
    private javax.swing.JLabel lblSoftwareName;
    private javax.swing.JMenuItem menuBanHang;
    private javax.swing.JMenuItem menuDangKyHT;
    private javax.swing.JMenuItem menuDangNhapHT;
    public static javax.swing.JMenuItem menuDoanhThu;
    private javax.swing.JMenuItem menuDonHang;
    public static javax.swing.JMenu menuKhachHang;
    public static javax.swing.JMenu menuQuanLys;
    public static javax.swing.JMenuItem menuSanPham;
    private javax.swing.JMenu menuThoat;
    private javax.swing.JMenuItem menuThoatHT;
    public static javax.swing.JMenuItem menuThungRac;
    private javax.swing.JMenu menuTrangChu;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        long FPS = 80;
        long period = 1000 * 1000000 / FPS;
        long beginTime, sleepTime;

        beginTime = System.nanoTime();
        while (true) {

            Update();

            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;
            try {
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime / 1000000);
                } else {
                    Thread.sleep(period / 2000000);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            beginTime = System.nanoTime();
        }
    }

}
