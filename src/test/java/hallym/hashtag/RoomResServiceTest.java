package hallym.hashtag;

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
        List<Long> rtnos = new ArrayList<>();
        rtnos.add(1L); rtnos.add(2L);
        RoomResRequestDto roomResRequestDto = RoomResRequestDto.builder()
                .rno(1L).uno(1L).rtnos(rtnos).build();
        roomResService.reserve(roomResRequestDto);
    }
}
