package hallym.hashtag.domain.roomRes.dto;

import hallym.hashtag.domain.room.entity.Floor;
import hallym.hashtag.domain.roomRes.entity.RoomResReserve;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomResResponseDto {

    private LocalDate creDate; //신청일자

    private RoomResReserve roomReserve;

    private Floor floor;

    private String roomName;

    private List<String> useTimes;
}
