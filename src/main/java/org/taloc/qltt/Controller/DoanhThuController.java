//package org.taloc.qltt.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.taloc.qltt.DTO.DoanhThuDTO;
//import org.taloc.qltt.Service.DoanhThuService;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/doanhthu")
//public class DoanhThuController {
//
//    @Autowired
//    private DoanhThuService doanhThuService;
//
//    @GetMapping("/ngay")
//    public ResponseEntity<List<DoanhThuDTO>> getDoanhThuTheoNgay() {
//        List<DoanhThuDTO> doanhThuList = doanhThuService.getDoanhThuTheoNgay();
//        return ResponseEntity.ok(doanhThuList);
//    }
//
//    @GetMapping("/thang")
//    public ResponseEntity<List<DoanhThuDTO>> getDoanhThuTheoThang() {
//        List<DoanhThuDTO> doanhThuList = doanhThuService.getDoanhThuTheoThang();
//        return ResponseEntity.ok(doanhThuList);
//    }
//
//    @GetMapping("/nam")
//    public ResponseEntity<List<DoanhThuDTO>> getDoanhThuTheoNam() {
//        List<DoanhThuDTO> doanhThuList = doanhThuService.getDoanhThuTheoNam();
//        return ResponseEntity.ok(doanhThuList);
//    }
//
//    @GetMapping("/tram")
//    public ResponseEntity<List<DoanhThuDTO>> getDoanhThuTheoTram() {
//        List<DoanhThuDTO> doanhThuList = doanhThuService.getDoanhThuTheoTram();
//        return ResponseEntity.ok(doanhThuList);
//    }
//}
