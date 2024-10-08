package org.taloc.qltt.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "xangdau")
public class XangDau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_xang_dau")
    private Integer maXangDau;

    @Column(name = "ten_xang_dau")
    private String tenXangDau;

    @Column(name = "gia")
    private BigDecimal gia;

    @Column(name = "loai_nhien_lieu")
    private String loaiNhienLieu;

    @OneToMany(mappedBy = "xangDau", cascade = CascadeType.ALL)
    private List<ChiTietHoaDon> chiTietHoaDons;

    @OneToMany(mappedBy = "xangDau", cascade = CascadeType.ALL)
    private List<ChiTietPhieuNhap> chiTietPhieuNhaps;

    // Getters và Setters
    // ...


    public Integer getMaXangDau() {
        return maXangDau;
    }

    public void setMaXangDau(Integer maXangDau) {
        this.maXangDau = maXangDau;
    }

    public String getTenXangDau() {
        return tenXangDau;
    }

    public void setTenXangDau(String tenXangDau) {
        this.tenXangDau = tenXangDau;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public String getLoaiNhienLieu() {
        return loaiNhienLieu;
    }

    public void setLoaiNhienLieu(String loaiNhienLieu) {
        this.loaiNhienLieu = loaiNhienLieu;
    }

    public List<ChiTietHoaDon> getChiTietHoaDons() {
        return chiTietHoaDons;
    }

    public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
        this.chiTietHoaDons = chiTietHoaDons;
    }

    public List<ChiTietPhieuNhap> getChiTietPhieuNhaps() {
        return chiTietPhieuNhaps;
    }

    public void setChiTietPhieuNhaps(List<ChiTietPhieuNhap> chiTietPhieuNhaps) {
        this.chiTietPhieuNhaps = chiTietPhieuNhaps;
    }
}
