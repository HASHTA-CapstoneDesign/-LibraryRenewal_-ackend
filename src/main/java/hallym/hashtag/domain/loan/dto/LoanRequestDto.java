package hallym.hashtag.domain.loan.dto;

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
public class LoanRequestDto {
    private Long lno;

    private LocalDate creDate;

    private LocalDate retDate;

    private LocalDate nowRetDate;

    private ABook aBook;

    private Student student;
}
