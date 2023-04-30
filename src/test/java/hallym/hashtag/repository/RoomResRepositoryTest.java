package hallym.hashtag.repository;

import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.abook.repostory.ABookRepository;
import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.room.repository.RoomRepository;
import hallym.hashtag.domain.roomRes.entity.RoomRes;
import hallym.hashtag.domain.roomRes.entity.UseTime;
import hallym.hashtag.domain.roomRes.repostory.RoomResRepository;
import hallym.hashtag.domain.student.entity.Student;
import hallym.hashtag.domain.student.repository.StudentRepository;
import net.bytebuddy.dynamic.DynamicType;
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
    StudentRepository studentRepository;
    @Autowired
    RoomRepository roomRepository;

    @Test
    public void testSave() {
        Optional<Student> bySno = studentRepository.findById(1L);
        Optional<Room> byRno = roomRepository.findById(1L);

        List<UseTime> useTimeList = new ArrayList<>();
        useTimeList.add(UseTime.time2); useTimeList.add(UseTime.time3);

        RoomRes roomRes = RoomRes.builder()
                .useDate("2023-05-10")
                .room(byRno.get())
                .student(bySno.get())
                .useTimes(useTimeList).build();

        roomResRepository.save(roomRes);

    }
}
