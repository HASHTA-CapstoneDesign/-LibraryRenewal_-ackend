package hallym.hashtag.repository;

import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.abook.repostory.ABookRepository;
import hallym.hashtag.domain.loan.entity.Loan;
import hallym.hashtag.domain.loan.repostory.LoanRepository;
import hallym.hashtag.domain.student.entity.Student;
import hallym.hashtag.domain.student.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ABookRepository aBookRepository;
    @Autowired
    private LoanRepository loanRepository;

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

    @Test
    public void testSetLoan() {
        Student student = studentRepository.save(Student.builder()
                .name("홍길동")
                .phone("010-0000-0000")
                .cleanup(2020000L)
                .major("소프트웨어학부")
                .password("1111").build());

        LocalDate creDate1 = LocalDate.now();
        LocalDate retDate1 = creDate1.plusDays(7);
        Optional<ABook> byAbno1 = aBookRepository.findById(1L);
        Loan loan1 = Loan.builder()
                .aBook(byAbno1.get())
                .retDate(retDate1)
                .build();

        LocalDate creDate2 = LocalDate.now();
        LocalDate retDate2 = creDate2.plusDays(7);
        Optional<ABook> byAbno2 = aBookRepository.findById(1L);
        Loan loan2 = Loan.builder()
                .aBook(byAbno2.get())
                .retDate(retDate2)
                .build();

        loan1.setStudent(student);
        loan2.setStudent(student);
        loanRepository.save(loan1);
        loanRepository.save(loan2);

        assertThat(student.getLoans().size()).isEqualTo(2);

    }


}
