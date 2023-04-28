package hallym.hashtag.domain.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminRequestDto {
    private Long ano;

    private String name;

    private String phone;

    private Long employeeNum;

    private String dep;

    private String password;
}
