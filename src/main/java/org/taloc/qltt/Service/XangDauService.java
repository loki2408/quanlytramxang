package org.taloc.qltt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taloc.qltt.DTO.XangDauDTO;
import org.taloc.qltt.Model.XangDau;
import org.taloc.qltt.Repository.XangDauRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class XangDauService {

    @Autowired
    private XangDauRepository xangDauRepository;

    public List<XangDauDTO> getAllXangDau() {
        return xangDauRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public XangDauDTO getXangDauById(Integer maXangDau) {
        XangDau xangDau = xangDauRepository.findById(maXangDau)
                .orElseThrow(() -> new RuntimeException("Xăng dầu không tồn tại"));
        return convertToDTO(xangDau);
    }

    public XangDauDTO createXangDau(XangDauDTO xangDauDTO) {
        XangDau xangDau = convertToEntity(xangDauDTO);
        XangDau savedXangDau = xangDauRepository.save(xangDau);
        return convertToDTO(savedXangDau);
    }

    public XangDauDTO updateXangDau(XangDauDTO xangDauDTO) {
        XangDau xangDau = xangDauRepository.findById(xangDauDTO.getMaXangDau())
                .orElseThrow(() -> new RuntimeException("Xăng dầu không tồn tại"));

        xangDau.setTenXangDau(xangDauDTO.getTenXangDau());
        xangDau.setGia(xangDauDTO.getGia());
        xangDau.setLoaiNhienLieu(xangDauDTO.getLoaiNhienLieu());

        XangDau updatedXangDau = xangDauRepository.save(xangDau);
        return convertToDTO(updatedXangDau);
    }

    public void deleteXangDau(Integer maXangDau) {
        xangDauRepository.deleteById(maXangDau);
    }

    private XangDauDTO convertToDTO(XangDau xangDau) {
        XangDauDTO dto = new XangDauDTO();
        dto.setMaXangDau(xangDau.getMaXangDau());
        dto.setTenXangDau(xangDau.getTenXangDau());
        dto.setGia(xangDau.getGia());
        dto.setLoaiNhienLieu(xangDau.getLoaiNhienLieu());
        return dto;
    }

    private XangDau convertToEntity(XangDauDTO dto) {
        XangDau xangDau = new XangDau();
        xangDau.setMaXangDau(dto.getMaXangDau());
        xangDau.setTenXangDau(dto.getTenXangDau());
        xangDau.setGia(dto.getGia());
        xangDau.setLoaiNhienLieu(dto.getLoaiNhienLieu());
        return xangDau;
    }
}
