package hallym.hashtag.domain.bookRes.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.loan.entity.Loan;
import hallym.hashtag.domain.student.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
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
    @JoinColumn(name = "sno")
    private Student student;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "creDate", updatable = false)
    private LocalDate creDate;
}
