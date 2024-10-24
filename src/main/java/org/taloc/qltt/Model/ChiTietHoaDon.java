package org.taloc.qltt.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "chi_tiet_hoa_don")
public class ChiTietHoaDon {

    @EmbeddedId
    private ChiTietHoaDonId id;

    @ManyToOne
    @MapsId("maHoaDon")
    @JoinColumn(name = "ma_hoa_don")
    private HoaDon hoaDon;

    @ManyToOne
    @MapsId("maXangDau")
    @JoinColumn(name = "ma_xang_dau")
    private XangDau xangDau;

    private double soLuong;
    private double donGia;

    private double thanhTien;

    // Getters và Setters
    public ChiTietHoaDonId getId() {
        return id;
    }

    public void setId(ChiTietHoaDonId id) {
        this.id = id;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public XangDau getXangDau() {
        return xangDau;
    }

    public void setXangDau(XangDau xangDau) {
        this.xangDau = xangDau;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return soLuong * donGia;
    }

    public void setThanhTien(double v) {
    }
}
