package hallym.hashtag.domain.room.service;

import hallym.hashtag.domain.room.dto.RoomDto;
import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
