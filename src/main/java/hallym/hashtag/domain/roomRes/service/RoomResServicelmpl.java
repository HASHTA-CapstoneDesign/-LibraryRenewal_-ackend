package hallym.hashtag.domain.roomRes.service;

import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.room.repository.RoomRepository;
import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
import hallym.hashtag.domain.roomRes.dto.RoomResResponseDto;
import hallym.hashtag.domain.roomRes.entity.RoomRes;
import hallym.hashtag.domain.roomRes.entity.Time;
import hallym.hashtag.domain.roomRes.repository.RoomResRepository;
import hallym.hashtag.domain.student.entity.Student;
import hallym.hashtag.domain.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class RoomResServicelmpl implements RoomResService {
    private final RoomResRepository roomResRepository;
    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;

    @Override
    public RoomResResponseDto reserve(Long sno, Long rno, RoomResRequestDto roomResRequestDto) {
        Optional<Student> bySno = studentRepository.findById(sno);
        if(bySno.isEmpty()) return null;
        Optional<Room> byRno = roomRepository.findById(rno);
        if(byRno.isEmpty()) return null;
        else if(byRno.get().isStudyRoom() == Boolean.FALSE) return null;
        else {
            RoomRes roomRes = toEntity(roomResRequestDto);
            Room room = byRno.get();
            roomRes.setRoom(room);
            roomRes.setStudent(bySno.get());
            roomResRepository.save(roomRes);
            room.setReserve(Boolean.TRUE);
            roomRepository.save(room);
            return toDto(roomRes);
        }
    }

    public RoomRes toEntity(RoomResRequestDto roomResRequestDto) {
        return RoomRes.builder()
                .rrno(roomResRequestDto.getRno())
                .creDate(roomResRequestDto.getCreDate())
                .useDate(roomResRequestDto.getUseDate())
                .time(roomResRequestDto.getTime())
                .room(roomResRequestDto.getRoom())
                .build();
    }

    public RoomResResponseDto toDto(RoomRes roomRes) {
        return RoomResResponseDto.builder()
                .rno(roomRes.getRrno())
                .creDate(roomRes.getCreDate())
                .useDate(roomRes.getUseDate())
                .time(roomRes.getTime())
                .roomName(roomRes.getRoom().getName())
                .build();
    }


}
