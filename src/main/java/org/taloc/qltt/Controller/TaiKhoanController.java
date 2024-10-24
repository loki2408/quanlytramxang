package org.taloc.qltt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.taloc.qltt.DTO.TaiKhoanDTO;
import org.taloc.qltt.Service.TaiKhoanService;

import java.util.List;

@RestController
@RequestMapping("/api/taikhoan")
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping
    public ResponseEntity<List<TaiKhoanDTO>> getAllTaiKhoan() {
        List<TaiKhoanDTO> taiKhoans = taiKhoanService.getAllTaiKhoan();
        return ResponseEntity.ok(taiKhoans);
    }

    @PutMapping("/doimatkhau/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable int id, @RequestBody String newPassword) {
        try {
            taiKhoanService.updatePassword(id, newPassword);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
