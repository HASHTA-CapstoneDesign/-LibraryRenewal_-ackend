package hallym.hashtag.domain.roomRes.service;

import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
import hallym.hashtag.domain.roomRes.dto.RoomResResponseDto;
import hallym.hashtag.global.baseDto.PageRequestDto;
import hallym.hashtag.global.baseDto.PageResponseDto;

public interface RoomResService {

    RoomResResponseDto reserve(RoomResRequestDto roomResRequestDto);

    RoomResResponseDto cancel(Long rrno);

    PageResponseDto<RoomResResponseDto> findAllUno(Long uno, PageRequestDto pageRequestDto);
}
