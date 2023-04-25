package hallym.hashtag.repository;

import hallym.hashtag.domain.ABook.entity.ABook;
import hallym.hashtag.domain.ABook.repostory.ABookRepository;
import hallym.hashtag.domain.loan.entity.Loan;
import hallym.hashtag.domain.loan.repostory.LoanRepository;
import hallym.hashtag.domain.student.entity.Student;
import hallym.hashtag.domain.student.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class LoanRepositoryTest {
    @Autowired
    LoanRepository loanRepository;
    @Autowired
    ABookRepository aBookRepository;
    @Autowired
    StudentRepository studentRepository;

    @Test
    public void testSave() {
        LocalDate creDate = LocalDate.now();
        LocalDate retDate = creDate.plusDays(7);
        Optional<ABook> byAbno = aBookRepository.findById(1L);
        Optional<Student> bySno = studentRepository.findById(1L);
        Loan loan = Loan.builder()
                .aBook(byAbno.get())
                .student(bySno.get())
                .retDate(retDate)
                .build();
        loanRepository.save(loan);
    }

}
