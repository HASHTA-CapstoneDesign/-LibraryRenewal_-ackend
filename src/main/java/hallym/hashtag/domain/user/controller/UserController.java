package hallym.hashtag.domain.user.controller;

import hallym.hashtag.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @PostMapping("login")
//    public String login() {
//        return userService.login(" ", " ");
//    }
}
