package hallym.hashtag.domain.book.service;

import hallym.hashtag.domain.book.dto.BookDto;
import hallym.hashtag.global.baseDto.PageRequestDto;
import hallym.hashtag.global.baseDto.PageResponseDto;

import java.util.List;

public interface BookService {
    BookDto create(BookDto bookDto);

    PageResponseDto<BookDto> findAll(PageRequestDto pageRequestDto) ;

    BookDto findByOne(Long bno);

    BookDto update(Long bno, BookDto bookDto);

    String delete(Long bno);

    List<BookDto> findAllRestDateDesc();

    List<BookDto> findAllByLoanCount();
}
