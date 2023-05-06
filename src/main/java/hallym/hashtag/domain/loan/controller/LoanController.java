package hallym.hashtag.domain.loan.controller;

import hallym.hashtag.domain.loan.dto.LoanRequestDto;
import hallym.hashtag.domain.loan.dto.LoanResponseDto;
import hallym.hashtag.domain.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/loan")
public class LoanController {
    private final LoanService loanService;
    @PostMapping("{uno}/{abno}")
    public LoanResponseDto loanCreate(@PathVariable(name = "uno") Long uno,
                                      @PathVariable(name = "abno") Long abno){
        return loanService.create(uno, abno);
    }

    @PutMapping("checkout/{lno}")
    public LoanResponseDto loanExtension(@PathVariable(name = "lno") Long lno){
        return loanService.extension(lno);
    }

    @PutMapping("return/{lno}")
    public LoanResponseDto loanReturn(@PathVariable(name = "lno") Long lno) {
        return loanService.returnBook(lno);
    }

    @GetMapping("list/{uno}")
    public List<LoanResponseDto> loanFindAllStudent(@PathVariable(name = "uno") Long uno) {
        return loanService.findAllByUser(uno);
    }
}
