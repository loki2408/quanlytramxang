package org.taloc.qltt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.taloc.qltt.DTO.ChiTietHoaDonDTO;
import org.taloc.qltt.Model.ChiTietHoaDon;
import org.taloc.qltt.Model.ChiTietHoaDonId;

import java.util.Arrays;
import java.util.List;

public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, ChiTietHoaDonId> {
    List<ChiTietHoaDon> findById_MaHoaDon(int maHoaDon);
    List<ChiTietHoaDon> findByHoaDon_MaHoaDon(int hoaDonId);
}
