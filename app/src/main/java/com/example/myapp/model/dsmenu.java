package com.example.myapp.model;

public class dsmenu {
    private int id;
    private String name;
    private int dongia;

    public dsmenu() {
        this.id = id;
        this.name = name;
        this.dongia = dongia;
    }

    public dsmenu(String name, int dongia) {
        this.name = name;
        this.dongia = dongia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
}
