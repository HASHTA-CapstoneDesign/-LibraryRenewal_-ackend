package hallym.hashtag.domain.student.entity;

import hallym.hashtag.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    private String name;

    private String phone;

    private Long cleanup;

    private String major;

    private String password;
}
