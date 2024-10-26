

package org.taloc.qltt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.taloc.qltt.DTO.DoanhThuDTO;
import org.taloc.qltt.Service.DoanhThuService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/doanhthu")
public class DoanhThuController {

    @Autowired
    private DoanhThuService doanhThuService;

    @GetMapping("/ngay")
    public List<DoanhThuDTO> getDoanhThuTheoNgay(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate) {
        return doanhThuService.tinhDoanhThuTheoNgay(startDate, endDate);
    }

    @GetMapping("/thang")
    public List<DoanhThuDTO> getDoanhThuTheoThang() {
        return doanhThuService.tinhDoanhThuTheoThang();
    }

    @GetMapping("/nam")
    public List<DoanhThuDTO> getDoanhThuTheoNam() {
        return doanhThuService.tinhDoanhThuTheoNam();
    }

    @GetMapping("/tram")
    public List<DoanhThuDTO> getDoanhThuTheoTram() {
        return doanhThuService.tinhDoanhThuTheoTram();
    }
}
