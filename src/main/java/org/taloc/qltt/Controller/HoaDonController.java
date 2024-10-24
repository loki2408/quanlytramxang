package org.taloc.qltt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.taloc.qltt.DTO.*;
import org.taloc.qltt.Model.HoaDon;
import org.taloc.qltt.Repository.HoaDonRepository;
import org.taloc.qltt.Service.ChiTietHoaDonService;
import org.taloc.qltt.Service.HoaDonService;
import org.taloc.qltt.Service.TramXangService;
import org.taloc.qltt.Service.NhanVienService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/hoadon")
public class HoaDonController {

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private TramXangService tramXangService;

    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;

    // **Serve the HTML page for HoaDon**
    @GetMapping("/view")
    public String showHoaDonPage(Model model) {
        model.addAttribute("tramXangs", tramXangService.getAllTramXang());
        model.addAttribute("nhanViens", nhanVienService.getAllNhanVien());
        return "hoadon";  // Phải trỏ đúng tên file HTML
    }

    // **Create a new HoaDon**
    @PostMapping
    public ResponseEntity<HoaDonDTO> createHoaDon(@RequestBody HoaDonDTO hoaDonDTO) {
        HoaDonDTO createdHoaDon = hoaDonService.createHoaDon(hoaDonDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHoaDon);
    }

    // **Get all invoices (HoaDon)**
// HoaDonController.java
    @GetMapping("/all")
    public ResponseEntity<List<HoaDonDTO>> getAllHoaDon() {
        List<HoaDonDTO> hoaDonList = hoaDonService.getAllHoaDon();

        hoaDonList.forEach(hoaDon -> {
            Optional<String> tenTram = tramXangService.getTenTramById(hoaDon.getMaTram());
            tenTram.ifPresent(hoaDon::setTenTram);

            Optional<NhanVienDTO> nhanVienDTO = nhanVienService.getNhanVienById(hoaDon.getMaNhanVien());
            nhanVienDTO.ifPresent(nv -> hoaDon.setTenNhanVien(nv.getTenNhanVien()));
        });

        return ResponseEntity.ok(hoaDonList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<HoaDonDTO> getHoaDonById(@PathVariable int id) {
        HoaDon hoaDon = hoaDonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hóa đơn không tồn tại"));
        HoaDonDTO hoaDonDTO = new HoaDonDTO(hoaDon);
        return ResponseEntity.ok(hoaDonDTO);
    }

    @GetMapping("/detail/{hoaDonId}")
    public ResponseEntity<HoaDonDTO> getHoaDonDetail(@PathVariable int hoaDonId) {
        HoaDon hoaDon = hoaDonRepository.findById(hoaDonId)
                .orElseThrow(() -> new RuntimeException("Hóa đơn không tồn tại"));
        HoaDonDTO hoaDonDTO = new HoaDonDTO(hoaDon);
        return ResponseEntity.ok(hoaDonDTO);
    }



    // **Update an existing invoice**
    @PutMapping("/{id}")
    public ResponseEntity<HoaDonDTO> updateHoaDon(@PathVariable int id, @RequestBody HoaDonDTO hoaDonDTO) {
        HoaDonDTO updatedHoaDon = hoaDonService.updateHoaDon(id, hoaDonDTO);
        return ResponseEntity.ok(updatedHoaDon);
    }

    // **Delete an invoice**
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoaDon(@PathVariable int id) {
        hoaDonService.deleteHoaDon(id);
        return ResponseEntity.noContent().build();
    }

    // API để tính tổng doanh thu trong khoảng thời gian
    @GetMapping("/doanhthu")
    public ResponseEntity<Double> getDoanhThu(
            @RequestParam String startDate, @RequestParam String endDate) {
        double doanhThu = hoaDonService.tinhTongDoanhThu(startDate, endDate);
        return ResponseEntity.ok(doanhThu);
    }

    // API để lấy doanh thu theo loại xăng dầu
    @GetMapping("/doanhthu/xangdau")
    public ResponseEntity<List<DoanhThuXangDauDTO>> getDoanhThuTheoXangDau() {
        List<DoanhThuXangDauDTO> doanhThuList = hoaDonService.getDoanhThuTheoXangDau();
        return ResponseEntity.ok(doanhThuList);
    }

}
