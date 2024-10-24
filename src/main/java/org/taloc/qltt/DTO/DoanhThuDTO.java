package org.taloc.qltt.DTO;

public class DoanhThuDTO {
    private String label;  // Nhãn có thể là ngày, tháng, năm hoặc tên trạm
    private double totalRevenue;  // Tổng doanh thu

    // Constructor
    public DoanhThuDTO(String label, double totalRevenue) {
        this.label = label;
        this.totalRevenue = totalRevenue;
    }

    // Getters và Setters
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
