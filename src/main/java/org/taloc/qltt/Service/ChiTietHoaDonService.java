package org.taloc.qltt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taloc.qltt.Model.ChiTietHoaDon;
import org.taloc.qltt.Model.ChiTietHoaDonId;
import org.taloc.qltt.Repository.ChiTietHoaDonRepository;

import java.util.List;

@Service
public class ChiTietHoaDonService {

    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepository;

    public List<ChiTietHoaDon> getAllChiTietHoaDons() {
        return chiTietHoaDonRepository.findAll();
    }

    public ChiTietHoaDon getChiTietHoaDonById(ChiTietHoaDonId id) {
        return chiTietHoaDonRepository.findById(id).orElse(null);
    }

    public ChiTietHoaDon saveChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        return chiTietHoaDonRepository.save(chiTietHoaDon);
    }

    public ChiTietHoaDon updateChiTietHoaDon(ChiTietHoaDonId id, ChiTietHoaDon chiTietHoaDon) {
        if (chiTietHoaDonRepository.existsById(id)) {
            return chiTietHoaDonRepository.save(chiTietHoaDon);
        }
        return null;
    }

    public void deleteChiTietHoaDon(ChiTietHoaDonId id) {
        chiTietHoaDonRepository.deleteById(id);
    }
}
