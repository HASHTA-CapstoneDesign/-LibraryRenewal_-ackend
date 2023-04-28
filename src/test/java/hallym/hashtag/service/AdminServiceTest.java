package hallym.hashtag.service;

import hallym.hashtag.domain.admin.dto.AdminRequestDto;
import hallym.hashtag.domain.admin.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminServiceTest {
    @Autowired
    AdminService adminService;

    @Test
    public void testCreate() {
        AdminRequestDto adminRequestDto = AdminRequestDto.builder()
                .name("김미진")
                .phone("010-0000-0000")
                .employeeNum(1111L)
                .dep("총무팀")
                .password("1111")
                .build();
        adminService.create(adminRequestDto);
    }

    @Test
    public void testFindAll() {
        adminService.findAll();
    }

    @Test
    public void testFindByOne() {
        Long ano = 1L;
        adminService.findByOne(ano);
    }

    @Test
    public void testUpdate() {
        Long ano = 1L;
        AdminRequestDto adminRequestDto = AdminRequestDto.builder()
                .name("김미진")
                .phone("010-0000-0000")
                .employeeNum(1111L)
                .dep("도서관리팀")
                .password("5555")
                .build();
        adminService.update(ano, adminRequestDto);
    }

    @Test
    public void testUpdatePassword() {
        Long sno = 1L;
        String password = "1010";
        adminService.updatePassword(sno, password);
    }

    @Test
    public void testDelete() {
        Long ano = 1L;
        adminService.delete(ano);
    }
}
