package hallym.hashtag.domain.roomRes.service;

import hallym.hashtag.domain.book.dto.BookDto;
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
import hallym.hashtag.global.baseDto.PageRequestDto;
import hallym.hashtag.global.baseDto.PageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        for (int i = 0; i < byRtnos.size(); i++) {
            if(byRtnos.get(i).getRoomReserve().equals(RoomReserve.예약불가)) {
                throw new RuntimeException(byRtnos.get(i).getTime() + " 시간에는 다른 유저가 예약 중이므로 해당 시간에 예약할 수 없습니다.");
            }
        }

        RoomRes roomRes = toEntity(byRno, byUno, byRtnos);
        roomResRepository.save(roomRes);

        for (int i = 0; i < byRtnos.size(); i++) {
            UseTime useTime = byRtnos.get(i);
            useTime.setRoomReserve(RoomReserve.예약불가);
            useTime.setRoomRes(roomRes);
            useTimeRepository.save(useTime);
        }

        return toDto(roomRes);
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
        return toDto(roomRes);
    }

    @Override
    public PageResponseDto<RoomResResponseDto> findAllUno(Long uno, PageRequestDto pageRequestDto) {
        Pageable pageable = PageRequest.of(pageRequestDto.getPage() <=0? 0:
                        pageRequestDto.getPage()-1,
                pageRequestDto.getSize());

        Page<RoomRes> roomRes = roomResRepository.findByUser_Uno(uno, pageable);

        List<RoomResResponseDto> dtoList = roomRes.getContent()
                .stream().map(this::toDto).collect(Collectors.toList());

        return PageResponseDto.<RoomResResponseDto>withAll()
                .pageRequestDto(pageRequestDto)
                .dtoList(dtoList)
                .total((int)roomRes.getTotalElements())
                .build();
    }

    private RoomRes toEntity(Optional<Room> byRno, Optional<User> byUno, List<UseTime> byRtnos) {
        return RoomRes.builder()
                .room(byRno.get())
                .user(byUno.get())
                .useTimes(byRtnos)
                .build();
    }

    private RoomResResponseDto toDto(RoomRes roomRes) {
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
