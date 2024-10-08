package org.taloc.qltt.Model;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ChiTietHoaDonId implements Serializable {

    @Column(name = "MaHoaDon")
    private Integer maHoaDon;

    @Column(name = "MaXangDau")
    private Integer maXangDau;

    // Constructors, Getters, Setters, equals(), hashCode()
    // ...


    public ChiTietHoaDonId(Integer maHoaDon, Integer maXangDau) {
        this.maHoaDon = maHoaDon;
        this.maXangDau = maXangDau;
    }

    public ChiTietHoaDonId() {

    }

    public Integer getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
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
        ChiTietHoaDonId that = (ChiTietHoaDonId) o;
        return Objects.equals(maHoaDon, that.maHoaDon) && Objects.equals(maXangDau, that.maXangDau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHoaDon, maXangDau);
    }
}
