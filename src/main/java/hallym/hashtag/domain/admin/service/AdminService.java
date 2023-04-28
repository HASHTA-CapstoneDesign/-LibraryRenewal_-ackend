package hallym.hashtag.domain.admin.service;

import hallym.hashtag.domain.admin.dto.AdminRequestDto;
import hallym.hashtag.domain.admin.dto.AdminResponseDto;

import java.util.List;

public interface AdminService {
    AdminResponseDto create(AdminRequestDto adminRequestDto);

    List<AdminResponseDto> findAll();

    AdminResponseDto findByOne(Long ano);

    AdminResponseDto update(Long ano, AdminRequestDto adminRequestDto);

    AdminResponseDto updatePassword(Long ano, String password);

    String delete(Long ano);
}
