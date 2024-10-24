package org.taloc.qltt.DTO;

import org.taloc.qltt.Model.HoaDon;

import java.time.LocalDate;
import java.util.List;

public class HoaDonDTO {
    private int maHoaDon;
    private String tenKhachHang;
    private int maTram;
    private int maNhanVien;
    private LocalDate ngayLap;
    private double tongTien;
    private List<ChiTietHoaDonDTO> chiTietHoaDonList;
    private String tenTram; // Thêm trường tên trạm
    private String tenNhanVien; // Thêm trường tên nhân viên

    public HoaDonDTO() {
    }

    // Constructor có tham số kiểu HoaDon
    public HoaDonDTO(HoaDon hoaDon) {
        this.maHoaDon = hoaDon.getMaHoaDon();
        this.tenKhachHang = hoaDon.getTenKhachHang();
        this.maTram = hoaDon.getTramXang().getMaTram();
        this.maNhanVien = hoaDon.getNhanVien().getMaNhanVien();
        this.ngayLap = hoaDon.getNgayLap();
        this.tongTien = hoaDon.getTongTien();
    }

    // Getters and Setters
    public int getMaHoaDon() {
        return maHoaDon;
    }


    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public int getMaTram() {
        return maTram;
    }

    public void setMaTram(int maTram) {
        this.maTram = maTram;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public List<ChiTietHoaDonDTO> getChiTietHoaDonList() {
        return chiTietHoaDonList;
    }

    public void setChiTietHoaDonList(List<ChiTietHoaDonDTO> chiTietHoaDonList) {
        this.chiTietHoaDonList = chiTietHoaDonList;
    }

    public String getTenTram() {
        return tenTram;
    }

    public void setTenTram(String tenTram) {
        this.tenTram = tenTram;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }
}
