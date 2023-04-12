package hallym.hashtag.domain.book.service;

import hallym.hashtag.domain.book.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto create(BookDto bookDto);

    List<BookDto> findAll();

    BookDto findByOne(Long bno);

    BookDto update(Long bno, BookDto bookDto);
}
