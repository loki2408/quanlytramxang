package org.taloc.qltt.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "kho")
public class Kho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_kho")
    private Integer maKho;

    @Column(name = "ten_kho")
    private String tenKho;

    @Column(name = "so_luong_ton")
    private Integer soLuongTon;

    @ManyToOne
    @JoinColumn(name = "ma_tram")
    private TramXang tramXang;

    // Getters và Setters
    // ...

    public Integer getMaKho() {
        return maKho;
    }

    public void setMaKho(Integer maKho) {
        this.maKho = maKho;
    }

    public String getTenKho() {
        return tenKho;
    }

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public TramXang getTramXang() {
        return tramXang;
    }

    public void setTramXang(TramXang tramXang) {
        this.tramXang = tramXang;
    }
}
