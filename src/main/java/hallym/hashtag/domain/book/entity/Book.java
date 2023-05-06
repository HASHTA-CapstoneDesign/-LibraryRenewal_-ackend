package hallym.hashtag.domain.book.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.loan.entity.Loan;
import hallym.hashtag.global.baseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "book")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private Long tag;

    private String title;

    private String author;

    private String isbn;

    private String pudDate;

    private Long bookPage;

    private BookType bookType;

    @Builder.Default
    private int loanCount = 0;

    @Builder.Default
    @JsonManagedReference
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<ABook> aBooks = new ArrayList<>();

    public void updateLoanCounting() {
        this.loanCount++;
    }

    public void updateBook(Book book) {
//        BeanUtils.copyProperties(book, this);
        this.title = book.title;
        this.author = book.author;
        this.isbn = book.isbn;
        this.pudDate = book.pudDate;
        this.bookPage = book.bookPage;
        this.bookType = book.bookType;
    }
}
