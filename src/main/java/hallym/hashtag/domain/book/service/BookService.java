package hallym.hashtag.domain.book.service;

import hallym.hashtag.domain.book.dto.BookDto;
import hallym.hashtag.global.baseDto.PageRequestDto;
import hallym.hashtag.global.baseDto.PageResponseDto;

import java.util.List;

public interface BookService {

    PageResponseDto<BookDto> findAll(PageRequestDto pageRequestDto) ;

    List<BookDto> findAllRestDateDesc();

    List<BookDto> findAllByLoanCount();
}
