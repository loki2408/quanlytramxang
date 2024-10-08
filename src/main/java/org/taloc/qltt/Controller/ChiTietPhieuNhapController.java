package org.taloc.qltt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.taloc.qltt.DTO.ChiTietPhieuNhapDTO;
import org.taloc.qltt.Model.ChiTietPhieuNhapId;
import org.taloc.qltt.Service.ChiTietPhieuNhapService;

import java.util.List;

@RestController
@RequestMapping("/api/chitietphieunhap")
public class ChiTietPhieuNhapController {

    @Autowired
    private ChiTietPhieuNhapService chiTietPhieuNhapService;

    @PostMapping
    public ResponseEntity<ChiTietPhieuNhapDTO> createChiTietPhieuNhap(@RequestBody ChiTietPhieuNhapDTO chiTietPhieuNhapDTO) {
        ChiTietPhieuNhapDTO createdChiTiet = chiTietPhieuNhapService.createChiTietPhieuNhap(chiTietPhieuNhapDTO);
        return ResponseEntity.ok(createdChiTiet);
    }

    @GetMapping
    public ResponseEntity<List<ChiTietPhieuNhapDTO>> getAllChiTietPhieuNhap() {
        List<ChiTietPhieuNhapDTO> chiTietList = chiTietPhieuNhapService.getAllChiTietPhieuNhap();
        return ResponseEntity.ok(chiTietList);
    }

    @PutMapping
    public ResponseEntity<ChiTietPhieuNhapDTO> updateChiTietPhieuNhap(@RequestBody ChiTietPhieuNhapDTO chiTietPhieuNhapDTO) {
        ChiTietPhieuNhapDTO updatedChiTiet = chiTietPhieuNhapService.updateChiTietPhieuNhap(chiTietPhieuNhapDTO);
        return ResponseEntity.ok(updatedChiTiet);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteChiTietPhieuNhap(@RequestParam Integer maPhieuNhap, @RequestParam Integer maXangDau) {
        chiTietPhieuNhapService.deleteChiTietPhieuNhap(maPhieuNhap, maXangDau);
        return ResponseEntity.noContent().build();
    }
}