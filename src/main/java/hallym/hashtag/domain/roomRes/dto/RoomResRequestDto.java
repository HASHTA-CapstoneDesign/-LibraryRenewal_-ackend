package hallym.hashtag.domain.roomRes.dto;

import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.roomRes.entity.Time;
import hallym.hashtag.domain.student.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomResRequestDto {
    private Long rno;

    private LocalDate creDate;

    private String useDate;

    private Student student;

    private Time time;

    private Room room;
}
