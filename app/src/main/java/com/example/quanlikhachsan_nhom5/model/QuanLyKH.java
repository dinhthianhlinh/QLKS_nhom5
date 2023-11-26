package com.example.quanlikhachsan_nhom5.model;

public class QuanLyKH {
    private int id;
    private String tenQLKH;
    private int tuoiQLKH;
    private String gioitinhQLKH;
    private int sodtQLKH;
    private String quequanQLKH;
    private int cancuocQLKH;
    private int solandatphongQLKH;

    public QuanLyKH() {
    }


    public QuanLyKH(int id, String tenQLKH, int tuoiQLKH, String gioitinhQLKH, int sodtQLKH, String quequanQLKH, int cancuocQLKH) {
        this.id = id;
        this.tenQLKH = tenQLKH;
        this.tuoiQLKH = tuoiQLKH;
        this.gioitinhQLKH = gioitinhQLKH;
        this.sodtQLKH = sodtQLKH;
        this.quequanQLKH = quequanQLKH;
        this.cancuocQLKH = cancuocQLKH;
    }

    public QuanLyKH(int id, String tenQLKH, int tuoiQLKH, String gioitinhQLKH, int sodtQLKH, String quequanQLKH, int cancuocQLKH, int solandatphongQLKH) {
        this.id = id;
        this.tenQLKH = tenQLKH;
        this.tuoiQLKH = tuoiQLKH;
        this.gioitinhQLKH = gioitinhQLKH;
        this.sodtQLKH = sodtQLKH;
        this.quequanQLKH = quequanQLKH;
        this.cancuocQLKH = cancuocQLKH;
        this.solandatphongQLKH = solandatphongQLKH;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenQLKH() {
        return tenQLKH;
    }

    public void setTenQLKH(String tenQLKH) {
        this.tenQLKH = tenQLKH;
    }

    public int getTuoiQLKH() {
        return tuoiQLKH;
    }

    public void setTuoiQLKH(int tuoiQLKH) {
        this.tuoiQLKH = tuoiQLKH;
    }

    public String getGioitinhQLKH() {
        return gioitinhQLKH;
    }

    public void setGioitinhQLKH(String gioitinhQLKH) {
        this.gioitinhQLKH = gioitinhQLKH;
    }

    public int getSodtQLKH() {
        return sodtQLKH;
    }

    public void setSodtQLKH(int sodtQLKH) {
        this.sodtQLKH = sodtQLKH;
    }

    public String getQuequanQLKH() {
        return quequanQLKH;
    }

    public void setQuequanQLKH(String quequanQLKH) {
        this.quequanQLKH = quequanQLKH;
    }

    public int getCancuocQLKH() {
        return cancuocQLKH;
    }

    public void setCancuocQLKH(int cancuocQLKH) {
        this.cancuocQLKH = cancuocQLKH;
    }

    public int getSolandatphongQLKH() {
        return solandatphongQLKH;
    }

    public void setSolandatphongQLKH(int solandatphongQLKH) {
        this.solandatphongQLKH = solandatphongQLKH;
    }
}
