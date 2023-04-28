package hallym.hashtag.domain.book.dto;

import hallym.hashtag.domain.book.entity.BookType;
import hallym.hashtag.domain.loan.entity.Loan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long bno;

    private Long tag;

    private String title;

    private String author;

    private String isbn;

    private String pudDate;

    private Long bookPage;

    private BookType bookType;

    private int loanCount;
}
