package org.taloc.qltt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.taloc.qltt.DTO.NhanVienDTO;
import org.taloc.qltt.Service.NhanVienService;

import java.util.List;

@RestController
@RequestMapping("/api/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @PostMapping
    public ResponseEntity<NhanVienDTO> createNhanVien(@RequestBody NhanVienDTO nhanVienDTO) {
        try {
            NhanVienDTO createdNhanVien = nhanVienService.createNhanVien(nhanVienDTO);
            return ResponseEntity.ok(createdNhanVien);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<NhanVienDTO>> getAllNhanVien() {
        try {
            List<NhanVienDTO> nhanViens = nhanVienService.getAllNhanVien();
            return ResponseEntity.ok(nhanViens);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhanVienDTO> updateNhanVien(@PathVariable int id, @RequestBody NhanVienDTO updatedNhanVien) {
        try {
            NhanVienDTO updatedNhanVienEntity = nhanVienService.updateNhanVien(id, updatedNhanVien);
            return ResponseEntity.ok(updatedNhanVienEntity);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhanVien(@PathVariable int id) {
        try {
            nhanVienService.deleteNhanVien(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVienDTO> getNhanVienById(@PathVariable int id) {
        try {
            NhanVienDTO nhanVienDTO = nhanVienService.getNhanVienById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Nhân viên không tồn tại"));
            return ResponseEntity.ok(nhanVienDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
