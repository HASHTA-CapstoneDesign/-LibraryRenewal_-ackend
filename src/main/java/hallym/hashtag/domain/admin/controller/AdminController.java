package hallym.hashtag.domain.admin.controller;

import hallym.hashtag.domain.admin.dto.AdminRequestDto;
import hallym.hashtag.domain.admin.dto.AdminResponseDto;
import hallym.hashtag.domain.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("user/admin")
public class AdminController {
    private final AdminService adminService;

    @PostMapping
    public AdminResponseDto adminCreate(@RequestBody AdminRequestDto adminRequestDto) {
        return adminService.create(adminRequestDto);
    }

    @GetMapping("list")
    public List<AdminResponseDto> adminFindAll() {
        return adminService.findAll();
    }

    @GetMapping("{ano}")
    public AdminResponseDto adminFindByOne(@PathVariable(name = "ano") Long ano) {
        return adminService.findByOne(ano);
    }

    @PutMapping("{ano}")
    public AdminResponseDto adminUpdate(@PathVariable(name = "ano") Long ano,
                                        @RequestBody AdminRequestDto adminRequestDto) {
        return adminService.update(ano, adminRequestDto);
    }

    @PutMapping("password/{ano}")
    public AdminResponseDto adminUpdatePassword(@PathVariable(name = "ano") Long ano,
                                                @RequestBody String password) {
        return adminService.updatePassword(ano, password);
    }

    @DeleteMapping("{ano}")
    public String adminDelete(@PathVariable(name = "ano") Long ano) {
        return adminService.delete(ano);
    }
}
