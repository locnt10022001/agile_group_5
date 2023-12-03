package Agile_QLBH.Class;

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

public class SanPhamModify {

    public static List<SanPham> findAll() {
        List<SanPham> listSP = new ArrayList<>();

        Connection con = null;
        Statement statement = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLBH102",
                    "sa", "giang1999");

            String sql = "select * from SANPHAM where Delete_at is null";

            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {

                String maSP = result.getString("MaSP");
                String tenSP = result.getString("TenSP");
                int soLuong = result.getInt("SoLuong");
                int gia = result.getInt("Gia");
                String mauSac = result.getString("MauSac");
                String manHinh = result.getString("ManHinh");
                String camera = result.getString("Camera");
                String ketNoi = result.getString("KetNoi");
                String tienIch = result.getString("TienIch");
                String dungLuong = result.getString("DungLuongPin");
                String delete_at = result.getString("Delete_at");
                String delete_User = result.getString("Delete_Uuer");

                SanPham sp = new SanPham(maSP, tenSP, soLuong, gia, mauSac, manHinh,
                        camera, ketNoi, tienIch, dungLuong, delete_at, delete_User);

                listSP.add(sp);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return listSP;
    }

    public static void insert(SanPham sp) {
        Connection con = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            
            con = DriverManager.getConnection("jdbc:sqlserver://localhost\\DESKTOP-RPK6PAD\\SQLEXPRESS:1433;databaseName=QLBH102",
                    "sa", "888888");

            String sql = "insert into SANPHAM(MaSP,TenSP,SoLuong,Gia,MauSac,ManHinh,Camera,KetNoi,TienIch,DungLuongPin) values(?,?,?,?,?,?,?,?,?,?)";

            statement = con.prepareCall(sql);

            statement.setString(1, sp.getMaSP());
            statement.setString(2, sp.getTenSP());
            statement.setInt(3, sp.getSoLuong());
            statement.setInt(4, sp.getGia());
            statement.setString(5, sp.getMauSac());
            statement.setString(6, sp.getManHinh());
            statement.setString(7, sp.getCamera());
            statement.setString(8, sp.getKetNoi());
            statement.setString(9, sp.getTienIch());
            statement.setString(10, sp.getDungLuongPin());
           

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
