package hallym.hashtag.domain.notice.service;

import hallym.hashtag.domain.notice.dto.NoticeResponseDto;

import java.util.List;

public interface NoticeService {

    List<NoticeResponseDto> findAll();

    NoticeResponseDto findByOne(Long nno);

    List<NoticeResponseDto> search(String keyword);
}
