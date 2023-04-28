package hallym.hashtag.domain.admin.entity;

import hallym.hashtag.domain.student.entity.Student;
import hallym.hashtag.global.baseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "admin")
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ano;

    private String name;

    private String phone;

    private Long employeeNum;

    private String dep;

    private String password;

    public void updateAdmin(Admin admin) {
        this.name = admin.name;
        this.phone = admin.phone;
        this.employeeNum = admin.employeeNum;
        this.dep = admin.dep;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
