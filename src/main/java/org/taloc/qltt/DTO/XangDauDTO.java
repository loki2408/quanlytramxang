package org.taloc.qltt.DTO;

import java.math.BigDecimal;

public class XangDauDTO {
    private Integer maXangDau;
    private String tenXangDau;
    private BigDecimal gia;
    private String loaiNhienLieu;

    // Getters và Setters
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
}
