package hallym.hashtag.domain.loan.controller;

import hallym.hashtag.domain.loan.dto.LoanRequestDto;
import hallym.hashtag.domain.loan.dto.LoanResponseDto;
import hallym.hashtag.domain.loan.service.LoanService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/loan")
public class LoanController {
    private final LoanService loanService;

    @ApiOperation(value = "책 대출", notes = "책을 대출합니다.")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "uno", value = "유저 아이디(고유 식별 번호)", required = true, dataTypeClass = Long.class)
                    ,
                    @ApiImplicitParam(name = "abno", value = "책 한권 아이디(고유 식별 번호)", required = true, dataTypeClass = Long.class)
            })
    @PostMapping("{uno}/{abno}")
    public LoanResponseDto loanCreate(@PathVariable(name = "uno") Long uno,
                                      @PathVariable(name = "abno") Long abno){
        return loanService.create(uno, abno);
    }

    @ApiOperation(value = "책 대출 연장", notes = "책을 대출기한을 연장합니다.")
    @ApiImplicitParam(name = "lno", value = "대출이력 아이디(고유 식별 번호)", required = true, dataTypeClass = Long.class)
    @PutMapping("checkout/{lno}")
    public LoanResponseDto loanExtension(@PathVariable(name = "lno") Long lno){
        return loanService.extension(lno);
    }

    @ApiOperation(value = "책 반납", notes = "대출한 책을 반납합니다.")
    @ApiImplicitParam(name = "lno", value = "대출이력 아이디(고유 식별 번호)", required = true, dataTypeClass = Long.class)
    @PutMapping("return/{lno}")
    public LoanResponseDto loanReturn(@PathVariable(name = "lno") Long lno) {
        return loanService.returnBook(lno);
    }

    @ApiOperation(value = "유저별로 대출 이력 조회", notes = "유저별로 대출 이력을 조회합니다.")
    @ApiImplicitParam(name = "uno", value = "유저 아이디(고유 식별 번호)", required = true, dataTypeClass = Long.class)
    @GetMapping("list/{uno}")
    public List<LoanResponseDto> loanFindAllStudent(@PathVariable(name = "uno") Long uno) {
        return loanService.findAllByUser(uno);
    }
}
