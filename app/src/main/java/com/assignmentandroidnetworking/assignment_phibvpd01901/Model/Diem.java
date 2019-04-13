package com.assignmentandroidnetworking.assignment_phibvpd01901.Model;

import java.io.Serializable;

/**
 * Created by PC on 8/7/2018.
 */

public class Diem implements Serializable {
    private int Id;
    private String maSV;
    private String hoTen;
    private String monTN;
    private String monTH;
    private String monTB;
    private double diemMonTN;
    private double diemMonTh;
    private double diemMonTB;
    private double diemTB;
    private String linkanh;

    public Diem() {
    }

    public Diem(int id, String maSV, String hoTen, String monTN, String monTH, String monTB, double diemMonTN, double diemMonTh, double diemMonTB, double diemTB, String linkanh) {
        Id = id;
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.monTN = monTN;
        this.monTH = monTH;
        this.monTB = monTB;
        this.diemMonTN = diemMonTN;
        this.diemMonTh = diemMonTh;
        this.diemMonTB = diemMonTB;
        this.diemTB = diemTB;
        this.linkanh = linkanh;
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

    public String getMonTN() {
        return monTN;
    }

    public void setMonTN(String monTN) {
        this.monTN = monTN;
    }

    public String getMonTH() {
        return monTH;
    }

    public void setMonTH(String monTH) {
        this.monTH = monTH;
    }

    public String getMonTB() {
        return monTB;
    }

    public void setMonTB(String monTB) {
        this.monTB = monTB;
    }

    public double getDiemMonTN() {
        return diemMonTN;
    }

    public void setDiemMonTN(double diemMonTN) {
        this.diemMonTN = diemMonTN;
    }

    public double getDiemMonTh() {
        return diemMonTh;
    }

    public void setDiemMonTh(double diemMonTh) {
        this.diemMonTh = diemMonTh;
    }

    public double getDiemMonTB() {
        return diemMonTB;
    }

    public void setDiemMonTB(double diemMonTB) {
        this.diemMonTB = diemMonTB;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public String getLinkanh() {
        return linkanh;
    }

    public void setLinkanh(String linkanh) {
        this.linkanh = linkanh;
    }
}
