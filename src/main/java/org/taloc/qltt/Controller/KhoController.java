package org.taloc.qltt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.taloc.qltt.Model.Kho;
import org.taloc.qltt.Service.KhoService;

import java.util.List;

@RestController
@RequestMapping("/api/kho")
public class KhoController {

    @Autowired
    private KhoService khoService;

    @GetMapping
    public List<Kho> getAllKhos() {
        return khoService.getAllKhos();
    }

    @GetMapping("/{id}")
    public Kho getKhoById(@PathVariable int id) {
        return khoService.getKhoById(id);
    }

    @PostMapping
    public Kho addKho(@RequestBody Kho kho) {
        return khoService.saveKho(kho);
    }

    @PutMapping("/{id}")
    public Kho updateKho(@PathVariable int id, @RequestBody Kho kho) {
        return khoService.updateKho(id, kho);
    }

    @DeleteMapping("/{id}")
    public void deleteKho(@PathVariable int id) {
        khoService.deleteKho(id);
    }
    @GetMapping("/kho")
    public String viewKhoPage() {
        return "kho"; // Tên file HTML không cần phần mở rộng
    }
}
