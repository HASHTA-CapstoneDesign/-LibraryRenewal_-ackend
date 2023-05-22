package hallym.hashtag.domain.roomRes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import hallym.hashtag.domain.room.entity.RoomReserve;
import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.room.entity.UseTime;
import hallym.hashtag.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(value = { AuditingEntityListener.class })
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

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "creDate", updatable = false)
    private LocalDate creDate;

    @Builder.Default
    @JsonManagedReference
    @OneToMany(mappedBy = "roomRes", fetch = FetchType.LAZY)
    private List<UseTime> useTimes = new ArrayList<>();

    @Builder.Default
    @Enumerated(value = EnumType.STRING)
    private RoomResReserve roomReserve = RoomResReserve.예약완료;
}
