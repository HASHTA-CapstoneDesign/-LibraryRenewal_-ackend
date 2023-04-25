package hallym.hashtag.domain.loan.controller;

import hallym.hashtag.domain.loan.dto.LoanRequestDto;
import hallym.hashtag.domain.loan.dto.LoanResponseDto;
import hallym.hashtag.domain.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("student/loan")
public class LoanController {
    private final LoanService loanService;
    @PostMapping("{sno}/{abno}")
    public LoanResponseDto loanCreate(@PathVariable(name = "sno") Long sno,
                                      @PathVariable(name = "abno") Long abno){

        LoanRequestDto loanRequestDto = LoanRequestDto.builder().build();

        return loanService.create(loanRequestDto, sno, abno);
    }

    @PutMapping("checkout/{sno}/{lno}")
    public LoanResponseDto loanExtension(@PathVariable(name = "sno") Long sno,
                                      @PathVariable(name = "lno") Long lno){
        return loanService.extension(sno, lno);
    }

    @PutMapping("return/{sno}/{lno}")
    public LoanResponseDto loanReturn(@PathVariable(name = "sno") Long sno,
                                      @PathVariable(name = "lno") Long lno) {
        return loanService.returnBook(sno, lno);
    }

    @GetMapping("{sno}")
    public List<LoanResponseDto> loanFindAllStudent(@PathVariable(name = "sno") Long sno) {
        return loanService.FindAllByStudent(sno);
    }
}
