package org.taloc.qltt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.taloc.qltt.DTO.PhieuNhapDTO;
import org.taloc.qltt.Service.PhieuNhapService;
import org.taloc.qltt.Service.TramXangService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phieunhap")
public class PhieuNhapController {

    @Autowired
    private PhieuNhapService phieuNhapService;

    @Autowired
    private TramXangService tramXangService;

    @PostMapping
    public ResponseEntity<PhieuNhapDTO> createPhieuNhap(@RequestBody PhieuNhapDTO phieuNhapDTO) {
        PhieuNhapDTO createdPhieuNhap = phieuNhapService.createPhieuNhap(phieuNhapDTO);
        return ResponseEntity.ok(createdPhieuNhap);
    }

    @GetMapping
    public ResponseEntity<List<PhieuNhapDTO>> getAllPhieuNhap() {
        List<PhieuNhapDTO> phieuNhapList = phieuNhapService.getAllPhieuNhap();
        phieuNhapList.forEach(phieuNhap -> {
            Optional<String> tenTram = tramXangService.getTenTramById(phieuNhap.getMaTram());
            tenTram.ifPresent(phieuNhap::setTenTram); // Thiết lập tên trạm từ TramXangService
        });
        return ResponseEntity.ok(phieuNhapList);
    }
    @GetMapping("/{maPhieuNhap}")
    public ResponseEntity<PhieuNhapDTO> getPhieuNhapById(@PathVariable Integer maPhieuNhap) {
        PhieuNhapDTO phieuNhapDTO = phieuNhapService.getPhieuNhapById(maPhieuNhap);
        return ResponseEntity.ok(phieuNhapDTO);
    }


    @PutMapping("/{maPhieuNhap}")
    public ResponseEntity<PhieuNhapDTO> updatePhieuNhap(@PathVariable Integer maPhieuNhap, @RequestBody PhieuNhapDTO phieuNhapDTO) {
        PhieuNhapDTO updatedPhieuNhap = phieuNhapService.updatePhieuNhap(maPhieuNhap, phieuNhapDTO);
        return ResponseEntity.ok(updatedPhieuNhap);
    }

    @DeleteMapping("/{maPhieuNhap}")
    public ResponseEntity<Void> deletePhieuNhap(@PathVariable Integer maPhieuNhap) {
        phieuNhapService.deletePhieuNhap(maPhieuNhap);
        return ResponseEntity.noContent().build();
    }
}