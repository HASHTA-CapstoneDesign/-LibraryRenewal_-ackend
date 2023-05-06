package hallym.hashtag.domain.student.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.loan.entity.Loan;
import hallym.hashtag.global.baseEntity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public void updateStudent(Student student) {
        this.name = student.name;
        this.phone = student.phone;
        this.cleanup = student.cleanup;
        this.major = student.major;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
