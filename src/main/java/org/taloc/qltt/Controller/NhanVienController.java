package org.taloc.qltt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.taloc.qltt.Model.NhanVien;
import org.taloc.qltt.Service.NhanVienService;

import java.util.List;

@RestController
@RequestMapping("/api/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public List<NhanVien> getAllNhanViens() {
        return nhanVienService.getAllNhanViens();
    }

    @GetMapping("/{id}")
    public NhanVien getNhanVienById(@PathVariable int id) {
        return nhanVienService.getNhanVienById(id);
    }

    @PostMapping
    public NhanVien addNhanVien(@RequestBody NhanVien nhanVien) {
        return nhanVienService.saveNhanVien(nhanVien);
    }

    @PutMapping("/{id}")
    public NhanVien updateNhanVien(@PathVariable int id, @RequestBody NhanVien nhanVien) {
        return nhanVienService.updateNhanVien(id, nhanVien);
    }

    @DeleteMapping("/{id}")
    public void deleteNhanVien(@PathVariable int id) {
        nhanVienService.deleteNhanVien(id);
    }
}
