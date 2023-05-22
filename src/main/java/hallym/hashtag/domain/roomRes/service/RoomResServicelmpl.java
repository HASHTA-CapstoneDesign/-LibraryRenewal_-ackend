package hallym.hashtag.domain.roomRes.service;

import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.room.entity.RoomReserve;
import hallym.hashtag.domain.room.entity.UseTime;
import hallym.hashtag.domain.room.repository.RoomRepository;
import hallym.hashtag.domain.room.repository.UseTimeRepository;
import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
import hallym.hashtag.domain.roomRes.dto.RoomResResponseDto;
import hallym.hashtag.domain.roomRes.entity.RoomRes;
import hallym.hashtag.domain.roomRes.entity.RoomResReserve;
import hallym.hashtag.domain.roomRes.repository.RoomResRepository;
import hallym.hashtag.domain.user.entity.User;
import hallym.hashtag.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class RoomResServicelmpl implements RoomResService {
    private final RoomResRepository roomResRepository;
    private final RoomRepository roomRepository;
    private final UseTimeRepository useTimeRepository;
    private final UserRepository userRepository;


    @Override
    public RoomResResponseDto reserve(RoomResRequestDto roomResRequestDto) {
        Optional<Room> byRno = roomRepository.findById(roomResRequestDto.getRno());
        if (byRno.isEmpty()) return null;
        Optional<User> byUno = userRepository.findById(roomResRequestDto.getUno());
        if(byUno.isEmpty()) return null;
        List<UseTime> byRtnos = useTimeRepository.findAllById(roomResRequestDto.getRtnos());

        RoomRes roomRes = toDto(byRno, byUno, byRtnos);
        roomResRepository.save(roomRes);

        for (int i = 0; i < byRtnos.size(); i++) {
            UseTime useTime = byRtnos.get(i);
            useTime.setRoomReserve(RoomReserve.예약불가);
            useTimeRepository.save(useTime);
        }

        return toEntity(roomRes);
    }

    @Override
    public RoomResResponseDto cancel(Long rrno) {
        Optional<RoomRes> byRrno = roomResRepository.findById(rrno);
        if(byRrno.isEmpty()) return null;
        RoomRes roomRes = byRrno.get();
        roomRes.setRoomReserve(RoomResReserve.사용자취소);
        roomResRepository.save(roomRes);
        List<UseTime> useTimes = roomRes.getRoom().getUseTimes();
        for (int i = 0; i < useTimes.size(); i++) {
            UseTime useTime = useTimes.get(i);
            useTime.setRoomReserve(RoomReserve.예약가능);
            useTimeRepository.save(useTime);
        }
        return toEntity(roomRes);
    }

    private RoomRes toDto(Optional<Room> byRno, Optional<User> byUno, List<UseTime> byRtnos) {
        return RoomRes.builder()
                .room(byRno.get())
                .user(byUno.get())
                .useTimes(byRtnos)
                .build();
    }

    private RoomResResponseDto toEntity(RoomRes roomRes) {
        List<String> times = new ArrayList<>();
        for (int i = 0; i < roomRes.getUseTimes().size(); i++) {
            String time = roomRes.getUseTimes().get(i).getTime();
            times.add(time);
        }
        return RoomResResponseDto.builder()
                .creDate(roomRes.getCreDate())
                .roomReserve(roomRes.getRoomReserve())
                .floor(roomRes.getRoom().getFloor())
                .roomName(roomRes.getRoom().getName())
                .useTimes(times)
                .build();
    }
}
