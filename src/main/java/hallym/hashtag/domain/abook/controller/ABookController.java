package hallym.hashtag.domain.abook.controller;

import hallym.hashtag.domain.abook.dto.ABookRequestDto;
import hallym.hashtag.domain.abook.dto.ABookResponseDto;
import hallym.hashtag.domain.abook.service.ABookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/books/book")
public class ABookController {
    private final ABookService aBookService;

    @ApiOperation(value = "책 한 권 추가")
//    @ApiImplicitParam(
//            name = "bno"
//            , value = "책 id"
//            , dataType = "string")
    @PostMapping("{bno}")
    public ABookResponseDto abookCreate(@PathVariable(name = "bno") Long bno,
                                       @RequestBody ABookRequestDto aBookRequestDto){
        return aBookService.create(bno, aBookRequestDto);
    }

//    @ApiOperation(value = "책정보 별로 대출 현황 조회", notes = "bno")
    @ApiOperation(value = "책정보 별로 대출 현황 조회")
    @GetMapping("{bno}")
    public List<ABookResponseDto> abookFindAllByBno(@PathVariable(name = "bno") Long bno) {
        return aBookService.findAllByBook(bno);
    }

}
