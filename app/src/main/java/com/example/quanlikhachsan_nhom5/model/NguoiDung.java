package com.example.quanlikhachsan_nhom5.model;

public class NguoiDung {
    private int mand;
    private String tennd, sdt, diachi, tendn, matkhau;
    private int role;

    public NguoiDung() {
    }

    public NguoiDung(int mand, String tennd, String sdt, String diachi, String tendn, String matkhau, int role) {
        this.mand = mand;
        this.tennd = tennd;
        this.sdt = sdt;
        this.diachi = diachi;
        this.tendn = tendn;
        this.matkhau = matkhau;
        this.role = role;
    }

    public NguoiDung(String tennd, String sdt, String diachi, String tendn, String matkhau) {
        this.tennd = tennd;
        this.sdt = sdt;
        this.diachi = diachi;
        this.tendn = tendn;
        this.matkhau = matkhau;
    }

    public int getMand() {
        return mand;
    }

    public void setMand(int mand) {
        this.mand = mand;
    }

    public String getTennd() {
        return tennd;
    }

    public void setTennd(String tennd) {
        this.tennd = tennd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTendn() {
        return tendn;
    }

    public void setTendn(String tendn) {
        this.tendn = tendn;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
