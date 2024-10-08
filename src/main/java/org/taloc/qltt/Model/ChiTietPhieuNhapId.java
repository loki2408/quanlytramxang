package org.taloc.qltt.Model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ChiTietPhieuNhapId implements Serializable {

    @Column(name = "MaPhieuNhap")
    private Integer maPhieuNhap;

    @Column(name = "MaXangDau")
    private Integer maXangDau;

    // Constructors, Getters, Setters, equals(), hashCode()
    // ...

    public ChiTietPhieuNhapId(Integer maPhieuNhap, Integer maXangDau) {
        this.maPhieuNhap = maPhieuNhap;
        this.maXangDau = maXangDau;
    }

    public ChiTietPhieuNhapId() {

    }

    public Integer getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(Integer maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public Integer getMaXangDau() {
        return maXangDau;
    }

    public void setMaXangDau(Integer maXangDau) {
        this.maXangDau = maXangDau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietPhieuNhapId that = (ChiTietPhieuNhapId) o;
        return Objects.equals(maPhieuNhap, that.maPhieuNhap) && Objects.equals(maXangDau, that.maXangDau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPhieuNhap, maXangDau);
    }
}
