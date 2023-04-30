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
        Long rno = 2L;

        List<UseTime> useTimeList = new ArrayList<>();
        useTimeList.add(UseTime.time2); useTimeList.add(UseTime.time3);

        RoomResRequestDto roomResRequestDto = RoomResRequestDto.builder()
                .useDate("2023-05-10")
                .useTimes(useTimeList)
                .build();

        roomResService.reserve(sno, rno, roomResRequestDto);
    }
}
