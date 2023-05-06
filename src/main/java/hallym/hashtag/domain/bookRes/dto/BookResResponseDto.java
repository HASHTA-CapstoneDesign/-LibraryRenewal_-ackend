package hallym.hashtag.domain.bookRes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResResponseDto {

    private Long brno;

    private LocalDate creDate;

    private String bookName;
}
