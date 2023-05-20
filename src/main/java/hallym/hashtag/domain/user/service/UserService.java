package hallym.hashtag.domain.user.service;

import hallym.hashtag.global.config.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Value("${jwt.secret}")
    private String secretKey;

    public String login(String userName, String password) {
        Long expiredMs = 100 * 60 * 60L;
        return JwtUtil.createJwt(userName, secretKey, expiredMs);
    }
}
