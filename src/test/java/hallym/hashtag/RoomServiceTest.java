package hallym.hashtag;

import hallym.hashtag.domain.room.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoomServiceTest {
    @Autowired
    RoomService roomService;

    @Test
    public void testFindAll() {
        roomService.findAll();
    }
}
