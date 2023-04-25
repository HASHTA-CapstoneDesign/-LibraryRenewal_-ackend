package hallym.hashtag.domain.ABook.controller;

import hallym.hashtag.domain.ABook.dto.ABookRequestDto;
import hallym.hashtag.domain.ABook.dto.ABookResponseDto;
import hallym.hashtag.domain.ABook.service.ABookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("books/book")
public class ABookController {
    private final ABookService aBookService;

    @PostMapping("{bno}")
    public ABookResponseDto bookCreate(@PathVariable(name = "bno") Long bno,
                                       @RequestBody ABookRequestDto aBookRequestDto){
        return aBookService.create(bno, aBookRequestDto);
    }

}
