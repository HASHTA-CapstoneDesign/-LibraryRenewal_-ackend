package hallym.hashtag.domain.user.service;

import hallym.hashtag.domain.user.dto.LoginRequestDto;
import hallym.hashtag.global.config.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Value("${jwt.secret}")
    private String secretKey;

    public String login(LoginRequestDto loginRequestDto) {
        Long expiredMs = 100 * 60 * 60L;

        return JwtUtil.createJwt(loginRequestDto.getNumber(), secretKey, expiredMs);
    }
}
