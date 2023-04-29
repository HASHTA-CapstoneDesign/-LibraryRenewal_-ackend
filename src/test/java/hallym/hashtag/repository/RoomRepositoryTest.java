package hallym.hashtag.repository;

import hallym.hashtag.domain.room.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoomRepositoryTest {
    @Autowired
    RoomRepository roomRepository;

    @Test
    public void testFindByStudyRoom() {
        roomRepository.findAllByStudyRoom(Boolean.TRUE);
    }
}
