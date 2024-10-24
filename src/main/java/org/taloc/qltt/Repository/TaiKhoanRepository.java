package org.taloc.qltt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taloc.qltt.Model.TaiKhoan;

import java.util.Optional;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
    Optional<TaiKhoan> findByUsername(String username);
    boolean existsByUsername(String username);

    Optional<TaiKhoan> findByNhanVien_MaNhanVien(Integer maNhanVien);
}