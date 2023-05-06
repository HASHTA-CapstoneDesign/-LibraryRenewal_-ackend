package hallym.hashtag.service;

import hallym.hashtag.domain.room.dto.RoomDto;
import hallym.hashtag.domain.room.entity.Floor;
import hallym.hashtag.domain.room.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoomServiceTest {
    @Autowired
    RoomService roomService;

    @Test
    public void testCreate() {
        RoomDto roomDto = RoomDto.builder()
                .name("시설물")
                .content("이러한 시설물이다.")
                .studyRoom(Boolean.TRUE)
                .floor(Floor.지상4층)
                .build();
        roomService.create(roomDto);
    }
}
