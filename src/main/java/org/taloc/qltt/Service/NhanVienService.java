package org.taloc.qltt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.taloc.qltt.DTO.NhanVienDTO;
import org.taloc.qltt.Model.NhanVien;
import org.taloc.qltt.Model.TaiKhoan;
import org.taloc.qltt.Repository.NhanVienRepository;
import org.taloc.qltt.Repository.TaiKhoanRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public NhanVienDTO createNhanVien(NhanVienDTO nhanVienDTO) {
        // Convert DTO to entity
        NhanVien nhanVien = convertToEntity(nhanVienDTO);

        // Save employee information
        NhanVien savedNhanVien = nhanVienRepository.save(nhanVien);

        // Create a corresponding account for the employee using their phone number
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setUsername(savedNhanVien.getSoDienThoai());
        taiKhoan.setPassword(passwordEncoder.encode(savedNhanVien.getSoDienThoai()));

        // Assign role based on employee's position
        if ("TRUONG_TRAM".equalsIgnoreCase(savedNhanVien.getChucVu())) {
            taiKhoan.setRole("TRUONG_TRAM");
        } else {
            taiKhoan.setRole("NHAN_VIEN");
        }

        taiKhoan.setNhanVien(savedNhanVien);

        // Save account information
        taiKhoanRepository.save(taiKhoan);

        return convertToDTO(savedNhanVien);
    }

    public List<NhanVienDTO> getAllNhanVien() {
        List<NhanVien> nhanViens = nhanVienRepository.findAll();
        return nhanViens.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public NhanVienDTO updateNhanVien(int id, NhanVienDTO updatedNhanVienDTO) {
        Optional<NhanVien> existingNhanVienOpt = nhanVienRepository.findById(id);
        if (!existingNhanVienOpt.isPresent()) {
            throw new IllegalArgumentException("Nhân viên không tồn tại");
        }

        NhanVien existingNhanVien = existingNhanVienOpt.get();
        existingNhanVien.setTenNhanVien(updatedNhanVienDTO.getTenNhanVien());
        existingNhanVien.setDiaChi(updatedNhanVienDTO.getDiaChi());
        existingNhanVien.setSoDienThoai(updatedNhanVienDTO.getSoDienThoai());
        existingNhanVien.setChucVu(updatedNhanVienDTO.getChucVu());
        existingNhanVien.setNgaySinh(updatedNhanVienDTO.getNgaySinh());

        // Save updated employee
        NhanVien savedNhanVien = nhanVienRepository.save(existingNhanVien);

        // Update the linked account if phone number or position changes
        Optional<TaiKhoan> taiKhoanOpt = taiKhoanRepository.findByNhanVien_MaNhanVien(savedNhanVien.getMaNhanVien());
        if (taiKhoanOpt.isPresent()) {
            TaiKhoan taiKhoan = taiKhoanOpt.get();
            taiKhoan.setUsername(updatedNhanVienDTO.getSoDienThoai());
            taiKhoan.setPassword(passwordEncoder.encode(updatedNhanVienDTO.getSoDienThoai()));

            // Update role if position has changed
            if ("TRUONG_TRAM".equalsIgnoreCase(updatedNhanVienDTO.getChucVu())) {
                taiKhoan.setRole("TRUONG_TRAM");
            } else {
                taiKhoan.setRole("NHAN_VIEN");
            }

            taiKhoanRepository.save(taiKhoan);
        }

        return convertToDTO(savedNhanVien);
    }

    public void deleteNhanVien(int id) {
        if (!nhanVienRepository.existsById(id)) {
            throw new IllegalArgumentException("Nhân viên không tồn tại");
        }

        // Delete the linked account
        Optional<TaiKhoan> taiKhoanOpt = taiKhoanRepository.findByNhanVien_MaNhanVien(id);
        taiKhoanOpt.ifPresent(taiKhoanRepository::delete);

        // Delete the employee
        nhanVienRepository.deleteById(id);
    }

    // Convert NhanVien to NhanVienDTO
    private NhanVienDTO convertToDTO(NhanVien nhanVien) {
        NhanVienDTO dto = new NhanVienDTO();
        dto.setMaNhanVien(nhanVien.getMaNhanVien());
        dto.setTenNhanVien(nhanVien.getTenNhanVien());
        dto.setChucVu(nhanVien.getChucVu());
        dto.setDiaChi(nhanVien.getDiaChi());
        dto.setNgaySinh(nhanVien.getNgaySinh());
        dto.setSoDienThoai(nhanVien.getSoDienThoai());
        return dto;
    }
    public Optional<NhanVienDTO> getNhanVienById(int id) {
        return nhanVienRepository.findById(id).map(this::convertToDTO);
    }
    // Convert NhanVienDTO to NhanVien
    private NhanVien convertToEntity(NhanVienDTO dto) {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNhanVien(dto.getMaNhanVien());
        nhanVien.setTenNhanVien(dto.getTenNhanVien());
        nhanVien.setChucVu(dto.getChucVu());
        nhanVien.setDiaChi(dto.getDiaChi());
        nhanVien.setNgaySinh(dto.getNgaySinh());
        nhanVien.setSoDienThoai(dto.getSoDienThoai());
        return nhanVien;
    }
}
