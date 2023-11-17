/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agile_QLBH.Class;

public class KhachHang {

    String maKH, tenKH, sdt, dChi;
    String  delete_at,delete_User;

    public KhachHang() {
    }

    public KhachHang(String maKH, String tenKH, String sdt, String dChi, String delete_at, String delete_User) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.dChi = dChi;
        this.delete_at = delete_at;
        this.delete_User = delete_User;
    }

    public KhachHang(String maKH, String tenKH, String sdt, String dChi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.dChi = dChi;
    }
    
    

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getdChi() {
        return dChi;
    }

    public void setdChi(String dChi) {
        this.dChi = dChi;
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

    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", dChi=" + dChi + ", delete_at=" + delete_at + ", delete_User=" + delete_User + '}';
    }

    
    

}
