package hallym.hashtag.domain.abook.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hallym.hashtag.domain.book.entity.Book;
import hallym.hashtag.domain.loan.entity.Loan;
import hallym.hashtag.global.baseEntity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "abook")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ABook extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long abno;

    private String tag;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bno")
    private Book book;

    @ColumnDefault("false")
    private boolean loanType; //대출여부 1:대출중, 0:대출가능

    @ColumnDefault("false")
    private boolean reserveType; //예약 여부 1:예약중 0:예약가능

    @OneToOne(mappedBy = "aBook")
    private Loan loan;

    public void setLoanType(Boolean loanType) {
        this.loanType = loanType;
    }

    public void setBook(Book book) {
        if(this.book != null)
            this.book.getABooks().remove(this);
        this.book = book;
        book.getABooks().add(this);
    }
}
