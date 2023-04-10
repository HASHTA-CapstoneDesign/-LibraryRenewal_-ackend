package hallym.hashtag.domain.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto {
    private Long sno;
    private String name;
    private Long cleanup;
}
