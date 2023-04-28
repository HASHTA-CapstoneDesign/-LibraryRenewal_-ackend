package hallym.hashtag.domain.student.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import hallym.hashtag.domain.loan.entity.Loan;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {
    private Long sno;

    private String name;

    private String phone;

    private Long cleanup;

    private String major;

    private String password;

    private Boolean deleted;

    private List<Loan> loans;
}
