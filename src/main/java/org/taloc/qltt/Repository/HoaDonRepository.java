package org.taloc.qltt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.taloc.qltt.DTO.DoanhThuDTO;
import org.taloc.qltt.Model.ChiTietHoaDon;
import org.taloc.qltt.Model.HoaDon;

import java.time.LocalDate;
import java.util.List;

public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    // Truy vấn các hóa đơn theo khoảng thời gian
    List<HoaDon> findByNgayLapBetween(LocalDate startDate, LocalDate endDate);

    // Truy vấn tất cả các chi tiết hóa đơn
    @Query("SELECT c FROM ChiTietHoaDon c")
    List<ChiTietHoaDon> findAllChiTietHoaDon();


}