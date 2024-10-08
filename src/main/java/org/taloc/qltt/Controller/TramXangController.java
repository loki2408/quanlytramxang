package org.taloc.qltt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.taloc.qltt.DTO.TramXangDTO;
import org.taloc.qltt.Service.TramXangService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tramxang")
public class TramXangController {

    @Autowired
    private TramXangService tramXangService;

    @GetMapping
    public List<TramXangDTO> getAllTramXang() {
        return tramXangService.getAllTramXang();
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<TramXangDTO> createTramXang(
            @RequestParam("tenTram") String tenTram,
            @RequestParam("diaChi") String diaChi,
            @RequestParam("truongTram") String truongTram,
            @RequestParam("kinhDo") Float kinhDo,
            @RequestParam("viDo") Float viDo,
            @RequestParam(value = "hinhAnh", required = false) MultipartFile hinhAnh) {

        TramXangDTO tramXangDTO = new TramXangDTO();
        tramXangDTO.setTenTram(tenTram);
        tramXangDTO.setDiaChi(diaChi);
        tramXangDTO.setTruongTram(truongTram);
        tramXangDTO.setKinhDo(kinhDo);
        tramXangDTO.setViDo(viDo);
        tramXangDTO.setHinhAnh(hinhAnh);

        TramXangDTO createdTramXang = tramXangService.createTramXang(tramXangDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdTramXang.getMaTram()).toUri();

        return ResponseEntity.created(uri).body(createdTramXang);
    }

    @PutMapping(value = "/{maTram}", consumes = {"multipart/form-data"})
    public ResponseEntity<TramXangDTO> updateTramXang(
            @PathVariable int maTram,
            @RequestParam("tenTram") String tenTram,
            @RequestParam("diaChi") String diaChi,
            @RequestParam("truongTram") String truongTram,
            @RequestParam("kinhDo") Float kinhDo,
            @RequestParam("viDo") Float viDo,
            @RequestParam(value = "hinhAnh", required = false) MultipartFile hinhAnh) {

        TramXangDTO tramXangDTO = new TramXangDTO();
        tramXangDTO.setMaTram(maTram);
        tramXangDTO.setTenTram(tenTram);
        tramXangDTO.setDiaChi(diaChi);
        tramXangDTO.setTruongTram(truongTram);
        tramXangDTO.setKinhDo(kinhDo);
        tramXangDTO.setViDo(viDo);
        tramXangDTO.setHinhAnh(hinhAnh);

        TramXangDTO updatedTramXang = tramXangService.updateTramXang(tramXangDTO);

        return ResponseEntity.ok(updatedTramXang);
    }

    @DeleteMapping("/{maTram}")
    public ResponseEntity<Void> deleteTramXang(@PathVariable int maTram) {
        tramXangService.deleteTramXang(maTram);
        return ResponseEntity.noContent().build();
    }
}
