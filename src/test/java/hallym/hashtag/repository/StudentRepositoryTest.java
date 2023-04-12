package hallym.hashtag.repository;

import hallym.hashtag.domain.student.entity.Student;
import hallym.hashtag.domain.student.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testSave() {
        Student student = studentRepository.save(Student.builder()
                .name("홍길동")
                .phone("010-0000-0000")
                .cleanup(2020000L)
                .major("소프트웨어학부")
                .password("1111").build());

        System.out.println("----------저장 완료!----------");
    }

}
