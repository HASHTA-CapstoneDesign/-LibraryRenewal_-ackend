package hallym.hashtag.domain.roomRes.service;

import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.room.repository.RoomRepository;
import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
import hallym.hashtag.domain.roomRes.dto.RoomResResponseDto;
import hallym.hashtag.domain.roomRes.entity.RoomRes;
import hallym.hashtag.domain.roomRes.entity.UseTime;
import hallym.hashtag.domain.roomRes.repository.RoomResRepository;
import hallym.hashtag.domain.roomRes.repository.UseTimeRepository;
import hallym.hashtag.domain.user.entity.User;
import hallym.hashtag.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class RoomResServicelmpl implements RoomResService{
    private final RoomResRepository roomResRepository;
    private final UseTimeRepository useTimeRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @Override
    public RoomResResponseDto reserve(Long uno, Long rno, RoomResRequestDto roomResRequestDto) {
        Optional<User> byUno = userRepository.findById(uno);
        if(byUno.isEmpty()) return null;
        Optional<Room> byRno = roomRepository.findById(rno);
        if (byRno.isEmpty()) return null;

        RoomRes roomRes = toEntity(roomResRequestDto);
        Room room = byRno.get();
        roomRes.setRoom(room);
        room.setReserve(Boolean.TRUE); //예약 중으로 저장
        roomRes.setUser(byUno.get());

        List<UseTime> useTimes = roomResRequestDto.getUseTimes();
        for (int i = 0; i < useTimes.size(); i++) {
            useTimes.get(i).setRoomRes(roomRes);
        }

        useTimeRepository.saveAll(useTimes);
        roomRepository.save(room);
        roomResRepository.save(roomRes);
        return toDto(roomRes);
    }

    public RoomRes toEntity(RoomResRequestDto roomResRequestDto) {
        return RoomRes.builder()
                .rrno(roomResRequestDto.getRrno())
                .creDate(roomResRequestDto.getCreDate())
                .room(roomResRequestDto.getRoom())
                .useDate(roomResRequestDto.getUseDate())
                .user(roomResRequestDto.getUser())
                .build();
    }

    public RoomResResponseDto toDto(RoomRes roomRes) {
        return RoomResResponseDto.builder()
                .rrno(roomRes.getRrno())
                .roomName(roomRes.getRoom().getName())
                .useDate(roomRes.getUseDate())
                .creDate(roomRes.getCreDate())
                .build();
    }


}
