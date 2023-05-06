package hallym.hashtag.domain.notice.dto;

import hallym.hashtag.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeRequestDto {
    private Long nno;

    private String title;

    private String content;

    private User user;
}
