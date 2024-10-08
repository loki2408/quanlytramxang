package org.taloc.qltt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.taloc.qltt.Model.ChiTietHoaDon;
import org.taloc.qltt.Model.ChiTietHoaDonId;
import org.taloc.qltt.Service.ChiTietHoaDonService;

import java.util.List;

@RestController
@RequestMapping("/api/chitiethoadon")
public class ChiTietHoaDonController {

    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;

    @GetMapping
    public List<ChiTietHoaDon> getAllChiTietHoaDon() {
        return chiTietHoaDonService.getAllChiTietHoaDons();
    }

    @GetMapping("/{maHoaDon}/{maXangDau}")
    public ChiTietHoaDon getChiTietHoaDonById(@PathVariable int maHoaDon, @PathVariable int maXangDau) {
        ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
        chiTietHoaDonId.setMaHoaDon(maHoaDon);
        chiTietHoaDonId.setMaXangDau(maXangDau);
        return chiTietHoaDonService.getChiTietHoaDonById(chiTietHoaDonId);
    }

    @PostMapping
    public ChiTietHoaDon addChiTietHoaDon(@RequestBody ChiTietHoaDon chiTietHoaDon) {
        return chiTietHoaDonService.saveChiTietHoaDon(chiTietHoaDon);
    }

    @PutMapping("/{maHoaDon}/{maXangDau}")
    public ChiTietHoaDon updateChiTietHoaDon(@PathVariable int maHoaDon, @PathVariable int maXangDau, @RequestBody ChiTietHoaDon chiTietHoaDon) {
        ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
        chiTietHoaDonId.setMaHoaDon(maHoaDon);
        chiTietHoaDonId.setMaXangDau(maXangDau);
        return chiTietHoaDonService.updateChiTietHoaDon(chiTietHoaDonId, chiTietHoaDon);
    }

    @DeleteMapping("/{maHoaDon}/{maXangDau}")
    public void deleteChiTietHoaDon(@PathVariable int maHoaDon, @PathVariable int maXangDau) {
        ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
        chiTietHoaDonId.setMaHoaDon(maHoaDon);
        chiTietHoaDonId.setMaXangDau(maXangDau);
        chiTietHoaDonService.deleteChiTietHoaDon(chiTietHoaDonId);
    }
}
