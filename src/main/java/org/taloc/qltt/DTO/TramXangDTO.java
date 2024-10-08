package org.taloc.qltt.DTO;

import org.springframework.web.multipart.MultipartFile;
import org.taloc.qltt.Model.TramXang;

public class TramXangDTO {
    private int maTram;
    private String tenTram;
    private String diaChi;
    private String truongTram;
    private double kinhDo;
    private double viDo;

    private String tenHinhAnh; // Đổi tên từ hinhAnh -> tenHinhAnh

    private MultipartFile hinhAnh; // Đổi tên từ hinhAnhFile -> hinhAnh

    // Getters và Setters
    public int getMaTram() {
        return maTram;
    }

    public void setMaTram(int maTram) {
        this.maTram = maTram;
    }

    // ... các getter và setter khác ...


    public String getTenTram() {
        return tenTram;
    }

    public void setTenTram(String tenTram) {
        this.tenTram = tenTram;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTruongTram() {
        return truongTram;
    }

    public void setTruongTram(String truongTram) {
        this.truongTram = truongTram;
    }

    public double getKinhDo() {
        return kinhDo;
    }

    public void setKinhDo(double kinhDo) {
        this.kinhDo = kinhDo;
    }

    public double getViDo() {
        return viDo;
    }

    public void setViDo(double viDo) {
        this.viDo = viDo;
    }

    public String getTenHinhAnh() {
        return tenHinhAnh;
    }

    public void setTenHinhAnh(String tenHinhAnh) {
        this.tenHinhAnh = tenHinhAnh;
    }

    public MultipartFile getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(MultipartFile hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
