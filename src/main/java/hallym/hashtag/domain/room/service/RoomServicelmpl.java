package hallym.hashtag.domain.room.service;

import hallym.hashtag.domain.room.dto.RoomDto;
import hallym.hashtag.domain.room.entity.Floor;
import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class RoomServicelmpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public List<RoomDto> findAll(Floor floor, String Data) {
        List<Room> roomList = roomRepository.findByFloorAndAndUseData(floor, Data);
        return roomList.stream().map(this::toDto).collect(Collectors.toList());
    }

    private RoomDto toDto(Room room) {
        return RoomDto.builder()
                .floor(room.getFloor())
                .name(room.getName())
                .useData(room.getUseData())
                .useTimes(room.getUseTimes())
                .build();
    }
}
