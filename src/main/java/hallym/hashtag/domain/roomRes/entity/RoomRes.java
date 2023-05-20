package hallym.hashtag.domain.roomRes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.user.entity.User;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class RoomRes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rrno;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uno")
    private User user;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rno")
    private Room room;

    private String useData;

    @ColumnDefault("true")
    private Boolean reserve; //예약 여부

    public void setUser(User user) {
        this.user = user;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setReserve(Boolean reserve) { this.reserve = reserve; }
}
