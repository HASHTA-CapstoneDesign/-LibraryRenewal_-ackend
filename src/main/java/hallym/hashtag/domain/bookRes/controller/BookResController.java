package hallym.hashtag.domain.bookRes.controller;

import hallym.hashtag.domain.bookRes.dto.BookResResponseDto;
import hallym.hashtag.domain.bookRes.service.BookResService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/reserve/book")
public class BookResController {
    private final BookResService bookResService;

    @ApiOperation(value = "책 예약", notes = "대출 중인 책을 예약합니다.")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "uno", value = "유저 아이디(고유 식별 번호)", required = true, dataTypeClass = Long.class),
                    @ApiImplicitParam(name = "abno", value = "책 한권 아이디(고유 식별 번호)", required = true, dataTypeClass = Long.class)
            })
    @PostMapping("{uno}/{abno}")
    public BookResResponseDto reserve(@PathVariable(name = "uno") Long uno,
                                      @PathVariable(name = "abno") Long abno) {
        return bookResService.reserve(uno, abno);
    }

    @ApiOperation(value = "책 예약 취소", notes = "예약한 책을 취소합니다.")
    @ApiImplicitParam(name = "brno", value = "책 예약 아이디(고유 식별 번호)", required = true, dataTypeClass = Long.class)
    @DeleteMapping("{brno}")
    public String cancel(@PathVariable(name = "brno") Long brno) {
        return bookResService.cancel(brno);
    }

    @ApiOperation(value = "유저별로 책 예약 이력 조회", notes = "유저별로 대출 이력을 조회합니다.")
    @ApiImplicitParam(name = "uno", value = "유저 아이디(고유 식별 번호)", required = true, dataTypeClass = Long.class)
    @GetMapping("{uno}")
    public List<BookResResponseDto> findByStudent(@PathVariable(name = "uno") Long uno) {
        return bookResService.findByUser(uno);
    }
}
