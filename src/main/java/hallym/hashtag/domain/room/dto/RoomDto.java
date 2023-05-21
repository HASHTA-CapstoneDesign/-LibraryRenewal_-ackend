package hallym.hashtag.domain.room.dto;

import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.room.entity.RoomUseTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Room.Floor floor;

    private String name;

    private List<RoomUseTime> roomUseTimes;
}
