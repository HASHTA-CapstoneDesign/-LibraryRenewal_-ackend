package hallym.hashtag.domain.bookRes.service;

import hallym.hashtag.domain.bookRes.dto.BookResResponseDto;

public interface BookResService {
    BookResResponseDto reserve(Long ano, Long sno);

    String cancel(Long brno);
}
