package hallym.hashtag.domain.student.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {
    private Long sno;

    private String name;

    private String phone;

    private Long cleanup;

    private String major;

    private String password;

    private Boolean deleted;
}
