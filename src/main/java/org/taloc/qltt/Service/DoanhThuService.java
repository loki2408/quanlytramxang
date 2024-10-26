//package org.taloc.qltt.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.taloc.qltt.DTO.DoanhThuDTO;
//import org.taloc.qltt.Repository.DoanhThuRepository;
//import java.util.List;
//
//@Service
//public class DoanhThuService {
//
//    @Autowired
//    private DoanhThuRepository doanhThuRepository;
//
//    public List<DoanhThuDTO> getDoanhThuTheoNgay() {
//        return doanhThuRepository.tinhDoanhThuTheoNgay();
//    }
//
//    public List<DoanhThuDTO> getDoanhThuTheoThang() {
//        return doanhThuRepository.tinhDoanhThuTheoThang();
//    }
//
//    public List<DoanhThuDTO> getDoanhThuTheoNam() {
//        return doanhThuRepository.tinhDoanhThuTheoNam();
//    }
//
//    public List<DoanhThuDTO> getDoanhThuTheoTram() {
//        return doanhThuRepository.tinhDoanhThuTheoTram();
//    }
//}
package org.taloc.qltt.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.taloc.qltt.DTO.DoanhThuDTO;

import java.time.LocalDate;
import java.util.List;

@Service
public class DoanhThuService {

    @PersistenceContext
    private EntityManager entityManager;

    // Doanh thu theo ngày
    public List<DoanhThuDTO> tinhDoanhThuTheoNgay(LocalDate startDate, LocalDate endDate) {
        String jpql = "SELECT new org.taloc.qltt.DTO.DoanhThuDTO(" +
                "CAST(h.ngayLap AS string), SUM(h.tongTien)) " +
                "FROM HoaDon h " +
                "WHERE h.ngayLap BETWEEN :startDate AND :endDate " +
                "GROUP BY h.ngayLap";
        TypedQuery<DoanhThuDTO> query = entityManager.createQuery(jpql, DoanhThuDTO.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

    public List<DoanhThuDTO> tinhDoanhThuTheoThang() {
        String jpql = "SELECT new org.taloc.qltt.DTO.DoanhThuDTO(" +
                "CAST(YEAR(h.ngayLap) AS string) || '-' || CAST(MONTH(h.ngayLap) AS string), " +
                "SUM(h.tongTien)) " +
                "FROM HoaDon h " +
                "GROUP BY YEAR(h.ngayLap), MONTH(h.ngayLap)";
        TypedQuery<DoanhThuDTO> query = entityManager.createQuery(jpql, DoanhThuDTO.class);
        return query.getResultList();
    }


    public List<DoanhThuDTO> tinhDoanhThuTheoNam() {
        String jpql = "SELECT new org.taloc.qltt.DTO.DoanhThuDTO(" +
                "CAST(YEAR(h.ngayLap) AS string), SUM(h.tongTien)) " +
                "FROM HoaDon h " +
                "GROUP BY YEAR(h.ngayLap)";
        TypedQuery<DoanhThuDTO> query = entityManager.createQuery(jpql, DoanhThuDTO.class);
        return query.getResultList();
    }



    // Doanh thu theo trạm
    public List<DoanhThuDTO> tinhDoanhThuTheoTram() {
        String jpql = "SELECT new org.taloc.qltt.DTO.DoanhThuDTO(" +
                "t.tenTram, SUM(h.tongTien)) " +
                "FROM HoaDon h JOIN h.tramXang t " +
                "GROUP BY t.tenTram";
        TypedQuery<DoanhThuDTO> query = entityManager.createQuery(jpql, DoanhThuDTO.class);
        return query.getResultList();
    }
}
