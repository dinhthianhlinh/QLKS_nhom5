package com.example.quanlikhachsan_nhom5.model;

public class QuanLyP {
    private int sophongQLP;
    private String tenQLP;
    private int sogioQLP;
    private int dongiaQLP;
    private int dichvukhQLP;
    private int tongtienQLP;
    private int datcocQLP;
    private int khachtra;
    private String inhoadonQLP;


    public QuanLyP(int sophong, String ten_qlp, int sogio_qlp, int dongia_qlp, String dichvuk_qlp, int datcoc_qlp, String inhoadon_qlp) {
    }

    public QuanLyP(int sophongQLP, String tenQLP, int sogioQLP, int dongiaQLP, int dichvukhQLP, int tongtienQLP, int datcocQLP, int khachtra, String inhoadonQLP) {
        this.sophongQLP = sophongQLP;
        this.tenQLP = tenQLP;
        this.sogioQLP = sogioQLP;
        this.dongiaQLP = dongiaQLP;
        this.dichvukhQLP = dichvukhQLP;
        this.tongtienQLP = tongtienQLP;
        this.datcocQLP = datcocQLP;
        this.khachtra = khachtra;
        this.inhoadonQLP = inhoadonQLP;
    }

    public int getSophongQLP() {
        return sophongQLP;
    }

    public void setSophongQLP(int sophongQLP) {
        this.sophongQLP = sophongQLP;
    }

    public String getTenQLP() {
        return tenQLP;
    }

    public void setTenQLP(String tenQLP) {
        this.tenQLP = tenQLP;
    }

    public int getSogioQLP() {
        return sogioQLP;
    }

    public void setSogioQLP(int sogioQLP) {
        this.sogioQLP = sogioQLP;
    }

    public int getDongiaQLP() {
        return dongiaQLP;
    }

    public void setDongiaQLP(int dongiaQLP) {
        this.dongiaQLP = dongiaQLP;
    }

    public int getDichvukhQLP() {
        return dichvukhQLP;
    }

    public void setDichvukhQLP(int dichvukhQLP) {
        this.dichvukhQLP = dichvukhQLP;
    }

    public int getTongtienQLP() {
        return tongtienQLP;
    }

    public void setTongtienQLP(int tongtienQLP) {
        this.tongtienQLP = tongtienQLP;
    }

    public int getDatcocQLP() {
        return datcocQLP;
    }

    public void setDatcocQLP(int datcocQLP) {
        this.datcocQLP = datcocQLP;
    }

    public int getKhachtra() {
        return khachtra;
    }

    public void setKhachtra(int khachtra) {
        this.khachtra = khachtra;
    }

    public String getInhoadonQLP() {
        return inhoadonQLP;
    }

    public void setInhoadonQLP(String inhoadonQLP) {
        this.inhoadonQLP = inhoadonQLP;
    }
}
