package hallym.hashtag.domain.room.service;

import hallym.hashtag.domain.room.dto.RoomDto;
import hallym.hashtag.domain.room.entity.Floor;

import java.util.List;

public interface RoomService {
    List<RoomDto> findAll(Floor floor, String Data);
}
