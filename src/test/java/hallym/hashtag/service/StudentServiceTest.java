package hallym.hashtag.service;

import hallym.hashtag.domain.student.dto.StudentRequestDto;
import hallym.hashtag.domain.student.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    StudentService studentService;
    @Test
    public void testCreate() {
        StudentRequestDto studentRequestDto = StudentRequestDto.builder()
                .name("홍길동")
                .phone("010-0000-0000")
                .cleanup(2020000L)
                .major("소프트웨어학부")
                .password("1111")
                .build();

        studentService.create(studentRequestDto);
        System.out.println("----------등록 완료!----------");
    }

    @Test
    public void testFindAll() {
        studentService.findAllList();
        System.out.println("----------출력 완료!----------");
    }

    @Test
    public void testFindByOne() {
        Long sno = 1L;
        studentService.findByOne(sno);
        System.out.println("----------조회 완료!----------");
    }

    @Test
    public void testUpdate() {
        Long sno = 1L;
        StudentRequestDto studentRequestDto = StudentRequestDto.builder()
                .name("김미진")
                .phone("010-0000-0000")
                .cleanup(2020000L)
                .major("소프트웨어학부")
                .password("1111")
                .build();
        studentService.update(sno, studentRequestDto);
        System.out.println("----------수정 완료!----------");
    }
}
