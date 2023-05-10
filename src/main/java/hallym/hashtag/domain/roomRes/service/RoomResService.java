package hallym.hashtag.domain.roomRes.service;

import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
import hallym.hashtag.domain.roomRes.dto.RoomResResponseDto;

import java.util.List;

public interface RoomResService {
    RoomResResponseDto reserve(Long uno, Long rno, RoomResRequestDto roomResRequestDto);
    String cancel(Long rrno);
    List<RoomResResponseDto> findByUser(Long uno);
}
