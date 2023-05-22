package hallym.hashtag.domain.user.service;

import hallym.hashtag.domain.user.dto.LoginRequestDto;
import hallym.hashtag.domain.user.dto.LoginResponseDto;

public interface UserService {
    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
