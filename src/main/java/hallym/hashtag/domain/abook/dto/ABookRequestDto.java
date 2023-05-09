package hallym.hashtag.domain.abook.dto;

import hallym.hashtag.domain.book.entity.Book;
import hallym.hashtag.domain.loan.entity.Loan;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ABookRequestDto {
    private String tag;
}
