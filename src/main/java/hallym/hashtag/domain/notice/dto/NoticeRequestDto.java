package hallym.hashtag.domain.notice.dto;

import hallym.hashtag.domain.admin.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeRequestDto {
    private Long nno;

    private String title;

    private String content;

    private Admin admin;
}
