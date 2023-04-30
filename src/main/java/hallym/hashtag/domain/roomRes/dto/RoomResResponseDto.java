package hallym.hashtag.domain.roomRes.dto;

import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.roomRes.entity.UseTime;
import hallym.hashtag.domain.student.entity.Student;
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

    List<String> useTimes = new ArrayList<>();

    private String studentName;

    private String roomName;

    private LocalDate creDate;
}
