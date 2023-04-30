package hallym.hashtag.domain.abook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ABookResponseDto {
    private Long abno;

    private String tag;

    private boolean loanType;

    private boolean reserveType;
}
