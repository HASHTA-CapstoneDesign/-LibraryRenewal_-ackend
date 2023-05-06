package hallym.hashtag.service;

import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
import hallym.hashtag.domain.roomRes.entity.UseTime;
import hallym.hashtag.domain.roomRes.service.RoomResService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RoomResServiceTest {
    @Autowired
    RoomResService roomResService;

    @Test
    public void testReserve() {
        Long sno = 1L;
        Long rno = 1L;

        List<UseTime> useTimes = new ArrayList<>();
        useTimes.add(UseTime.builder().time("09:00-10:00").build());
        useTimes.add(UseTime.builder().time("10:00-11:00").build());

        RoomResRequestDto roomResRequestDto = RoomResRequestDto.builder()
                .useDate("2023-05-10")
                .useTimes(useTimes)
                .build();

        roomResService.reserve(sno, rno, roomResRequestDto);
    }
}
