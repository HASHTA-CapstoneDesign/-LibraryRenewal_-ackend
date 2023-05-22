package hallym.hashtag.domain.room.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hallym.hashtag.domain.roomRes.entity.RoomRes;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rtno;

    private String time;

    @Enumerated(value = EnumType.STRING)
    private RoomReserve roomReserve;

    @Setter
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rrno")
    private RoomRes roomRes;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rno")
    private Room room;

    public void setRoomReserve(RoomReserve reserve) {
        this.roomReserve = reserve;
    }

}
