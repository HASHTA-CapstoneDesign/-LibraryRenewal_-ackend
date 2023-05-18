package hallym.hashtag.domain.notice.service;

import hallym.hashtag.domain.notice.dto.NoticeResponseDto;
import hallym.hashtag.global.baseDto.PageRequestDto;
import hallym.hashtag.global.baseDto.PageResponseDto;

import java.util.List;

public interface NoticeService {

    PageResponseDto<NoticeResponseDto> findAll(PageRequestDto pageRequestDto);

    NoticeResponseDto findByOne(Long nno);

    PageResponseDto<NoticeResponseDto> search(String keyword, PageRequestDto pageRequestDto);
}
