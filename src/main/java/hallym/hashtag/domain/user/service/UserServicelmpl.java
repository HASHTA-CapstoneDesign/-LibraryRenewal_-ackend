package hallym.hashtag.domain.user.service;

import hallym.hashtag.domain.user.dto.LoginRequestDto;
import hallym.hashtag.domain.user.dto.LoginResponseDto;
import hallym.hashtag.domain.user.entity.User;
import hallym.hashtag.domain.user.repository.UserRepository;
import hallym.hashtag.global.config.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserServicelmpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${jwt.secret}")
    private String secretKey;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Long expiredMs = 100 * 60 * 60L;
        User findNumber = userRepository.findByNumber(loginRequestDto.getNumber())
                .orElseThrow(() -> new RuntimeException("아이디가 없습니다."));
        if(bCryptPasswordEncoder.matches(findNumber.getPassword(), loginRequestDto.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        String token = JwtUtil.createJwt(loginRequestDto.getNumber(), secretKey, expiredMs);
        return LoginResponseDto.builder().uno(findNumber.getUno())
                .token(token).build();
    }

}
