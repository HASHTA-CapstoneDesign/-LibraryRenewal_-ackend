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
public class RoomResRequestDto {
    private Long rrno;

    private String useDate;

    List<UseTime> useTimes = new ArrayList<>();

    private Student student;

    private Room room;

    private LocalDate creDate;
}
