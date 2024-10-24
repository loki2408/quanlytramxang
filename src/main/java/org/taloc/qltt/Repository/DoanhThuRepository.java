//package org.taloc.qltt.Repository;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.taloc.qltt.DTO.DoanhThuDTO;
//import org.taloc.qltt.Model.HoaDon;
//
//import java.util.List;
//
//public interface DoanhThuRepository extends CrudRepository<HoaDon, Integer> {
//
//    @Query(value = "SELECT DATE_FORMAT(h.ngay_lap, '%Y-%m-%d') AS label, SUM(cthd.thanh_tien) AS totalRevenue " +
//            "FROM hoa_don h " +
//            "JOIN chi_tiet_hoa_don cthd ON h.ma_hoa_don = cthd.ma_hoa_don " +
//            "GROUP BY DATE_FORMAT(h.ngay_lap, '%Y-%m-%d')", nativeQuery = true)
//    List<DoanhThuDTO> tinhDoanhThuTheoNgay();
//
//
//
//    @Query("SELECT new org.taloc.qltt.DTO.DoanhThuDTO(" +
//            "FUNCTION('YEAR', h.ngayLap), SUM(cthd.thanhTien)) " +
//            "FROM HoaDon h JOIN h.chiTietHoaDonList cthd " +
//            "GROUP BY FUNCTION('YEAR', h.ngayLap)")
//    List<DoanhThuDTO> tinhDoanhThuTheoNam();
//
//    @Query(value = "SELECT DATE_FORMAT(h.ngay_lap, '%Y-%m') AS label, SUM(cthd.thanh_tien) AS totalRevenue " +
//            "FROM hoa_don h JOIN chi_tiet_hoa_don cthd ON h.ma_hoa_don = cthd.ma_hoa_don " +
//            "GROUP BY DATE_FORMAT(h.ngay_lap, '%Y-%m')", nativeQuery = true)
//    List<DoanhThuDTO> tinhDoanhThuTheoThang();
//
//
//    @Query("SELECT new org.taloc.qltt.DTO.DoanhThuDTO(" +
//            "t.tenTram, SUM(cthd.thanhTien)) " +
//            "FROM HoaDon h JOIN h.tramXang t JOIN h.chiTietHoaDonList cthd " +
//            "GROUP BY t.tenTram")
//    List<DoanhThuDTO> tinhDoanhThuTheoTram();
//
//
//
//}
