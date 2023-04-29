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
                .name("스터디룸")
                .content("공부하는 곳이다.")
                .floor(Floor.지상4층)
                .build();
        roomService.create(roomDto);
    }

    @Test
    public void testSearch() {
        String name = "스터디";
        roomService.search(name);
    }

    @Test
    public void testSearchFail() {
        String name = "방";
        roomService.search(name);
    }
}
