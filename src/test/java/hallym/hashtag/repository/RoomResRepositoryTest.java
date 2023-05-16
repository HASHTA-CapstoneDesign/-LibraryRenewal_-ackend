package hallym.hashtag.repository;

import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.room.repository.RoomRepository;
import hallym.hashtag.domain.roomRes.entity.RoomRes;
import hallym.hashtag.domain.roomRes.repository.RoomResRepository;
import hallym.hashtag.domain.user.entity.User;
import hallym.hashtag.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class RoomResRepositoryTest {
    @Autowired
    RoomResRepository roomResRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoomRepository roomRepository;

    @Test
    public void testSave() {
        Optional<User> byUno = userRepository.findById(1L);
        Optional<Room> byRno = roomRepository.findById(1L);
        List<String> useTimes = new ArrayList<>();
        useTimes.add("09:00-10:00");
        RoomRes roomRes = RoomRes.builder()
                .useData("2023-10-05")
                .room(byRno.get())
                .user(byUno.get())
                .useTimes(useTimes)
                .build();

        roomResRepository.save(roomRes);
    }
}
