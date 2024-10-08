package org.taloc.qltt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taloc.qltt.Model.NhanVien;
import org.taloc.qltt.Repository.NhanVienRepository;

import java.util.List;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> getAllNhanViens() {
        return nhanVienRepository.findAll();
    }

    public NhanVien getNhanVienById(int id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    public NhanVien saveNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public NhanVien updateNhanVien(int id, NhanVien nhanVien) {
        if (nhanVienRepository.existsById(id)) {
            nhanVien.setMaNhanVien(id);
            return nhanVienRepository.save(nhanVien);
        }
        return null;
    }

    public void deleteNhanVien(int id) {
        nhanVienRepository.deleteById(id);
    }
}
