package hallym.hashtag.domain.bookRes.dto;

import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.student.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResRequestDto {

    private Long nno;

    private Student student;

    private ABook aBook;

    private LocalDate creDate;
}
