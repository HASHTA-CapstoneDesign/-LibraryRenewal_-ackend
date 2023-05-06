package hallym.hashtag.domain.abook.controller;

import hallym.hashtag.domain.abook.dto.ABookRequestDto;
import hallym.hashtag.domain.abook.dto.ABookResponseDto;
import hallym.hashtag.domain.abook.service.ABookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/books/book")
public class ABookController {
    private final ABookService aBookService;

    @PostMapping("{bno}")
    public ABookResponseDto abookCreate(@PathVariable(name = "bno") Long bno,
                                       @RequestBody ABookRequestDto aBookRequestDto){
        return aBookService.create(bno, aBookRequestDto);
    }

    @GetMapping("{bno}")
    public List<ABookResponseDto> abookFindAllByBno(@PathVariable(name = "bno") Long bno) {
        return aBookService.findAllByBook(bno);
    }

}
