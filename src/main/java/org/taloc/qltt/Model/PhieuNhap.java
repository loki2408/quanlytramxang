package org.taloc.qltt.Model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "phieunhap")
public class PhieuNhap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_phieu_nhap")
    private Integer maPhieuNhap;

    @Column(name = "ngay_lap")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayLap;

    @ManyToOne
    @JoinColumn(name = "ma_tram")
    private TramXang tramXang;

    @OneToMany(mappedBy = "phieuNhap", cascade = CascadeType.ALL)
    private List<ChiTietPhieuNhap> chiTietPhieuNhaps;

    // Getters và Setters
    // ...

    public Integer getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(Integer maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public TramXang getTramXang() {
        return tramXang;
    }

    public void setTramXang(TramXang tramXang) {
        this.tramXang = tramXang;
    }

    public List<ChiTietPhieuNhap> getChiTietPhieuNhaps() {
        return chiTietPhieuNhaps;
    }

    public void setChiTietPhieuNhaps(List<ChiTietPhieuNhap> chiTietPhieuNhaps) {
        this.chiTietPhieuNhaps = chiTietPhieuNhaps;
    }
}
