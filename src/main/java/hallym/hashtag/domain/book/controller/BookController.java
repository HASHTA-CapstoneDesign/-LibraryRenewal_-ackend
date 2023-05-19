package hallym.hashtag.domain.book.controller;

import hallym.hashtag.domain.book.dto.BookDto;
import hallym.hashtag.domain.book.service.BookService;
import hallym.hashtag.global.baseDto.PageRequestDto;
import hallym.hashtag.global.baseDto.PageResponseDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/books")
public class BookController {
    private final BookService bookService;

    @ApiOperation(value = "책 전체 조회", notes = "현재 도서관에 소유하고 있는 책을 조회합니다..")
    @GetMapping("list")
    public PageResponseDto<BookDto> bookFindAll(PageRequestDto pageRequestDto) {
        return bookService.findAll(pageRequestDto);
    }

    @ApiOperation(value = "책 최신도서 조회", notes = "현재 도서관에 소유하고 있는 책들 중에서 최근에 등록된 순으로 조회합니다.")
    @GetMapping("recent")
    public List<BookDto> bookFindAllRegDateDesc() {
        return bookService.findAllRestDateDesc();
    }

    @ApiOperation(value = "책 인기도서 조회", notes = "현재 도서관에 소유하고 있는 책들 중에서 대출률이 높은 순으로 조회합니다.")
    @GetMapping("popular")
    public List<BookDto> bookFindAllLoanCount() {
        return bookService.findAllByLoanCount();
    }

    @GetMapping("recommend")
    public List<BookDto> bookFindAllRecommend() throws IOException {
        return bookService.findAllByRecommend();
    }
}
