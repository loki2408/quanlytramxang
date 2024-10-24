package org.taloc.qltt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taloc.qltt.DTO.TaiKhoanDTO;
import org.taloc.qltt.Model.NhanVien;
import org.taloc.qltt.Model.TaiKhoan;
import org.taloc.qltt.Repository.TaiKhoanRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    public List<TaiKhoanDTO> getAllTaiKhoan() {
        return taiKhoanRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private TaiKhoanDTO convertToDTO(TaiKhoan taiKhoan) {
        TaiKhoanDTO dto = new TaiKhoanDTO();
        dto.setId(taiKhoan.getId());
        dto.setUsername(taiKhoan.getUsername());
        dto.setRole(taiKhoan.getRole());

        NhanVien nhanVien = taiKhoan.getNhanVien();
        if (nhanVien != null) {
            dto.setTenNhanVien(nhanVien.getTenNhanVien());
        }

        return dto;
    }

    public void updatePassword(int id, String newPassword) {
        Optional<TaiKhoan> existingTaiKhoanOpt = taiKhoanRepository.findById(id);
        if (!existingTaiKhoanOpt.isPresent()) {
            throw new IllegalArgumentException("Tài khoản không tồn tại");
        }

        TaiKhoan existingTaiKhoan = existingTaiKhoanOpt.get();
        existingTaiKhoan.setPassword(newPassword); // Thay thế bằng mã hóa mật khẩu nếu cần
        taiKhoanRepository.save(existingTaiKhoan);
    }
}
