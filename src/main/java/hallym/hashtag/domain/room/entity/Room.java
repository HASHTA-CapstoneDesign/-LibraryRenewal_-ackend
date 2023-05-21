package hallym.hashtag.domain.room.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Builder.Default
    @JsonManagedReference
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<RoomUseTime> roomUseTimes = new ArrayList<>();

    public void setRoomUseTimes(List<RoomUseTime> roomUseTimes) {
        this.roomUseTimes = roomUseTimes;
    }
    public enum Floor {
        floor1("2층 스터디룸"),
        floor2("3층"),
        floor3("4층(디지털스터디룸)"),
        floor4("4층 C.Square"),
        floor5("5층");


        private final String label;

        Floor(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }

}


