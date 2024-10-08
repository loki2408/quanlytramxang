package org.taloc.qltt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.taloc.qltt.Model.HoaDon;
import org.taloc.qltt.Service.HoaDonService;

import java.util.List;

@RestController
@RequestMapping("/api/hoadon")
public class HoaDonController {

    @Autowired
    private HoaDonService hoaDonService;

    @GetMapping
    public List<HoaDon> getAllHoaDons() {
        return hoaDonService.getAllHoaDons();
    }

    @GetMapping("/{id}")
    public HoaDon getHoaDonById(@PathVariable int id) {
        return hoaDonService.getHoaDonById(id);
    }

    @PostMapping
    public HoaDon addHoaDon(@RequestBody HoaDon hoaDon) {
        return hoaDonService.saveHoaDon(hoaDon);
    }

    @PutMapping("/{id}")
    public HoaDon updateHoaDon(@PathVariable int id, @RequestBody HoaDon hoaDon) {
        return hoaDonService.updateHoaDon(id, hoaDon);
    }

    @DeleteMapping("/{id}")
    public void deleteHoaDon(@PathVariable int id) {
        hoaDonService.deleteHoaDon(id);
    }
}
