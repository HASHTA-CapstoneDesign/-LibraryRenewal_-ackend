package hallym.hashtag.domain.roomRes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.user.entity.User;
import lombok.*;

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

    @ElementCollection
    private List<String> useTimes = new ArrayList<>();

    private String useData;

    public void setUser(User user) {
        this.user = user;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
