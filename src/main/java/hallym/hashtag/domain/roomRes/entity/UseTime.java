package hallym.hashtag.domain.roomRes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rrtno;

    private String time;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rrno")
    private RoomRes roomRes;

    public void setRoomRes(RoomRes roomRes) {
        this.roomRes = roomRes;
    }
}
