package hallym.hashtag.domain.loan.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.user.entity.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Builder
@Entity
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
    @JoinColumn(name = "uno")
    private User user;

    private String returnType;

    public void setABook(ABook aBook) {
        this.aBook = aBook;
    }

    public void setRetDate(LocalDate localDate) {
        this.retDate = localDate;
    }

    public void setNowRetDate() {
        this.nowRetDate = LocalDate.now();
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

}
