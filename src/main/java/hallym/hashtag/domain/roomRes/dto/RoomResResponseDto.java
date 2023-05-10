package hallym.hashtag.domain.roomRes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class RoomResResponseDto {
    private Long rrno;

    private String roomName;

    private String useData;

    private List<String> useTimes = new ArrayList<>();
}
