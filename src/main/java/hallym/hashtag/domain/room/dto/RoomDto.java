package hallym.hashtag.domain.room.dto;

import hallym.hashtag.domain.room.entity.Floor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Long rno;

    private Floor floor;

    private String name;

    private String content;

    private boolean studyRoom;
}
