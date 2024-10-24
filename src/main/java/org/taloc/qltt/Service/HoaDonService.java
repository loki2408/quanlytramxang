package org.taloc.qltt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taloc.qltt.DTO.DoanhThuDTO;
import org.taloc.qltt.DTO.DoanhThuXangDauDTO;
import org.taloc.qltt.Model.HoaDon;
import org.taloc.qltt.Model.TramXang;
import org.taloc.qltt.Model.NhanVien;
import org.taloc.qltt.DTO.HoaDonDTO;
import org.taloc.qltt.Repository.HoaDonRepository;
import org.taloc.qltt.Repository.TramXangRepository;
import org.taloc.qltt.Repository.NhanVienRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private TramXangRepository tramXangRepository;

    @Autowired
    private NhanVienRepository nhanVienRepository;


    public HoaDonDTO createHoaDon(HoaDonDTO hoaDonDTO) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setTenKhachHang(hoaDonDTO.getTenKhachHang());
        hoaDon.setNgayLap(hoaDonDTO.getNgayLap());

        // Lấy đối tượng TramXang và NhanVien từ database
        TramXang tramXang = tramXangRepository.findById(hoaDonDTO.getMaTram())
                .orElseThrow(() -> new RuntimeException("Trạm xăng không tồn tại"));
        hoaDon.setTramXang(tramXang);

        NhanVien nhanVien = nhanVienRepository.findById(hoaDonDTO.getMaNhanVien())
                .orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));
        hoaDon.setNhanVien(nhanVien);

        hoaDon = hoaDonRepository.save(hoaDon);

        // Gán mã hóa đơn vào DTO
        hoaDonDTO.setMaHoaDon(hoaDon.getMaHoaDon());

        return hoaDonDTO;
    }




    public void updateTongTien(int id, double tongTien) {
        HoaDon hoaDon = hoaDonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hóa đơn không tồn tại"));
        hoaDon.setTongTien(tongTien);  // Cập nhật tổng tiền
        hoaDonRepository.save(hoaDon);
    }

    public List<HoaDonDTO> getAllHoaDon() {
        return hoaDonRepository.findAll().stream().map(hoaDon -> {
            HoaDonDTO dto = new HoaDonDTO();
            dto.setMaHoaDon(hoaDon.getMaHoaDon());
            dto.setMaTram(hoaDon.getTramXang().getMaTram());
            dto.setMaNhanVien(hoaDon.getNhanVien().getMaNhanVien());
            dto.setTenKhachHang(hoaDon.getTenKhachHang());
            dto.setNgayLap(hoaDon.getNgayLap());
            dto.setTongTien(hoaDon.getTongTien());
            return dto;
        }).collect(Collectors.toList());
    }


    // Get an invoice by ID
    public HoaDonDTO getHoaDonById(int id) {
        HoaDon hoaDon = hoaDonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        return convertToDTO(hoaDon);
    }

    // Update an existing invoice
    public HoaDonDTO updateHoaDon(int id, HoaDonDTO hoaDonDTO) {
        HoaDon existingHoaDon = hoaDonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        existingHoaDon.setTenKhachHang(hoaDonDTO.getTenKhachHang());
        existingHoaDon.setNgayLap(hoaDonDTO.getNgayLap());

        // Fetch TramXang and NhanVien from the database to avoid null issues
        TramXang tramXang = tramXangRepository.findById(hoaDonDTO.getMaTram())
                .orElseThrow(() -> new RuntimeException("Gas station not found"));
        existingHoaDon.setTramXang(tramXang);

        NhanVien nhanVien = nhanVienRepository.findById(hoaDonDTO.getMaNhanVien())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existingHoaDon.setNhanVien(nhanVien);

        hoaDonRepository.save(existingHoaDon);
        return hoaDonDTO;
    }

    // Delete an invoice
    public void deleteHoaDon(int id) {
        hoaDonRepository.deleteById(id);
    }

    // Helper method to convert HoaDon to HoaDonDTO
    private HoaDonDTO convertToDTO(HoaDon hoaDon) {
        HoaDonDTO dto = new HoaDonDTO();
        dto.setMaHoaDon(hoaDon.getMaHoaDon());
        dto.setTenKhachHang(hoaDon.getTenKhachHang());
        dto.setNgayLap(hoaDon.getNgayLap());

        // Safely get IDs to avoid NullPointerException
        if (hoaDon.getTramXang() != null) {
            dto.setMaTram(hoaDon.getTramXang().getMaTram());
        }
        if (hoaDon.getNhanVien() != null) {
            dto.setMaNhanVien(hoaDon.getNhanVien().getMaNhanVien());
        }

        dto.setTongTien(hoaDon.getTongTien());
        return dto;
    }

    // Tính tổng doanh thu trong khoảng thời gian
    public double tinhTongDoanhThu(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return hoaDonRepository.findByNgayLapBetween(start, end)
                .stream()
                .mapToDouble(HoaDon::getTongTien)
                .sum();
    }

    // Lấy doanh thu theo loại xăng dầu
    public List<DoanhThuXangDauDTO> getDoanhThuTheoXangDau() {
        return hoaDonRepository.findAll()
                .stream()
                .flatMap(hoaDon -> hoaDon.getChiTietHoaDonList().stream())
                .collect(Collectors.groupingBy(
                        chiTiet -> chiTiet.getXangDau().getTenXangDau(),
                        Collectors.summingDouble(chiTiet -> chiTiet.getThanhTien())
                ))
                .entrySet().stream()
                .map(entry -> new DoanhThuXangDauDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
