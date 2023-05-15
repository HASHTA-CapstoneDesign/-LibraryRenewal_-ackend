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

    private Long tag;

    private String title;

    private String author;

    private String isbn;

    private String pudDate;

    private String image;

    private String pud;
}
