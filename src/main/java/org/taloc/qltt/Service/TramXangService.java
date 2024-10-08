package org.taloc.qltt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.taloc.qltt.DTO.TramXangDTO;
import org.taloc.qltt.Model.TramXang;
import org.taloc.qltt.Repository.TramXangRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TramXangService {

    @Autowired
    private TramXangRepository tramXangRepository;

    // Đường dẫn thư mục lưu trữ hình ảnh
    private final String uploadDir = "D:/QLTT/QLTT/src/main/resources/static/images/";

    public TramXangService() {
        // Tạo thư mục lưu trữ hình ảnh nếu chưa tồn tại
        Path path = Paths.get(uploadDir);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new RuntimeException("Không thể tạo thư mục lưu trữ hình ảnh", e);
            }
        }
    }

    public Optional<String> getTenTramById(Integer maTram) {
        Optional<TramXang> tramXang = tramXangRepository.findById(maTram);
        return tramXang.map(TramXang::getTenTram);
    }


    public Optional<TramXang> getTramXangById(Integer maTram) {
        return tramXangRepository.findById(maTram);
    }

    public List<TramXangDTO> getAllTramXang() {
        return tramXangRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TramXangDTO createTramXang(TramXangDTO tramXangDTO) {
        if (tramXangDTO.getHinhAnh() != null && !tramXangDTO.getHinhAnh().isEmpty()) {
            try {
                String fileName = saveImage(tramXangDTO.getHinhAnh());
                tramXangDTO.setTenHinhAnh(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            tramXangDTO.setTenHinhAnh("default.jpg"); // Sử dụng ảnh mặc định nếu không có ảnh nào được upload
        }
        TramXang tramXang = convertToEntity(tramXangDTO);
        TramXang savedTramXang = tramXangRepository.save(tramXang);
        return convertToDTO(savedTramXang);
    }


    public TramXangDTO updateTramXang(TramXangDTO tramXangDTO) {
        TramXang tramXang = tramXangRepository.findById(tramXangDTO.getMaTram())
                .orElseThrow(() -> new RuntimeException("Trạm xăng không tồn tại"));

        tramXang.setTenTram(tramXangDTO.getTenTram());
        tramXang.setDiaChi(tramXangDTO.getDiaChi());
        tramXang.setTruongTram(tramXangDTO.getTruongTram());
        tramXang.setKinhDo((float) tramXangDTO.getKinhDo());
        tramXang.setViDo((float) tramXangDTO.getViDo());

        if (tramXangDTO.getHinhAnh() != null && !tramXangDTO.getHinhAnh().isEmpty()) {
            try {
                String fileName = saveImage(tramXangDTO.getHinhAnh());
                tramXang.setHinhAnh(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Có lỗi xảy ra khi lưu hình ảnh", e);
            }
        }

        TramXang updatedTramXang = tramXangRepository.save(tramXang);
        return convertToDTO(updatedTramXang);
    }

    public void deleteTramXang(int maTram) {
        tramXangRepository.deleteById(maTram);
    }

    private TramXangDTO convertToDTO(TramXang tramXang) {
        TramXangDTO dto = new TramXangDTO();
        dto.setMaTram(tramXang.getMaTram());
        dto.setTenTram(tramXang.getTenTram());
        dto.setDiaChi(tramXang.getDiaChi());
        dto.setTruongTram(tramXang.getTruongTram());
        dto.setKinhDo(tramXang.getKinhDo());
        dto.setViDo(tramXang.getViDo());
        dto.setTenHinhAnh(tramXang.getHinhAnh());
        return dto;
    }

    private TramXang convertToEntity(TramXangDTO dto) {
        TramXang tramXang = new TramXang();
        tramXang.setMaTram(dto.getMaTram());
        tramXang.setTenTram(dto.getTenTram());
        tramXang.setDiaChi(dto.getDiaChi());
        tramXang.setTruongTram(dto.getTruongTram());
        tramXang.setKinhDo((float) dto.getKinhDo());
        tramXang.setViDo((float) dto.getViDo());
        tramXang.setHinhAnh(dto.getTenHinhAnh());
        return tramXang;
    }

    private String saveImage(MultipartFile image) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        File dest = new File(uploadDir + fileName);
        image.transferTo(dest);
        return fileName;
    }
}
