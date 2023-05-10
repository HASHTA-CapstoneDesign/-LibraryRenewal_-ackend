package hallym.hashtag.service;

import hallym.hashtag.domain.user.dto.UserRequestDto;
import hallym.hashtag.domain.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void testSave() {
        userService.register(UserRequestDto.builder()
                .name("김미진")
                .number("20207140")
                .phone("010-4062-8490")
                .department("빅데이터전공")
                .password("1111")
                .build());

    }
}
