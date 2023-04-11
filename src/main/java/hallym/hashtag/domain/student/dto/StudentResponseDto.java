package hallym.hashtag.domain.student.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto {
    private Long sno;
    private String name;
    private Long cleanup;
}
