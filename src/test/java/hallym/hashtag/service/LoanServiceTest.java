package hallym.hashtag.service;

import hallym.hashtag.domain.loan.dto.LoanRequestDto;
import hallym.hashtag.domain.loan.service.LoanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoanServiceTest {
    @Autowired
    LoanService loanService;

    @Test
    public void loanCreate() {
        Long abno = 1L;
        Long sno = 1L;

        LoanRequestDto loanRequestDto = LoanRequestDto.builder()
                .build();

        loanService.create(loanRequestDto, sno, abno);
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

        loanService.FindAllByStudent(sno);
    }
}
