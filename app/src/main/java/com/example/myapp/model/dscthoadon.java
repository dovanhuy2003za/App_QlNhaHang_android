package com.example.myapp.model;




public class dscthoadon {

    private int id;
    private  int idmon;
    private int idhd;
    private int soluong;
    private String tenmon;
    private int dongia;
    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }



    public dscthoadon() {
        this.id=id;
        this.idmon=idmon;
        this.idhd=idhd;
        this.soluong=soluong;

    }

    public dscthoadon(int id, int idmon, int idhd, int soluong) {
        this.id = id;
        this.idmon = idmon;
        this.idhd = idhd;
        this.soluong = soluong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdmon() {
        return idmon;
    }

    public void setIdmon(int idmon) {
        this.idmon = idmon;
    }

    public int getIdhd() {
        return idhd;
    }

    public void setIdhd(int idhd) {
        this.idhd = idhd;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
