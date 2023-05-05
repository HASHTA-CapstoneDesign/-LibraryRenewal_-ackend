package hallym.hashtag.domain.user.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String number;
    private String password;
}
