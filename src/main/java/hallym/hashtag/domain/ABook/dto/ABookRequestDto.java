package hallym.hashtag.domain.ABook.dto;

import hallym.hashtag.domain.book.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ABookRequestDto {
    private Long abno;

    private String tag;

    private Book book;

    private boolean loanType;
}
