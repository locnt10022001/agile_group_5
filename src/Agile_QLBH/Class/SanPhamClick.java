/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agile_QLBH.Class;

public class SanPhamClick {

    public String maSP, TenSP;

    public int gia, soLuong;
    public double thanhTien;

    public SanPhamClick() {
    }

    public SanPhamClick(String maSP, String TenSP, int gia, int soLuong, double thanhTien) {
        this.maSP = maSP;
        this.TenSP = TenSP;
        this.gia = gia;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "SanPhamClick{" + "maSP=" + maSP + ", TenSP=" + TenSP + ", gia=" + gia + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + '}';
    }
    
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

}
