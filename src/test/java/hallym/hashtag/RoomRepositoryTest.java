package hallym.hashtag;

import hallym.hashtag.domain.room.entity.Floor;
import hallym.hashtag.domain.room.entity.RoomReserve;
import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.room.entity.UseTime;
import hallym.hashtag.domain.room.repository.RoomRepository;
import hallym.hashtag.domain.room.repository.UseTimeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoomRepositoryTest {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    UseTimeRepository useTimeRepository;

    @Test
    public void testSave() {
        Room room = Room.builder().floor(Floor.floor1).name("17212호실").useData("20230521").build();
        roomRepository.save(room);
        UseTime useTime1 = UseTime.builder().time("09:00-10:00").roomReserve(RoomReserve.예약가능).room(room).build();
        UseTime useTime2 = UseTime.builder().time("10:00-11:00").roomReserve(RoomReserve.예약가능).room(room).build();
        UseTime useTime3 = UseTime.builder().time("11:00-12:00").roomReserve(RoomReserve.예약가능).room(room).build();
        UseTime useTime4 = UseTime.builder().time("12:00-13:00").roomReserve(RoomReserve.예약가능).room(room).build();
        UseTime useTime5 = UseTime.builder().time("13:00-15:00").roomReserve(RoomReserve.예약가능).room(room).build();
        useTimeRepository.save(useTime1);
        useTimeRepository.save(useTime2);
        useTimeRepository.save(useTime3);
        useTimeRepository.save(useTime4);
        useTimeRepository.save(useTime5);
    }
}
