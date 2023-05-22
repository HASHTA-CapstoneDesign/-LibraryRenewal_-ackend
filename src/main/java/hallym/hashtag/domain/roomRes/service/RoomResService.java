package hallym.hashtag.domain.roomRes.service;

import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
import hallym.hashtag.domain.roomRes.dto.RoomResResponseDto;

public interface RoomResService {

    RoomResResponseDto reserve(RoomResRequestDto roomResRequestDto);

    RoomResResponseDto cancel(Long rrno);
}
