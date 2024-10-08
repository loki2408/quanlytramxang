package org.taloc.qltt.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tramxang")
public class TramXang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_tram")
    private Integer maTram;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @Column(name = "kinh_do")
    private Float kinhDo;

    @Column(name = "vi_do")
    private Float viDo;

    @Column(name = "ten_tram")
    private String tenTram;

    @Column(name = "truong_tram")
    private String truongTram;

    // Quan hệ với các Entity khác
    @OneToMany(mappedBy = "tramXang", cascade = CascadeType.ALL)
    private List<NhanVien> nhanViens;

    @OneToMany(mappedBy = "tramXang", cascade = CascadeType.ALL)
    private List<HoaDon> hoaDons;

    @OneToMany(mappedBy = "tramXang", cascade = CascadeType.ALL)
    private List<PhieuNhap> phieuNhaps;

    @OneToMany(mappedBy = "tramXang", cascade = CascadeType.ALL)
    private List<Kho> khos;

    // Getters và Setters
    // ...

    public Integer getMaTram() {
        return maTram;
    }

    public void setMaTram(Integer maTram) {
        this.maTram = maTram;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Float getKinhDo() {
        return kinhDo;
    }

    public void setKinhDo(Float kinhDo) {
        this.kinhDo = kinhDo;
    }

    public Float getViDo() {
        return viDo;
    }

    public void setViDo(Float viDo) {
        this.viDo = viDo;
    }

    public String getTenTram() {
        return tenTram;
    }

    public void setTenTram(String tenTram) {
        this.tenTram = tenTram;
    }

    public String getTruongTram() {
        return truongTram;
    }

    public void setTruongTram(String truongTram) {
        this.truongTram = truongTram;
    }

    public List<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(List<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }

    public List<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    public List<PhieuNhap> getPhieuNhaps() {
        return phieuNhaps;
    }

    public void setPhieuNhaps(List<PhieuNhap> phieuNhaps) {
        this.phieuNhaps = phieuNhaps;
    }

    public List<Kho> getKhos() {
        return khos;
    }

    public void setKhos(List<Kho> khos) {
        this.khos = khos;
    }
}