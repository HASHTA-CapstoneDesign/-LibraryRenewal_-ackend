package hallym.hashtag.domain.room.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Builder
@Entity
@Table(name = "room")
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @Enumerated(value = EnumType.STRING)
    private Floor floor;

    private String name;

    private String useData;

    private String useTime;

    @Enumerated(value = EnumType.STRING)
    private Reserve reserve;

    public void setReserve(Reserve reserve) {
        this.reserve = reserve;
    }

    public enum Reserve {
        예약가능, 예약불가
    }
}


