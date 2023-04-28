package hallym.hashtag.domain.book.controller;

import hallym.hashtag.domain.book.dto.BookDto;
import hallym.hashtag.domain.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public BookDto bookCreate(@RequestBody BookDto bookDto) {
        return bookService.create(bookDto);
    }

    @GetMapping("list")
    public List<BookDto> bookFindAll() {
        return bookService.findAll();
    }

    @GetMapping("{bno}")
    public BookDto bookFindByOne(@PathVariable(name = "bno") Long bno) {
        return bookService.findByOne(bno);
    }

    @PutMapping("{bno}")
    public BookDto bookUpdate(@PathVariable(name = "bno") Long bno, @RequestBody BookDto bookDto) {
        return bookService.update(bno, bookDto);
    }

    @DeleteMapping("{bno}")
    public String bookDelete(@PathVariable(name = "bno") Long bno){
        return bookService.delete(bno);
    }

    @GetMapping("recent")
    public List<BookDto> bookFindAllRegDateDesc() {
        return bookService.findAllRestDateDesc();
    }

    @GetMapping("popular")
    public List<BookDto> bookFindAllLoanCount() {
        return bookService.findAllByLoanCount();
    }
}
