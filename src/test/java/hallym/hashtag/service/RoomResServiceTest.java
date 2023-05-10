package hallym.hashtag.service;

import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
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
        Long uno = 1L;
        Long rno = 1L;

        List<String> useTimes = new ArrayList<>();
        useTimes.add("09:00-10:00");

        RoomResRequestDto roomResRequestDto = RoomResRequestDto.builder()
                .useData("2023-05-10")
                .useTimes(useTimes)
                .build();

        roomResService.reserve(uno, rno, roomResRequestDto);
    }
}
