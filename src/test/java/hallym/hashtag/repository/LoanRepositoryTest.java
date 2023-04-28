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
import java.util.List;
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

    @Test
    public void testFindByStudent() {
        Long sno = 1L;
        List<Loan> loanList = loanRepository.findByStudent_sno(sno);
        System.out.println(loanList.size());
    }

    @Test
    public void testFindByABook() {
        Long abno = 1L;
        List<Loan> loanList = loanRepository.findByABook_abno(abno);
        System.out.println(loanList.size());
    }
}
