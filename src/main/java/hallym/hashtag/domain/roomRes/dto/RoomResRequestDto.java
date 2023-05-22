package hallym.hashtag.domain.roomRes.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomResRequestDto {
    private Long uno; //유저 아이디

    private Long rno; // 시설 아이디

    private List<Long> rtnos; // 시간 아이디
}
