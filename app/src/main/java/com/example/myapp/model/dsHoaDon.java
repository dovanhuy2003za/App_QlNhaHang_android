package com.example.myapp.model;

public class dsHoaDon {
    private int id;
    private String tenkh;
    private  int tongtien;
    private String ngay;
    public  dsHoaDon(){
        this.id=id;
        this.tenkh = tenkh;
        this.tongtien = tongtien;
        this.ngay = ngay;
    }
    public dsHoaDon(String tenkh, int tongtien, String ngay) {
        this.tenkh = tenkh;
        this.tongtien = tongtien;
        this.ngay = ngay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
}
