package com.assignmentandroidnetworking.assignment_phibvpd01901.Model;

/**
 * Created by PC on 8/10/2018.
 */

public class KhenThuong {
    int id;
    String maSV ;
    String hoTen ;
    double diemTB ;

    public KhenThuong() {
    }

    public KhenThuong(int id, String maSV, String hoTen, double diemTB) {
        this.id = id;
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemTB = diemTB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

}
