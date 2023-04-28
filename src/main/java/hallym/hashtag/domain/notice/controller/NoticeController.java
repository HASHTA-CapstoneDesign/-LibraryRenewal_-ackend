package hallym.hashtag.domain.notice.controller;

import hallym.hashtag.domain.notice.dto.NoticeRequestDto;
import hallym.hashtag.domain.notice.dto.NoticeResponseDto;
import hallym.hashtag.domain.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("notice")
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping("{ano}")
    public NoticeResponseDto noticeCreate(@PathVariable(name = "ano") Long ano,
                                          @RequestBody NoticeRequestDto noticeRequestDto) {
        return noticeService.create(ano, noticeRequestDto);
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
}
