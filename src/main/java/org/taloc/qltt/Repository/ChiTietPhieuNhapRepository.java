package org.taloc.qltt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taloc.qltt.Model.ChiTietPhieuNhap;
import org.taloc.qltt.Model.ChiTietPhieuNhapId;

import java.util.List;

public interface ChiTietPhieuNhapRepository extends JpaRepository<ChiTietPhieuNhap, ChiTietPhieuNhapId> {
}