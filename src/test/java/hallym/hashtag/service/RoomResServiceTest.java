package hallym.hashtag.service;

import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
import hallym.hashtag.domain.roomRes.entity.Time;
import hallym.hashtag.domain.roomRes.service.RoomResService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoomResServiceTest {
    @Autowired
    RoomResService roomResService;

    @Test
    public void testReserve() {
        Long sno = 1L;
        Long rno = 1L;
        RoomResRequestDto roomResRequestDto = RoomResRequestDto.builder()
                .useDate("00000")
                .time(Time.오전11시)
                .build();
        roomResService.reserve(sno, rno, roomResRequestDto);
    }
}
