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
        Room room = toEntity(roomDto);
        roomRepository.save(room);
        return toDto(room);
    }

    @Override
    public List<RoomDto> searchByAll(String name) {
        List<Room> roomList = roomRepository.findByNameContaining(name);
        if(roomList == null) return null;
        else return roomList.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<RoomDto> searchByStudy() {
        List<Room> roomList = roomRepository.findAllByStudyRoom(Boolean.TRUE);
        return roomList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Room toEntity(RoomDto roomDto) {
        return Room.builder()
                .rno(roomDto.getRno())
                .name(roomDto.getName())
                .content(roomDto.getContent())
                .floor(roomDto.getFloor())
                .studyRoom(roomDto.isStudyRoom())
                .build();
    }

    public RoomDto toDto(Room room) {
        return RoomDto.builder()
                .rno(room.getRno())
                .name(room.getName())
                .content(room.getContent())
                .floor(room.getFloor())
                .studyRoom(room.isStudyRoom())
                .build();
    }
}
