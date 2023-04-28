package hallym.hashtag.domain.roomRes.service;

import hallym.hashtag.domain.roomRes.dto.RoomResResponseDto;
import hallym.hashtag.domain.roomRes.entity.RoomRes;
import hallym.hashtag.domain.roomRes.entity.Time;
import hallym.hashtag.domain.roomRes.repository.RoomResRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class RoomResServicelmpl implements RoomResService {
    private final RoomResRepository roomResRepository;

    @Override
    public RoomResResponseDto reserve(Long sno, String roomName, Time time) {

        RoomRes roomRes = RoomRes.builder().build();
        return null;
    }

    public RoomResResponseDto toDto(RoomRes roomRes) {
        return RoomResResponseDto.builder()
                .rno(roomRes.getRno())
                .creDate(roomRes.getCreDate())
                .useDate(roomRes.getUseDate())
                .reserve(roomRes.isReserve())
                .roomName(roomRes.getRoomName())
                .time(roomRes.getTime())
                .build();
    }
}
