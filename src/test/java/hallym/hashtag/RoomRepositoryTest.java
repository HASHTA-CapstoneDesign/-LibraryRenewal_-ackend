package hallym.hashtag;

import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.room.entity.RoomUseTime;
import hallym.hashtag.domain.room.repository.RoomRepository;
import hallym.hashtag.domain.room.repository.RoomUseTimeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootTest
public class RoomRepositoryTest {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    RoomUseTimeRepository roomUseTimeRepository;

    @Test
    public void testSave() {
        Room room = Room.builder().floor(Room.Floor.floor1).name("17212호실").useData("20230510").build();
        roomRepository.save(room);

        List<RoomUseTime> roomUseTimes = new ArrayList<>() {
            {
                add(roomUseTimeRepository.save(RoomUseTime.builder().time("09:00-10:00").reserve(RoomUseTime.Reserve.예약가능).room(room).build()));
                add(roomUseTimeRepository.save(RoomUseTime.builder().time("10:00-11:00").reserve(RoomUseTime.Reserve.예약가능).room(room).build()));
            }
        };

        Optional<Room> room1 = roomRepository.findById(1L);
        Room room2 = room1.get();
        room2.setRoomUseTimes(roomUseTimes);
        roomRepository.save(room2);
    }
}
