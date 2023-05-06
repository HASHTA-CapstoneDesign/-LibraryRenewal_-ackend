package hallym.hashtag.domain.notice.controller;

import hallym.hashtag.domain.notice.dto.NoticeRequestDto;
import hallym.hashtag.domain.notice.dto.NoticeResponseDto;
import hallym.hashtag.domain.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/notice")
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping("{uno}")
    public NoticeResponseDto noticeCreate(@PathVariable(name = "uno") Long uno,
                                          @RequestBody NoticeRequestDto noticeRequestDto) {
        return noticeService.create(uno, noticeRequestDto);
    }

    @GetMapping("list")
    public List<NoticeResponseDto> noticeFindAll() {
        return noticeService.findAll();
    }

    @GetMapping("{nno}")
    public NoticeResponseDto noticeFindByOne(@PathVariable(name = "nno") Long nno) {
        return noticeService.findByOne(nno);
    }

    @PutMapping("{nno}")
    public NoticeResponseDto noticeUpdate(@PathVariable(name = "nno") Long nno,
                                          @RequestBody NoticeRequestDto noticeRequestDto) {
        return noticeService.update(nno, noticeRequestDto);
    }

    @DeleteMapping("{nno}")
    public String noticeDelete(@PathVariable(name = "nno") Long nno) {
        return noticeService.delete(nno);
    }

    @GetMapping
    public List<NoticeResponseDto> noticeSearch(@RequestParam(value = "keyword") String keyword){
        return noticeService.search(keyword);
    }
}
