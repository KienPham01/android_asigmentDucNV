package com.assignmentandroidnetworking.assignment_phibvpd01901.Model;

import java.io.Serializable;

/**
 * Created by PC on 6/11/2018.
 */

public class Student implements Serializable{
    private int Id;
    private String maSV;
    private String hoTen;
    private String gioTinh;
    private String lop;
    private String linkanh;
    private String namsinh;
    public Student() {
    }
    public Student(int id, String maSV, String hoTen, String gioTinh, String lop, String linkanh, String namsinh) {
        Id = id;
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.gioTinh = gioTinh;
        this.lop = lop;
        this.linkanh = linkanh;
        this.namsinh = namsinh;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getGioTinh() {
        return gioTinh;
    }

    public void setGioTinh(String gioTinh) {
        this.gioTinh = gioTinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
    public String getLinkanh() {
        return linkanh;
    }

    public void setLinkanh(String linkanh) {
        this.linkanh = linkanh;
    }
}
