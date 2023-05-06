package hallym.hashtag.service;

import hallym.hashtag.domain.loan.dto.LoanRequestDto;
import hallym.hashtag.domain.loan.service.LoanService;
import hallym.hashtag.domain.loan.service.LoanServicelmpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

@SpringBootTest
public class LoanServiceTest {
    @Autowired
    LoanService loanService;

    @Test
    public void loanCreate() {
        Long uno = 1L;
        LongStream.rangeClosed(1,3).forEach(i -> loanService.create(uno, i));

    }

    @Test
    public void loanUpdate() {
        Long lno = 1L;
        loanService.extension(lno);
    }

    @Test
    public void loanReturn() {
        Long lno = 1L;
        loanService.returnBook(lno);
    }

    @Test
    public void loanFindAllUser() {
        Long uno = 1L;
        loanService.findAllByUser(uno);
    }
}
