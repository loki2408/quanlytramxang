package org.taloc.qltt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.taloc.qltt.Model.TaiKhoan;
import org.taloc.qltt.Service.TaiKhoanService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/taikhoan")
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @PostMapping
    public ResponseEntity<TaiKhoan> createTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
        try {
            TaiKhoan createdTaiKhoan = taiKhoanService.createTaiKhoan(taiKhoan);
            return ResponseEntity.ok(createdTaiKhoan);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<TaiKhoan>> getAllTaiKhoan() {
        List<TaiKhoan> taiKhoans = taiKhoanService.getAllTaiKhoan();
        return ResponseEntity.ok(taiKhoans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaiKhoan> getTaiKhoanById(@PathVariable int id) {
        Optional<TaiKhoan> taiKhoanOpt = taiKhoanService.getTaiKhoanById(id);
        return taiKhoanOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<TaiKhoan> updateTaiKhoan(@RequestBody TaiKhoan updatedTaiKhoan) {
        try {
            TaiKhoan updatedTaiKhoanEntity = taiKhoanService.updateTaiKhoan(updatedTaiKhoan);
            return ResponseEntity.ok(updatedTaiKhoanEntity);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/doimatkhau/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable int id, @RequestBody Map<String, String> request) {
        String newPassword = request.get("password");
        try {
            taiKhoanService.updatePassword(id, newPassword);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaiKhoan(@PathVariable int id) {
        try {
            taiKhoanService.deleteTaiKhoan(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
