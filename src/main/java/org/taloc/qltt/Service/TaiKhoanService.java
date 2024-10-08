package org.taloc.qltt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.taloc.qltt.Model.TaiKhoan;
import org.taloc.qltt.Repository.TaiKhoanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanService implements UserDetailsService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public TaiKhoan createTaiKhoan(TaiKhoan taiKhoan) {
        if (taiKhoanRepository.existsByUsername(taiKhoan.getUsername())) {
            throw new IllegalArgumentException("Username đã tồn tại");
        }

        // Mã hóa mật khẩu trước khi lưu
        taiKhoan.setPassword(passwordEncoder.encode(taiKhoan.getPassword()));

        // Lưu thông tin tài khoản
        return taiKhoanRepository.save(taiKhoan);
    }
    public void updatePassword(int id, String newPassword) {
        Optional<TaiKhoan> existingTaiKhoanOpt = taiKhoanRepository.findById(id);
        if (!existingTaiKhoanOpt.isPresent()) {
            throw new IllegalArgumentException("Tài khoản không tồn tại");
        }

        TaiKhoan existingTaiKhoan = existingTaiKhoanOpt.get();
        if (newPassword != null && !newPassword.isEmpty()) {
            existingTaiKhoan.setPassword(passwordEncoder.encode(newPassword));
        }

        taiKhoanRepository.save(existingTaiKhoan);
    }

    public TaiKhoan updateTaiKhoan(TaiKhoan updatedTaiKhoan) {
        Optional<TaiKhoan> existingTaiKhoanOpt = taiKhoanRepository.findById(updatedTaiKhoan.getId());
        if (!existingTaiKhoanOpt.isPresent()) {
            throw new IllegalArgumentException("Tài khoản không tồn tại");
        }

        TaiKhoan existingTaiKhoan = existingTaiKhoanOpt.get();
        existingTaiKhoan.setUsername(updatedTaiKhoan.getUsername());

        if (updatedTaiKhoan.getPassword() != null && !updatedTaiKhoan.getPassword().isEmpty()) {
            existingTaiKhoan.setPassword(passwordEncoder.encode(updatedTaiKhoan.getPassword()));
        }

        existingTaiKhoan.setRole(updatedTaiKhoan.getRole());
        return taiKhoanRepository.save(existingTaiKhoan);
    }

    public void deleteTaiKhoan(int id) {
        if (!taiKhoanRepository.existsById(id)) {
            throw new IllegalArgumentException("Tài khoản không tồn tại");
        }
        taiKhoanRepository.deleteById(id);
    }

    public List<TaiKhoan> getAllTaiKhoan() {
        return taiKhoanRepository.findAll();
    }

    public Optional<TaiKhoan> getTaiKhoanById(int id) {
        return taiKhoanRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TaiKhoan taiKhoan = taiKhoanRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return User.builder()
                .username(taiKhoan.getUsername())
                .password(taiKhoan.getPassword())
                .roles(taiKhoan.getRole())
                .build();
    }
}