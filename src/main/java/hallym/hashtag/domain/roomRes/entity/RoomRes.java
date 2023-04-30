package hallym.hashtag.domain.roomRes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.student.entity.Student;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Getter
@Entity
@Table(name = "roomRes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(value = { AuditingEntityListener.class })
public class RoomRes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rrno;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "creDate", updatable = false)
    private LocalDate creDate;

    private String useDate;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sno")
    private Student student;

    private Time time;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rno")
    private Room room;
}
