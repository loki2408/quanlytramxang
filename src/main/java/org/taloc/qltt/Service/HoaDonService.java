package org.taloc.qltt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taloc.qltt.Model.HoaDon;
import org.taloc.qltt.Repository.HoaDonRepository;

import java.util.List;

@Service
public class HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    public List<HoaDon> getAllHoaDons() {
        return hoaDonRepository.findAll();
    }

    public HoaDon getHoaDonById(int id) {
        return hoaDonRepository.findById(id).orElse(null);
    }

    public HoaDon saveHoaDon(HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    public HoaDon updateHoaDon(int id, HoaDon hoaDon) {
        if (hoaDonRepository.existsById(id)) {
            hoaDon.setMaHoaDon(id);
            return hoaDonRepository.save(hoaDon);
        }
        return null;
    }

    public void deleteHoaDon(int id) {
        hoaDonRepository.deleteById(id);
    }
}
