package hallym.hashtag.domain.room.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RoomUseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rtno;

    private String time;

    private Reserve reserve;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rno")
    private Room room;

    public void setReserve(Reserve reserve) {
        this.reserve = reserve;
    }

    public enum Reserve {
        예약불가, 예약가능
    }
}
