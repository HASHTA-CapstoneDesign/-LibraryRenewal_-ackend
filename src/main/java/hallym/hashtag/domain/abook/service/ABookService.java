package hallym.hashtag.domain.abook.service;

import hallym.hashtag.domain.abook.dto.ABookRequestDto;
import hallym.hashtag.domain.abook.dto.ABookResponseDto;

import java.util.List;

public interface ABookService {
    ABookResponseDto create(Long bno, ABookRequestDto aBookRequestDto);

    List<ABookResponseDto> findAllByBook(Long bno);
}
