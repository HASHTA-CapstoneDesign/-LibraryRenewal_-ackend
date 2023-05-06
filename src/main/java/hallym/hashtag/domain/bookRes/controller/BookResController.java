package hallym.hashtag.domain.bookRes.controller;

import hallym.hashtag.domain.bookRes.dto.BookResResponseDto;
import hallym.hashtag.domain.bookRes.service.BookResService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/reserve/book")
public class BookResController {
    private final BookResService bookResService;

    @PostMapping("{uno}/{abno}")
    public BookResResponseDto reserve(@PathVariable(name = "uno") Long uno,
                                      @PathVariable(name = "abno") Long abno) {
        return bookResService.reserve(uno, abno);
    }

    @DeleteMapping("{brno}")
    public String cancel(@PathVariable(name = "brno") Long brno) {
        return bookResService.cancel(brno);
    }

    @GetMapping("{uno}")
    public List<BookResResponseDto> findByStudent(@PathVariable(name = "uno") Long uno) {
        return bookResService.findByUser(uno);
    }
}
