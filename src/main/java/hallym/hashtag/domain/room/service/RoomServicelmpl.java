package hallym.hashtag.domain.room.service;

import hallym.hashtag.domain.room.dto.RoomDto;
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
public class RoomServicelmpl implements RoomService{
    private final RoomRepository roomRepository;

    @Override
    public RoomDto create(RoomDto roomDto) {
        roomRepository.save(toEntity(roomDto));
        return roomDto;
    }

    @Override
    public List<RoomDto> search(String name) {
        List<Room> roomList = roomRepository.findByNameContaining(name);
        if(roomList == null) return null;
        else return roomList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Room toEntity(RoomDto roomDto) {
        return Room.builder()
                .rno(roomDto.getRno())
                .name(roomDto.getName())
                .content(roomDto.getContent())
                .floor(roomDto.getFloor())
                .build();
    }

    public RoomDto toDto(Room room) {
        return RoomDto.builder()
                .rno(room.getRno())
                .name(room.getName())
                .content(room.getContent())
                .floor(room.getFloor())
                .build();
    }
}
