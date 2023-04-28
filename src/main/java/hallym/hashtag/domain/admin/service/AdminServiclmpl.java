package hallym.hashtag.domain.admin.service;

import hallym.hashtag.domain.admin.dto.AdminRequestDto;
import hallym.hashtag.domain.admin.dto.AdminResponseDto;
import hallym.hashtag.domain.admin.entity.Admin;
import hallym.hashtag.domain.admin.repository.AdminRepository;
import hallym.hashtag.domain.student.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class AdminServiclmpl implements AdminService {
    private final AdminRepository adminRepository;


    @Override
    public AdminResponseDto create(AdminRequestDto adminRequestDto) {
        Admin admin = toEntity(adminRequestDto);
        adminRepository.save(admin);
        return toDto(admin);
    }

    @Override
    public List<AdminResponseDto> findAll() {
        List<Admin> adminList = adminRepository.findAll();
        return adminList.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public AdminResponseDto findByOne(Long ano) {
        Optional<Admin> byAno = adminRepository.findById(ano);
        if(byAno.isEmpty()) return null;
        Admin admin = byAno.get();
        return toDto(admin);
    }

    @Override
    public AdminResponseDto update(Long ano, AdminRequestDto adminRequestDto) {
        Optional<Admin> byAno = adminRepository.findById(ano);
        if(byAno.isEmpty()) return null;
        Admin admin = byAno.get();
        admin.updateAdmin(toEntity(adminRequestDto));
        adminRepository.save(admin);
        return toDto(admin);
    }

    @Override
    public AdminResponseDto updatePassword(Long ano, String password) {
        Optional<Admin> byAno = adminRepository.findById(ano);
        if(byAno.isEmpty()) return null;
        Admin admin = byAno.get();
        admin.updatePassword(password);
        adminRepository.save(admin);
        return toDto(admin);
    }

    @Override
    public String delete(Long ano) {
        Optional<Admin> byAno = adminRepository.findById(ano);
        if(byAno.isEmpty()) return "ID가 없습니다.";
        Admin admin = byAno.get();
        adminRepository.delete(admin);
        return "삭제되었습니다.";
    }

    public Admin toEntity(AdminRequestDto adminRequestDto) {
        return Admin.builder()
                .ano(adminRequestDto.getAno())
                .name(adminRequestDto.getName())
                .phone(adminRequestDto.getPhone())
                .employeeNum(adminRequestDto.getEmployeeNum())
                .dep(adminRequestDto.getDep())
                .password(adminRequestDto.getPassword())
                .build();
    }

    public AdminResponseDto toDto(Admin admin) {
        return AdminResponseDto.builder()
                .ano(admin.getAno())
                .name(admin.getName())
                .dep(admin.getDep())
                .build();
    }
}
