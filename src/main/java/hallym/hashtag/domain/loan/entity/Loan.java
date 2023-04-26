package hallym.hashtag.domain.loan.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hallym.hashtag.domain.abook.entity.ABook;
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
@Table(name = "Loan")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(value = { AuditingEntityListener.class })
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lno;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "creDate", updatable = false)
    private LocalDate creDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "retDate")
    private LocalDate retDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "nowRetDate")
    private LocalDate nowRetDate;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "abno")
    private ABook aBook;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sno")
    private Student student;


}
