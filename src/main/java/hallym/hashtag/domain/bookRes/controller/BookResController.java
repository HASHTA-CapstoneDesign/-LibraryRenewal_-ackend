package hallym.hashtag.domain.bookRes.controller;

import hallym.hashtag.domain.bookRes.dto.BookResResponseDto;
import hallym.hashtag.domain.bookRes.service.BookResService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("reserve/book")
public class BookResController {
    private final BookResService bookResService;

    @PostMapping("{sno}/{abno}")
    public BookResResponseDto reserve(@PathVariable(name = "sno") Long sno,
                                      @PathVariable(name = "abno") Long abno) {
        return bookResService.reserve(sno, abno);
    }
}
