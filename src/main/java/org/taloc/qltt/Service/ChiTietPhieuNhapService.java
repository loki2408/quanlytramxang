package org.taloc.qltt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taloc.qltt.DTO.ChiTietPhieuNhapDTO;
import org.taloc.qltt.Model.ChiTietPhieuNhap;
import org.taloc.qltt.Model.ChiTietPhieuNhapId;
import org.taloc.qltt.Model.PhieuNhap;
import org.taloc.qltt.Model.XangDau;
import org.taloc.qltt.Repository.ChiTietPhieuNhapRepository;
import org.taloc.qltt.Repository.PhieuNhapRepository;
import org.taloc.qltt.Repository.XangDauRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChiTietPhieuNhapService {

    @Autowired
    private ChiTietPhieuNhapRepository chiTietPhieuNhapRepository;

    @Autowired
    private PhieuNhapRepository phieuNhapRepository;

    @Autowired
    private XangDauRepository xangDauRepository;

    public ChiTietPhieuNhapDTO createChiTietPhieuNhap(ChiTietPhieuNhapDTO dto) {
        ChiTietPhieuNhap chiTietPhieuNhap = new ChiTietPhieuNhap();
        ChiTietPhieuNhapId id = new ChiTietPhieuNhapId(dto.getMaPhieuNhap(), dto.getMaXangDau());
        chiTietPhieuNhap.setId(id);

        Optional<PhieuNhap> phieuNhap = phieuNhapRepository.findById(dto.getMaPhieuNhap());
        if (!phieuNhap.isPresent()) {
            throw new IllegalArgumentException("Invalid Phieu Nhap ID");
        }
        chiTietPhieuNhap.setPhieuNhap(phieuNhap.get());

        Optional<XangDau> xangDau = xangDauRepository.findById(dto.getMaXangDau());
        if (!xangDau.isPresent()) {
            throw new IllegalArgumentException("Invalid Xang Dau ID");
        }
        chiTietPhieuNhap.setXangDau(xangDau.get());

        chiTietPhieuNhap.setSoLuong(dto.getSoLuong());

        chiTietPhieuNhapRepository.save(chiTietPhieuNhap);
        return dto;
    }

    public List<ChiTietPhieuNhapDTO> getAllChiTietPhieuNhap() {
        return chiTietPhieuNhapRepository.findAll().stream().map(chiTiet -> {
            ChiTietPhieuNhapDTO dto = new ChiTietPhieuNhapDTO();
            dto.setMaPhieuNhap(chiTiet.getPhieuNhap().getMaPhieuNhap());
            dto.setMaXangDau(chiTiet.getXangDau().getMaXangDau());
            dto.setSoLuong(chiTiet.getSoLuong());
            return dto;
        }).collect(Collectors.toList());
    }

    public void deleteChiTietPhieuNhap(Integer maPhieuNhap, Integer maXangDau) {
        ChiTietPhieuNhapId id = new ChiTietPhieuNhapId(maPhieuNhap, maXangDau);
        chiTietPhieuNhapRepository.deleteById(id);
    }

    public ChiTietPhieuNhapDTO updateChiTietPhieuNhap(ChiTietPhieuNhapDTO dto) {
        ChiTietPhieuNhapId id = new ChiTietPhieuNhapId(dto.getMaPhieuNhap(), dto.getMaXangDau());
        Optional<ChiTietPhieuNhap> optionalChiTietPhieuNhap = chiTietPhieuNhapRepository.findById(id);
        if (!optionalChiTietPhieuNhap.isPresent()) {
            throw new IllegalArgumentException("Chi Tiet Phieu Nhap not found");
        }
        ChiTietPhieuNhap chiTietPhieuNhap = optionalChiTietPhieuNhap.get();
        chiTietPhieuNhap.setSoLuong(dto.getSoLuong());

        chiTietPhieuNhapRepository.save(chiTietPhieuNhap);
        return dto;
    }
}