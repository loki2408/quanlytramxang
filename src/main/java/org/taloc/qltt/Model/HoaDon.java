package org.taloc.qltt.Model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hoadon")
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hoa_don")
    private Integer maHoaDon;

    @Column(name = "ngay_lap")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayLap;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "ma_tram")
    private TramXang tramXang;

    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
    private List<ChiTietHoaDon> chiTietHoaDons;

    // Getters và Setters
    // ...

    public Integer getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public TramXang getTramXang() {
        return tramXang;
    }

    public void setTramXang(TramXang tramXang) {
        this.tramXang = tramXang;
    }

    public List<ChiTietHoaDon> getChiTietHoaDons() {
        return chiTietHoaDons;
    }

    public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
        this.chiTietHoaDons = chiTietHoaDons;
    }
}
