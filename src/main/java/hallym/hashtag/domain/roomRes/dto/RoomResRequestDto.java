package hallym.hashtag.domain.roomRes.dto;

import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.roomRes.entity.UseTime;
import hallym.hashtag.domain.user.entity.User;
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
public class RoomResRequestDto {
    private Long rrno;

    private String useDate;

    private User user;

    private Room room;

    private LocalDate creDate;

    private List<UseTime> useTimes = new ArrayList<>();
}
