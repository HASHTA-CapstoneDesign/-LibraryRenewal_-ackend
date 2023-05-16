package hallym.hashtag.domain.bookRes.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.user.entity.User;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Builder
@Entity
@Table(name = "bookRes")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(value = { AuditingEntityListener.class })
public class BookRes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brno;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "abno")
    private ABook aBook;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uno")
    private User user;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "creDate", updatable = false)
    private LocalDate creDate;

    @ColumnDefault("false")
    private Boolean reserveType; // false:예약 중, ture:예약취소

    public void setABook(ABook aBook) {
        this.aBook = aBook;
    }

    public void setReserveType() {
        this.reserveType = Boolean.TRUE;
    }
}
