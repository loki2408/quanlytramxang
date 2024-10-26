//package org.taloc.qltt.Repository;
//
//import org.springframework.stereotype.Repository;
//import org.taloc.qltt.Model.HoaDon;
//
//@Repository
//public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
//
//    // Tìm kiếm hóa đơn theo ngày
//    List<ChiTietHoaDonDTO> findByNgayLapBetween(LocalDate startDate, LocalDate endDate);
//
//    // Tìm kiếm hóa đơn theo năm và tháng
//    @Query("SELECT new org.taloc.qltt.DTO.ChiTietHoaDonDTO(h) FROM HoaDon h WHERE YEAR(h.ngayLap) = :year AND MONTH(h.ngayLap) = :month")
//    List<ChiTietHoaDonDTO> findByYearAndMonth(@Param("year") int year, @Param("month") int month);
//
//    // Tìm kiếm hóa đơn theo trạm
//    List<ChiTietHoaDonDTO> findByTramId(Long tramId);
//}
