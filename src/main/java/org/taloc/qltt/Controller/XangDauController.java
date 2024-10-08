package org.taloc.qltt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.taloc.qltt.DTO.XangDauDTO;
import org.taloc.qltt.Service.XangDauService;

import java.util.List;

@RestController
@RequestMapping("/api/xangdau")
public class XangDauController {

    @Autowired
    private XangDauService xangDauService;

    @GetMapping
    public List<XangDauDTO> getAllXangDau() {
        return xangDauService.getAllXangDau();
    }

    @GetMapping("/{maXangDau}")
    public ResponseEntity<XangDauDTO> getXangDauById(@PathVariable Integer maXangDau) {
        XangDauDTO xangDau = xangDauService.getXangDauById(maXangDau);
        return ResponseEntity.ok(xangDau);
    }

    @PostMapping
    public ResponseEntity<XangDauDTO> createXangDau(@RequestBody XangDauDTO xangDauDTO) {
        XangDauDTO createdXangDau = xangDauService.createXangDau(xangDauDTO);
        return ResponseEntity.ok(createdXangDau);
    }

    @PutMapping("/{maXangDau}")
    public ResponseEntity<XangDauDTO> updateXangDau(@PathVariable Integer maXangDau, @RequestBody XangDauDTO xangDauDTO) {
        xangDauDTO.setMaXangDau(maXangDau);
        XangDauDTO updatedXangDau = xangDauService.updateXangDau(xangDauDTO);
        return ResponseEntity.ok(updatedXangDau);
    }

    @DeleteMapping("/{maXangDau}")
    public ResponseEntity<Void> deleteXangDau(@PathVariable Integer maXangDau) {
        xangDauService.deleteXangDau(maXangDau);
        return ResponseEntity.noContent().build();
    }
}
