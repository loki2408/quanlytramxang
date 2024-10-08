package org.taloc.qltt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taloc.qltt.Model.Kho;
import org.taloc.qltt.Repository.KhoRepository;

import java.util.List;

@Service
public class KhoService {

    @Autowired
    private KhoRepository khoRepository;

    public List<Kho> getAllKhos() {
        return khoRepository.findAll();
    }

    public Kho getKhoById(int id) {
        return khoRepository.findById(id).orElse(null);
    }

    public Kho saveKho(Kho kho) {
        return khoRepository.save(kho);
    }

    public Kho updateKho(int id, Kho kho) {
        if (khoRepository.existsById(id)) {
            kho.setMaKho(id);
            return khoRepository.save(kho);
        }
        return null;
    }

    public void deleteKho(int id) {
        khoRepository.deleteById(id);
    }
}
