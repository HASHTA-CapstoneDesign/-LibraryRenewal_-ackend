package hallym.hashtag.repository;

import hallym.hashtag.domain.admin.entity.Admin;
import hallym.hashtag.domain.admin.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminRepositoryTest {
    @Autowired
    AdminRepository adminRepository;

    @Test
    public void testSave() {
        Admin admin = Admin.builder()
                .name("김미진")
                .phone("010-0000-0000")
                .employeeNum(1111L)
                .dep("총무팀")
                .password("1111")
                .build();

        adminRepository.save(admin);
    }
}
