package hallym.hashtag.domain.roomRes.service;

import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.room.repository.RoomRepository;
import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
import hallym.hashtag.domain.roomRes.dto.RoomResResponseDto;
import hallym.hashtag.domain.roomRes.entity.RoomRes;
import hallym.hashtag.domain.roomRes.repository.RoomResRepository;
import hallym.hashtag.domain.user.entity.User;
import hallym.hashtag.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class RoomResServicelmpl implements RoomResService{
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final RoomResRepository roomResRepository;

    @Override
    public RoomResResponseDto reserve(Long uno, Long rno, RoomResRequestDto roomResRequestDto) {
        RoomRes roomRes = toEntity(roomResRequestDto);
        Optional<User> byUno = userRepository.findById(uno);
        if(byUno.isEmpty()) return null;
        roomRes.setUser(byUno.get());
        Optional<Room> byRno = roomRepository.findById(rno);
        if(byRno.isEmpty()) return null;
        Room room = byRno.get();
        room.setReserve(Boolean.TRUE);
        roomRepository.save(room);
        roomRes.setRoom(byRno.get());
        roomResRepository.save(roomRes);
        return toDto(roomRes);
    }

    private RoomRes toEntity(RoomResRequestDto roomResRequestDto) {
        return RoomRes.builder()
                .useTimes(roomResRequestDto.getUseTimes())
                .useData(roomResRequestDto.getUseData())
                .build();
    }

    private RoomResResponseDto toDto(RoomRes roomRes) {
        return RoomResResponseDto.builder()
                .rrno(roomRes.getRrno())
                .roomName(roomRes.getRoom().getName())
                .useTimes(roomRes.getUseTimes())
                .useData(roomRes.getUseData())
                .build();

    }
}
