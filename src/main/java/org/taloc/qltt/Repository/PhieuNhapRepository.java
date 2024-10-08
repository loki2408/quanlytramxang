package org.taloc.qltt.Repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.taloc.qltt.Model.PhieuNhap;

import java.util.List;

public interface PhieuNhapRepository extends JpaRepository<PhieuNhap, Integer> {
    @Query(value = "SELECT MAX(ma_phieu_nhap) + 1 FROM phieunhap", nativeQuery = true)
    Integer getNextId();

    @EntityGraph(attributePaths = {"tramXang"})
    List<PhieuNhap> findAll();
}