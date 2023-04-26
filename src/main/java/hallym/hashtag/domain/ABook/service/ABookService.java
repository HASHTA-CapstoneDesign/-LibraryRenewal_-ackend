package hallym.hashtag.domain.ABook.service;

import hallym.hashtag.domain.ABook.dto.ABookRequestDto;
import hallym.hashtag.domain.ABook.dto.ABookResponseDto;

public interface ABookService {
    ABookResponseDto create(Long bno, ABookRequestDto aBookRequestDto);

    ABookResponseDto checkOut(Long bno);
}
