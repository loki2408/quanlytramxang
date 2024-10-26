package org.taloc.qltt.DTO;

import java.time.LocalDate;

    public class DoanhThuDTO {
        private String nhan;          // Nhãn (ngày, tháng, năm, trạm)
        private double tongDoanhThu;  // Tổng doanh thu

        // Constructor dành cho truy vấn nhóm
        public DoanhThuDTO(String nhan, double tongDoanhThu) {
            this.nhan = nhan;
            this.tongDoanhThu = tongDoanhThu;
        }

        // Getters và Setters
        public String getNhan() {
            return nhan;
        }

        public void setNhan(String nhan) {
            this.nhan = nhan;
        }

        public double getTongDoanhThu() {
            return tongDoanhThu;
        }

        public void setTongDoanhThu(double tongDoanhThu) {
            this.tongDoanhThu = tongDoanhThu;
        }
    }