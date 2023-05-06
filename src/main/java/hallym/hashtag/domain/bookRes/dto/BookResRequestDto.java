package hallym.hashtag.domain.bookRes.dto;

import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.student.entity.Student;
import hallym.hashtag.domain.user.entity.User;
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

    private Long brno;

    private User user;

    private ABook aBook;

    private LocalDate creDate;
}
