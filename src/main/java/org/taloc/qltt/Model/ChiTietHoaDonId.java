package org.taloc.qltt.Model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ChiTietHoaDonId implements Serializable {

    private int maHoaDon;
    private int maXangDau;

    public ChiTietHoaDonId(int maHoaDon, int maXangDau) {
        this.maHoaDon = maHoaDon;
        this.maXangDau = maXangDau;
    }


    public ChiTietHoaDonId() {
    }

    // Getters và Setters
    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaXangDau() {
        return maXangDau;
    }

    public void setMaXangDau(int maXangDau) {
        this.maXangDau = maXangDau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietHoaDonId that = (ChiTietHoaDonId) o;
        return maHoaDon == that.maHoaDon && maXangDau == that.maXangDau;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHoaDon, maXangDau);
    }
}
