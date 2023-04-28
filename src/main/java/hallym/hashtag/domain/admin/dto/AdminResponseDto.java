package hallym.hashtag.domain.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponseDto {
    private Long ano;

    private String name;

    private String dep;

}
