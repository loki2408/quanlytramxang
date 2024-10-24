package org.taloc.qltt.DTO;

import java.util.Date;

public class PhieuNhapDTO {
    private Integer maPhieuNhap;
    private Integer maTram;
    private Date ngayLap;
    private String tenTram; // Thêm trường này để lưu tên trạm

    // Getters và Setters

    public Integer getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(Integer maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public Integer getMaTram() {
        return maTram;
    }

    public void setMaTram(Integer maTram) {
        this.maTram = maTram;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getTenTram() {
        return tenTram;
    }

    public void setTenTram(String tenTram) {
        this.tenTram = tenTram;
    }
}