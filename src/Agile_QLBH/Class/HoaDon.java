package Agile_QLBH.Class;

import java.util.Date;

public class HoaDon {

    public String maHD, maKH, maNV;
    public int tongTien;
    public Date ngayMua;
    public String delete_at, delete_User;

    public HoaDon() {
    }

    public HoaDon(String maHD, String maKH, String maNV, int tongTien, Date ngayMua, String delete_at, String delete_User) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.tongTien = tongTien;
        this.ngayMua = ngayMua;
        this.delete_at = delete_at;
        this.delete_User = delete_User;
    }

    public HoaDon(String maHD, String maKH, String maNV, int tongTien, Date ngayMua) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.tongTien = tongTien;
        this.ngayMua = ngayMua;
    }
    
    

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getDelete_at() {
        return delete_at;
    }

    public void setDelete_at(String delete_at) {
        this.delete_at = delete_at;
    }

    public String getDelete_User() {
        return delete_User;
    }

    public void setDelete_User(String delete_User) {
        this.delete_User = delete_User;
    }

}
