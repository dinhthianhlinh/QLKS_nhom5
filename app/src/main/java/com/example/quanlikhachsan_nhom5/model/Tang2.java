package com.example.quanlikhachsan_nhom5.model;

public class Tang2 {
    private int id;
    private String sophong , sotang, giaphong, hangphong;

    public Tang2() {

    }

    public Tang2(int id, String sophong, String sotang, String giaphong, String hangphong) {
        this.id = id;
        this.sophong = sophong;
        this.sotang = sotang;
        this.giaphong = giaphong;
        this.hangphong = hangphong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSophong() {
        return sophong;
    }

    public void setSophong(String sophong) {
        this.sophong = sophong;
    }

    public String getSotang() {
        return sotang;
    }

    public void setSotang(String sotang) {
        this.sotang = sotang;
    }

    public String getGiaphong() {
        return giaphong;
    }

    public void setGiaphong(String giaphong) {
        this.giaphong = giaphong;
    }

    public String getHangphong() {
        return hangphong;
    }

    public void setHangphong(String hangphong) {
        this.hangphong = hangphong;
    }
}
