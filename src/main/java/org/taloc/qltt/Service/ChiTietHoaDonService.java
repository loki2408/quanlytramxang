package org.taloc.qltt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taloc.qltt.DTO.ChiTietHoaDonDTO;
import org.taloc.qltt.Model.ChiTietHoaDon;
import org.taloc.qltt.Model.ChiTietHoaDonId;
import org.taloc.qltt.Model.HoaDon;
import org.taloc.qltt.Model.XangDau;
import org.taloc.qltt.Repository.ChiTietHoaDonRepository;
import org.taloc.qltt.Repository.HoaDonRepository;
import org.taloc.qltt.Repository.XangDauRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChiTietHoaDonService {

    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepository;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private XangDauRepository xangDauRepository;

    public List<ChiTietHoaDonDTO> getAllChiTietHoaDon() {
        return chiTietHoaDonRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void addChiTietHoaDon(ChiTietHoaDonDTO dto) {
        // Kiểm tra và lấy HoaDon
        HoaDon hoaDon = hoaDonRepository.findById(dto.getHoaDon())
                .orElseThrow(() -> new RuntimeException("Hóa đơn không tồn tại"));

        // Kiểm tra và lấy XangDau
        XangDau xangDau = xangDauRepository.findById(dto.getXangDau())
                .orElseThrow(() -> new RuntimeException("Xăng dầu không tồn tại"));

        // Khởi tạo ChiTietHoaDonId dựa trên HoaDon và XangDau
        ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId(dto.getHoaDon(), dto.getXangDau());

        // Tạo mới đối tượng ChiTietHoaDon và gán dữ liệu
        ChiTietHoaDon chiTiet = new ChiTietHoaDon();
        chiTiet.setId(chiTietHoaDonId);
        chiTiet.setHoaDon(hoaDon);
        chiTiet.setXangDau(xangDau);
        chiTiet.setSoLuong(dto.getSoLuong());
        chiTiet.setDonGia(dto.getDonGia());

        // Tính và gán thành tiền
        double thanhTien = dto.getSoLuong() * dto.getDonGia();
        chiTiet.setThanhTien(thanhTien);

        // Lưu chi tiết hóa đơn vào cơ sở dữ liệu
        chiTietHoaDonRepository.save(chiTiet);

        // Cập nhật tổng tiền cho hóa đơn sau khi thêm chi tiết mới
        updateTongTienHoaDon(dto.getHoaDon());
    }

    public void updateTongTienHoaDon(int hoaDonId) {
        // Lấy tất cả các chi tiết hóa đơn thuộc hóa đơn này và tính tổng tiền
        double tongTien = chiTietHoaDonRepository.findByHoaDon_MaHoaDon(hoaDonId).stream()
                .mapToDouble(chiTiet -> chiTiet.getSoLuong() * chiTiet.getDonGia())
                .sum();

        // Tìm và cập nhật tổng tiền cho hóa đơn
        HoaDon hoaDon = hoaDonRepository.findById(hoaDonId)
                .orElseThrow(() -> new RuntimeException("Hóa đơn không tồn tại"));
        hoaDon.setTongTien(tongTien);

        // Lưu lại hóa đơn đã cập nhật tổng tiền
        hoaDonRepository.save(hoaDon);
    }




    private ChiTietHoaDonDTO convertToDTO(ChiTietHoaDon chiTiet) {
        ChiTietHoaDonDTO dto = new ChiTietHoaDonDTO();
        dto.setHoaDon(chiTiet.getHoaDon().getMaHoaDon());
        dto.setXangDau(chiTiet.getXangDau().getMaXangDau());
        dto.setSoLuong(chiTiet.getSoLuong());
        dto.setDonGia(chiTiet.getDonGia());
        dto.setThanhTien(chiTiet.getThanhTien());
        return dto;
    }
    public void deleteChiTietHoaDon(int hoaDonId, int xangDauId) {
        ChiTietHoaDonId chiTietId = new ChiTietHoaDonId(hoaDonId, xangDauId);
        chiTietHoaDonRepository.deleteById(chiTietId);
    }

    public List<ChiTietHoaDonDTO> getChiTietByHoaDonId(int hoaDonId) {
        return chiTietHoaDonRepository.findByHoaDon_MaHoaDon(hoaDonId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

}
