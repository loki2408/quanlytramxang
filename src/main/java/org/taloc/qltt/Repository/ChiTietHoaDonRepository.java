package org.taloc.qltt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taloc.qltt.Model.ChiTietHoaDon;
import org.taloc.qltt.Model.ChiTietHoaDonId;

public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, ChiTietHoaDonId> {
}
