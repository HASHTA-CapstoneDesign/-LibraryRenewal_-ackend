package hallym.hashtag.domain.room.dto;

import hallym.hashtag.domain.room.entity.Floor;
import hallym.hashtag.domain.room.entity.UseTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class RoomDto {
    private Floor floor;

    private String name;

    private String useData;

    private List<UseTime> useTimes;
}
