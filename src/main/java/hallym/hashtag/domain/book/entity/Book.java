package hallym.hashtag.domain.book.entity;

import hallym.hashtag.global.baseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

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

    private String title;

    private String author;

    private String isbn;

    private String pudDate;

    private Long bookPage;

    public void updateBook(Book book) {
//        BeanUtils.copyProperties(book, this);
        this.title = book.title;
        this.author = book.author;
        this.isbn = book.isbn;
        this.pudDate = book.pudDate;
        this.bookPage = book.bookPage;
    }
}
