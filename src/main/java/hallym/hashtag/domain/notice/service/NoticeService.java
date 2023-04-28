package hallym.hashtag.domain.notice.service;

import hallym.hashtag.domain.notice.dto.NoticeRequestDto;
import hallym.hashtag.domain.notice.dto.NoticeResponseDto;

import java.util.List;

public interface NoticeService {

    NoticeResponseDto create(Long ano, NoticeRequestDto noticeRequestDto);

    List<NoticeResponseDto> findAll();

    NoticeResponseDto findByOne(Long nno);

    NoticeResponseDto update(Long nno, NoticeRequestDto noticeRequestDto);

    String delete(Long nno);
}
