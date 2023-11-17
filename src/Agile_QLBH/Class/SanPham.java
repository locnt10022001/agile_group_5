package Agile_QLBH.Class;

public class SanPham {

   public String MaSP, TenSP;
   public int SoLuong, Gia;
   public String MauSac, ManHinh, Camera, KetNoi, TienIch, DungLuongPin;
   public String delete_at,delete_Uers;

    public SanPham() {
    }

    public SanPham(String MaSP) {
        this.MaSP = MaSP;
    }
    

    public SanPham(String MaSP, String TenSP, int SoLuong, int Gia, String MauSac, String ManHinh, String Camera, String KetNoi, String TienIch, String DungLuongPin, String delete_at, String delete_Uers) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
        this.MauSac = MauSac;
        this.ManHinh = ManHinh;
        this.Camera = Camera;
        this.KetNoi = KetNoi;
        this.TienIch = TienIch;
        this.DungLuongPin = DungLuongPin;
        this.delete_at = delete_at;
        this.delete_Uers = delete_Uers;
    }

    public SanPham(String MaSP, String TenSP, int SoLuong, int Gia, String MauSac, String ManHinh, String Camera, String KetNoi, String TienIch, String DungLuongPin) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
        this.MauSac = MauSac;
        this.ManHinh = ManHinh;
        this.Camera = Camera;
        this.KetNoi = KetNoi;
        this.TienIch = TienIch;
        this.DungLuongPin = DungLuongPin;
    }
    
    
    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public String getManHinh() {
        return ManHinh;
    }

    public void setManHinh(String ManHinh) {
        this.ManHinh = ManHinh;
    }

    public String getCamera() {
        return Camera;
    }

    public void setCamera(String Camera) {
        this.Camera = Camera;
    }

    public String getKetNoi() {
        return KetNoi;
    }

    public void setKetNoi(String KetNoi) {
        this.KetNoi = KetNoi;
    }

    public String getTienIch() {
        return TienIch;
    }

    public void setTienIch(String TienIch) {
        this.TienIch = TienIch;
    }

    public String getDungLuongPin() {
        return DungLuongPin;
    }

    public void setDungLuongPin(String DungLuongPin) {
        this.DungLuongPin = DungLuongPin;
    }

    public String getDelete_at() {
        return delete_at;
    }

    public void setDelete_at(String delete_at) {
        this.delete_at = delete_at;
    }

    public String getDelete_Uers() {
        return delete_Uers;
    }

    public void setDelete_Uers(String delete_Uers) {
        this.delete_Uers = delete_Uers;
    }

   

    public double thanhTien(int soLuong1) {
        return (Gia * soLuong1);
    }

}
