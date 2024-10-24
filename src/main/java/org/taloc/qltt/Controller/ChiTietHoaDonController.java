package org.taloc.qltt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.taloc.qltt.DTO.ChiTietHoaDonDTO;
import org.taloc.qltt.Service.ChiTietHoaDonService;

import java.util.List;

@RestController
@RequestMapping("/api/chitiethoadon")
public class ChiTietHoaDonController {

    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;

    // Lấy tất cả chi tiết hóa đơn
    @GetMapping("/all")
    public ResponseEntity<List<ChiTietHoaDonDTO>> getAllChiTietHoaDon() {
        List<ChiTietHoaDonDTO> chiTietList = chiTietHoaDonService.getAllChiTietHoaDon();
        return ResponseEntity.ok(chiTietList);
    }

    // Thêm mới chi tiết hóa đơn
    @PostMapping("/add")
    public ResponseEntity<String> addChiTietHoaDon(@RequestBody List<ChiTietHoaDonDTO> chiTietHoaDonDTOList) {
        try {
            System.out.println("Nhận được: " + chiTietHoaDonDTOList);
            chiTietHoaDonDTOList.forEach(chiTietHoaDonService::addChiTietHoaDon);
            return ResponseEntity.ok("Thêm chi tiết hóa đơn thành công.");
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    // Xóa chi tiết hóa đơn dựa trên mã hóa đơn và mã xăng dầu
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteChiTietHoaDon(
            @RequestParam("hoaDon") int hoaDonId,
            @RequestParam("xangDau") int xangDauId) {
        try {
            chiTietHoaDonService.deleteChiTietHoaDon(hoaDonId, xangDauId);
            return ResponseEntity.ok("Xóa chi tiết hóa đơn thành công.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/hoadon/{hoaDonId}")
    public ResponseEntity<List<ChiTietHoaDonDTO>> getChiTietByHoaDonId(@PathVariable int hoaDonId) {
        List<ChiTietHoaDonDTO> chiTietList = chiTietHoaDonService.getChiTietByHoaDonId(hoaDonId);
        return ResponseEntity.ok(chiTietList);
    }


}
