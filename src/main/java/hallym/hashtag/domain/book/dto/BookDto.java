package hallym.hashtag.domain.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long bno;

    private String title;

    private String author;

    private String isbn;

    private String pudDate;

    private Long bookPage;
}
