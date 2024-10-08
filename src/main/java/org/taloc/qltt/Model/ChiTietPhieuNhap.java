package org.taloc.qltt.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "chitietphieunhap")
public class ChiTietPhieuNhap {

    @EmbeddedId
    private ChiTietPhieuNhapId id;

    @Column(name = "so_luong")
    private Integer soLuong;

    @ManyToOne
    @MapsId("maPhieuNhap")
    @JoinColumn(name = "ma_phieu_nhap")
    private PhieuNhap phieuNhap;

    @ManyToOne
    @MapsId("maXangDau")
    @JoinColumn(name = "ma_xang_dau")
    private XangDau xangDau;

    // Getters và Setters
    // ...

    public ChiTietPhieuNhapId getId() {
        return id;
    }

    public void setId(ChiTietPhieuNhapId id) {
        this.id = id;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public PhieuNhap getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(PhieuNhap phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public XangDau getXangDau() {
        return xangDau;
    }

    public void setXangDau(XangDau xangDau) {
        this.xangDau = xangDau;
    }
}
