package hallym.hashtag.domain.user.controller;

import hallym.hashtag.domain.user.dto.LoginRequestDto;
import hallym.hashtag.domain.user.dto.LoginResponseDto;
import hallym.hashtag.domain.user.service.UserService;
import hallym.hashtag.domain.user.service.UserServicelmpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        return userService.login(loginRequestDto);
    }
}
