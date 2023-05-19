package hallym.hashtag.domain.book.service;

import hallym.hashtag.domain.book.dto.BookDto;
import hallym.hashtag.global.baseDto.PageRequestDto;
import hallym.hashtag.global.baseDto.PageResponseDto;

import java.io.IOException;
import java.util.List;

public interface BookService {

    PageResponseDto<BookDto> findAll(PageRequestDto pageRequestDto) ;

    List<BookDto> findAllRestDateDesc();

    List<BookDto> findAllByLoanCount();

//    List<BookDto> findAllByRecommend() throws IOException;

    List<BookDto> findAllByRecommend() throws IOException;
    List<BookDto> findAllByRecommend(Long uno);
}
