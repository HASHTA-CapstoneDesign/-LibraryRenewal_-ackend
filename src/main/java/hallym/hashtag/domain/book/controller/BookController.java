package hallym.hashtag.domain.book.controller;

import hallym.hashtag.domain.book.dto.BookDto;
import hallym.hashtag.domain.book.service.BookService;
import hallym.hashtag.global.baseDto.PageRequestDto;
import hallym.hashtag.global.baseDto.PageResponseDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/books")
public class BookController {
    private final BookService bookService;

    @ApiOperation(value = "책정보 추가")
    @PostMapping
    public BookDto bookCreate(@RequestBody BookDto bookDto) {
        return bookService.create(bookDto);
    }

    @ApiOperation(value = "책 전체 조회", notes = "현재 도서관에 소유하고 있는 책을 조회합니다. 이미지가 들어갈 예정입니다.")
    @GetMapping("list")
    public PageResponseDto<BookDto> bookFindAll(PageRequestDto pageRequestDto) {
        return bookService.findAll(pageRequestDto);
    }

    @ApiOperation(value = "책 정보 상세 조회", notes = "책에 대한 정보 조회합니다.")
    @ApiImplicitParam(
            name = "bno"
            , value = "책 id"
            , dataType = "Long")
    @GetMapping("{bno}")
    public BookDto bookFindByOne(@PathVariable(name = "bno") Long bno) {
        return bookService.findByOne(bno);
    }

    @ApiOperation(value = "책 정보 수정")
    @PutMapping("{bno}")
    public BookDto bookUpdate(@PathVariable(name = "bno") Long bno, @RequestBody BookDto bookDto) {
        return bookService.update(bno, bookDto);
    }

    @ApiOperation(value = "책 정보 삭제")
    @DeleteMapping("{bno}")
    public String bookDelete(@PathVariable(name = "bno") Long bno){
        return bookService.delete(bno);
    }

    @ApiOperation(value = "책 최신도서 조회", notes = "현재 도서관에 소유하고 있는 책들 중에서 최근에 등록된 순으로 조회합니다." +
            "페이징과 이미지가 들어갈 예정입니다.")
    @GetMapping("recent")
    public List<BookDto> bookFindAllRegDateDesc() {
        return bookService.findAllRestDateDesc();
    }

    @ApiOperation(value = "책 인기도서 조회", notes = "현재 도서관에 소유하고 있는 책들 중에서 대출률이 높은 순으로 조회합니다." +
            "페이징과 이미지가 들어갈 예정입니다.")
    @GetMapping("popular")
    public List<BookDto> bookFindAllLoanCount() {
        return bookService.findAllByLoanCount();
    }
}
