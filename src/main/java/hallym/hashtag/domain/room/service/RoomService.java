package hallym.hashtag.domain.room.service;

import hallym.hashtag.domain.room.dto.RoomDto;

import java.util.List;

public interface RoomService {
    RoomDto create(RoomDto roomDto);

    List<RoomDto> search(String name);
}
