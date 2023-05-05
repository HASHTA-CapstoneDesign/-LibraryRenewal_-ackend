package hallym.hashtag.domain.user.service;

import hallym.hashtag.domain.user.dto.UserRequestDto;

import java.util.List;

public interface UserService {
    String register(UserRequestDto userRequestDto);
}
