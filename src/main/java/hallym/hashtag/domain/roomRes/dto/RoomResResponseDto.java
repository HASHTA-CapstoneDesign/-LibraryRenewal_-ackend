package hallym.hashtag.domain.roomRes.dto;

import hallym.hashtag.domain.roomRes.entity.Time;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomResResponseDto {
    private Long rno;

    private LocalDate creDate;

    private String useDate;

    private Time time;

    private String roomName;

    @ColumnDefault("false")
    private boolean reserve;
}
