package hallym.hashtag.domain.book.controller;

import hallym.hashtag.domain.book.dto.BookDto;
import hallym.hashtag.domain.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("book")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public BookDto bookCreate(@RequestBody BookDto bookDto) {
        return bookService.create(bookDto);
    }
}
