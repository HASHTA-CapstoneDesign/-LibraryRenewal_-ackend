package hallym.hashtag;

import hallym.hashtag.domain.user.dto.LoginRequestDto;
import hallym.hashtag.domain.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void testLogin() {
        LoginRequestDto loginRequestDto = LoginRequestDto.builder()
                .number("20207140").password("1111").build();
        userService.login(loginRequestDto);
    }
}
