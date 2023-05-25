package hallym.hashtag.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uno;
    private String name;
    private String number;
    private String password;
    private String phone;
    private String department; // 소속, 학생은 학과정보, 어드민은 부서정보
    private String role; // USER, ADMIN
}
