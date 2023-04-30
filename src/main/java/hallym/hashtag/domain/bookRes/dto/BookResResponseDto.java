package hallym.hashtag.domain.bookRes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResResponseDto {

    private Long nno;

    private LocalDate creDate;

    private String bookName;

    private String studentName;
}
