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
        Long sno = 1L;

        LongStream.rangeClosed(1,3).forEach(i -> {
            LoanRequestDto loanRequestDto = LoanRequestDto.builder()
                    .build();
            loanService.create(loanRequestDto, sno, i);
        });

    }

    @Test
    public void loanUpdate() {
        Long sno = 1L;
        Long lno = 1L;

        loanService.extension(sno, lno);
    }

    @Test
    public void loanReturn() {
        Long sno = 1L;
        Long lno = 1L;

        loanService.returnBook(sno, lno);
    }

    @Test
    public void loanFindAllStudent() {
        Long sno = 1L;

        loanService.findAllByStudent(sno);
    }

    @Test
    public void loanFindbyABook() {
        Long abno = 1L;

        loanService.findAllByABook(abno);
    }
}
