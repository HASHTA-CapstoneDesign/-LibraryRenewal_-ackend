package hallym.hashtag.domain.user.service;

import hallym.hashtag.domain.user.dto.LoginRequestDto;
import hallym.hashtag.domain.user.dto.UserRequestDto;
import hallym.hashtag.domain.user.entity.User;
import hallym.hashtag.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserSerivcelmpl implements UserService{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String register(UserRequestDto userRequestDto) {
        User user = toEntity(userRequestDto);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPhone(bCryptPasswordEncoder.encode(user.getPhone()));
        user.setDepartment(bCryptPasswordEncoder.encode(user.getDepartment()));
        user.setName(bCryptPasswordEncoder.encode(user.getName()));
        user.setRoles("ROLE_ADMIN");

        userRepository.save(user);

        return "회원가입 완료";
    }

    private User toEntity(UserRequestDto userRequestDto) {
        return User.builder()
                .name(userRequestDto.getName())
                .number(userRequestDto.getNumber())
                .password(userRequestDto.getPassword())
                .phone(userRequestDto.getPhone())
                .department(userRequestDto.getDepartment())
                .build();
    }
}
