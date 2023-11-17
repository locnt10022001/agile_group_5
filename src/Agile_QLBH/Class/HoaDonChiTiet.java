package Agile_QLBH.Class;

public class HoaDonChiTiet {

    public String maHDCT, maHD, maSP;
    public int giaBan, soLuongDH;
    public double giamGia, tongTien;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHDCT, String maHD, String maSP, int giaBan, int soLuongDH, double tongTien, float giamGia) {
        this.maHDCT = maHDCT;
        this.maHD = maHD;
        this.maSP = maSP;
        this.giaBan = giaBan;
        this.soLuongDH = soLuongDH;
        this.tongTien = tongTien;
        this.giamGia = giamGia;
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuongDH() {
        return soLuongDH;
    }

    public void setSoLuongDH(int soLuongDH) {
        this.soLuongDH = soLuongDH;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    
    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "maHDCT=" + maHDCT + ", maHD=" + maHD + ", maSP=" + maSP + ", giaBan=" + giaBan + ", soLuongDH=" + soLuongDH + ", tongTien=" + tongTien + ", giamGia=" + giamGia + '}';
    }
    
    

}
