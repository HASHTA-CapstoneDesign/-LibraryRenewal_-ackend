package hallym.hashtag.domain.room.service;

import hallym.hashtag.domain.room.dto.RoomDto;
import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class RoomServicelmpl implements RoomService{
    private final RoomRepository roomRepository;

    @Override
    public List<Room> findAll() {
        List<Room> rooms = roomRepository.findAll();
//        return rooms.stream().map(this::toDto).collect(Collectors.toList());
        return rooms;
    }

    private RoomDto toDto(Room room) {
        return RoomDto.builder()
                .name(room.getName())
                .floor(room.getFloor())
                .roomUseTimes(room.getRoomUseTimes())
                .build();
    }
}
