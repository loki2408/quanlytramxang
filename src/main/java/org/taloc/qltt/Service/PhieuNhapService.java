package org.taloc.qltt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taloc.qltt.DTO.PhieuNhapDTO;
import org.taloc.qltt.Model.PhieuNhap;
import org.taloc.qltt.Model.TramXang;
import org.taloc.qltt.Repository.PhieuNhapRepository;
import org.taloc.qltt.Repository.TramXangRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class PhieuNhapService {

    @Autowired
    private PhieuNhapRepository phieuNhapRepository;

    @Autowired
    private TramXangRepository tramXangRepository;

    public PhieuNhapDTO createPhieuNhap(PhieuNhapDTO dto) {
        PhieuNhap phieuNhap = new PhieuNhap();
        Optional<TramXang> tramXang = tramXangRepository.findById(dto.getMaTram());
        if (!tramXang.isPresent()) {
            throw new IllegalArgumentException("Invalid Tram Xang ID");
        }

        phieuNhap.setTramXang(tramXang.get());
        phieuNhap.setNgayLap(dto.getNgayLap());

        PhieuNhap savedPhieuNhap = phieuNhapRepository.save(phieuNhap);
        dto.setMaPhieuNhap(savedPhieuNhap.getMaPhieuNhap());
        return dto;
    }

    public PhieuNhapDTO getPhieuNhapById(Integer maPhieuNhap) {
        Optional<PhieuNhap> phieuNhapOptional = phieuNhapRepository.findById(maPhieuNhap);
        if (phieuNhapOptional.isPresent()) {
            PhieuNhap phieuNhap = phieuNhapOptional.get();
            PhieuNhapDTO dto = new PhieuNhapDTO();
            dto.setMaPhieuNhap(phieuNhap.getMaPhieuNhap());
            dto.setMaTram(phieuNhap.getTramXang().getMaTram());
            dto.setNgayLap(phieuNhap.getNgayLap());
            return dto;
        } else {
            throw new IllegalArgumentException("Phieu Nhap not found with ID: " + maPhieuNhap);
        }
    }

    public List<PhieuNhapDTO> getAllPhieuNhap() {
        return phieuNhapRepository.findAll().stream().map(phieuNhap -> {
            PhieuNhapDTO dto = new PhieuNhapDTO();
            dto.setMaPhieuNhap(phieuNhap.getMaPhieuNhap());
            dto.setMaTram(phieuNhap.getTramXang().getMaTram());
            dto.setNgayLap(phieuNhap.getNgayLap());
            return dto;
        }).collect(Collectors.toList());
    }

    public void deletePhieuNhap(Integer maPhieuNhap) {
        phieuNhapRepository.deleteById(maPhieuNhap);
    }

    public PhieuNhapDTO updatePhieuNhap(Integer maPhieuNhap, PhieuNhapDTO dto) {
        Optional<PhieuNhap> optionalPhieuNhap = phieuNhapRepository.findById(maPhieuNhap);
        if (!optionalPhieuNhap.isPresent()) {
            throw new IllegalArgumentException("Phieu Nhap not found");
        }
        PhieuNhap phieuNhap = optionalPhieuNhap.get();
        Optional<TramXang> tramXang = tramXangRepository.findById(dto.getMaTram());
        if (!tramXang.isPresent()) {
            throw new IllegalArgumentException("Invalid Tram Xang ID");
        }
        phieuNhap.setTramXang(tramXang.get());
        phieuNhap.setNgayLap(dto.getNgayLap());

        PhieuNhap updatedPhieuNhap = phieuNhapRepository.save(phieuNhap);
        dto.setMaPhieuNhap(updatedPhieuNhap.getMaPhieuNhap());
        return dto;
    }
}