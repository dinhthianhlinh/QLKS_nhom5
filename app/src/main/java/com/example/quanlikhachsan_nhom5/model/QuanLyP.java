package com.example.quanlikhachsan_nhom5.model;

public class QuanLyP {
    private int sophongQLP;
    private String tenQLP;
    private int sogioQLP;
    private int dongiaQLP;
    private int dichvukhQLP;

    private int datcocQLP;

    private String inhoadonQLP;


    public QuanLyP(int sophongQLP, String tenQLP, int sogioQLP, int dongiaQLP, int dichvukhQLP, int datcocQLP, String inhoadonQLP) {
        this.sophongQLP = sophongQLP;
        this.tenQLP = tenQLP;
        this.sogioQLP = sogioQLP;
        this.dongiaQLP = dongiaQLP;
        this.dichvukhQLP = dichvukhQLP;
        this.datcocQLP = datcocQLP;
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

    public int getDatcocQLP() {
        return datcocQLP;
    }

    public void setDatcocQLP(int datcocQLP) {
        this.datcocQLP = datcocQLP;
    }

    public String getInhoadonQLP() {
        return inhoadonQLP;
    }

    public void setInhoadonQLP(String inhoadonQLP) {
        this.inhoadonQLP = inhoadonQLP;
    }
}
