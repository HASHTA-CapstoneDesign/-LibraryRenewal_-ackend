package hallym.hashtag.domain.notice.controller;

import hallym.hashtag.domain.notice.dto.NoticeRequestDto;
import hallym.hashtag.domain.notice.dto.NoticeResponseDto;
import hallym.hashtag.domain.notice.service.NoticeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/notice")
public class NoticeController {
    private final NoticeService noticeService;

    @ApiOperation(value = "공지사항 작성")
    @PostMapping("{uno}")
    public NoticeResponseDto noticeCreate(@PathVariable(name = "uno") Long uno,
                                          @RequestBody NoticeRequestDto noticeRequestDto) {
        return noticeService.create(uno, noticeRequestDto);
    }

    @ApiOperation(value = "공지사항 전체 조회", notes = "공지사항 전체 조회 합니다." +
            "중요도와 시간 순으로 정렬하여 조회합니다." +
            "이미지와 페이징이 추가됩니다.")
    @GetMapping("list")
    public List<NoticeResponseDto> noticeFindAll() {
        return noticeService.findAll();
    }

    @ApiOperation(value = "공지사항 상세 조회", notes = "공지사항 상세 조회 합니다.")
    @ApiImplicitParam(name = "nno", value = "공지사항 아이디(고유 식별 번호)", required = true, dataTypeClass = Long.class)
    @GetMapping("{nno}")
    public NoticeResponseDto noticeFindByOne(@PathVariable(name = "nno") Long nno) {
        return noticeService.findByOne(nno);
    }

    @ApiOperation(value = "공지사항 수정")
    @PutMapping("{nno}")
    public NoticeResponseDto noticeUpdate(@PathVariable(name = "nno") Long nno,
                                          @RequestBody NoticeRequestDto noticeRequestDto) {
        return noticeService.update(nno, noticeRequestDto);
    }

    @ApiOperation(value = "공지사항 삭제")
    @DeleteMapping("{nno}")
    public String noticeDelete(@PathVariable(name = "nno") Long nno) {
        return noticeService.delete(nno);
    }

    @ApiOperation(value = "공지사항 검색", notes = "공지사항 검색합니다." +
            "이미지와 페이징이 추가됩니다.")
    @GetMapping
    public List<NoticeResponseDto> noticeSearch(@RequestParam(value = "keyword") String keyword){
        return noticeService.search(keyword);
    }
}
