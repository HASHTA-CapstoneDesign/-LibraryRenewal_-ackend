package hallym.hashtag.repository;

import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.abook.repostory.ABookRepository;
import hallym.hashtag.domain.loan.entity.Loan;
import hallym.hashtag.domain.loan.repostory.LoanRepository;
import hallym.hashtag.domain.user.entity.User;
import hallym.hashtag.domain.user.repository.UserRepository;
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
    UserRepository userRepository;

    @Test
    public void testSave() {
        LocalDate creDate = LocalDate.now();
        LocalDate retDate = creDate.plusDays(7);
        Optional<ABook> byAbno = aBookRepository.findById(1L);
        Optional<User> byUno = userRepository.findById(1L);
        Loan loan = Loan.builder()
                .aBook(byAbno.get())
                .user(byUno.get())
                .retDate(retDate)
                .build();
        loanRepository.save(loan);
    }

    @Test
    public void testFindByUser() {
        Long uno = 1L;
        List<Loan> loanList = loanRepository.findByUser_uno(uno);
        System.out.println(loanList.size());
    }
}
