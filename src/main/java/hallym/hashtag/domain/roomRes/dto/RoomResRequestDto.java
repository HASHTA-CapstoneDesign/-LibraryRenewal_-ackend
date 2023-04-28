package hallym.hashtag.domain.roomRes.dto;

import hallym.hashtag.domain.roomRes.entity.Floor;
import hallym.hashtag.domain.roomRes.entity.RoomName;
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

    private Floor floor;

    private RoomName roomName;

    private boolean reserve;
}
