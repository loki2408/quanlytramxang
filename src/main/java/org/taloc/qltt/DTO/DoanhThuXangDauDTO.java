package org.taloc.qltt.DTO;

public class DoanhThuXangDauDTO {
    private String tenXangDau;
    private double doanhThu;

    public DoanhThuXangDauDTO(String tenXangDau, double doanhThu) {
        this.tenXangDau = tenXangDau;
        this.doanhThu = doanhThu;
    }

    public String getTenXangDau() {
        return tenXangDau;
    }

    public void setTenXangDau(String tenXangDau) {
        this.tenXangDau = tenXangDau;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }
}
