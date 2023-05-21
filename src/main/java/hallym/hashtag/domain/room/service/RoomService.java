package hallym.hashtag.domain.room.service;

import hallym.hashtag.domain.room.dto.RoomDto;
import hallym.hashtag.domain.room.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();
}
