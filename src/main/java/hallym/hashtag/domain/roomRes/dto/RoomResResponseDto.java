package hallym.hashtag.domain.roomRes.dto;

import hallym.hashtag.domain.roomRes.entity.UseTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomResResponseDto {
    private Long rrno;

    private String useDate;

    private String roomName;

    private LocalDate creDate;

    private List<UseTime> useTimes = new ArrayList<>();
}
