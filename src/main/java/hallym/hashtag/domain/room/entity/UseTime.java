package hallym.hashtag.domain.room.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hallym.hashtag.domain.room.entity.Reserve;
import hallym.hashtag.domain.room.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private Reserve reserve;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rno")
    private Room room;

}
