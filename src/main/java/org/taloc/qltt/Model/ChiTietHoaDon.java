package org.taloc.qltt.Model;


import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "chitiethoadon")
public class ChiTietHoaDon {

    @EmbeddedId
    private ChiTietHoaDonId id;

    @Column(name = "don_gia")
    private BigDecimal donGia;

    @Column(name = "so_luong")
    private Integer soLuong;

    @ManyToOne
    @MapsId("maHoaDon")
    @JoinColumn(name = "ma_hoa_don")
    private HoaDon hoaDon;

    @ManyToOne
    @MapsId("maXangDau")
    @JoinColumn(name = "ma_xang_dau")
    private XangDau xangDau;

    // Getters và Setters
    // ...


    public ChiTietHoaDonId getId() {
        return id;
    }

    public void setId(ChiTietHoaDonId id) {
        this.id = id;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
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
}
