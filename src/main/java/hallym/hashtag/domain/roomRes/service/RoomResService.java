package hallym.hashtag.domain.roomRes.service;

import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
import hallym.hashtag.domain.roomRes.dto.RoomResResponseDto;

public interface RoomResService {
    RoomResResponseDto reserve(Long uno, Long rno, RoomResRequestDto roomResRequestDto);
}
