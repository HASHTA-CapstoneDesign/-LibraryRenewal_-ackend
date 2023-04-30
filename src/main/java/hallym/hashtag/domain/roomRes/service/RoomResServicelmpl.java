package hallym.hashtag.domain.roomRes.service;

import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.room.repository.RoomRepository;
import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
import hallym.hashtag.domain.roomRes.dto.RoomResResponseDto;
import hallym.hashtag.domain.roomRes.entity.RoomRes;
import hallym.hashtag.domain.roomRes.repostory.RoomResRepository;
import hallym.hashtag.domain.student.entity.Student;
import hallym.hashtag.domain.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Collections;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class RoomResServicelmpl implements RoomResService{
    private final RoomResRepository roomResRepository;
    private final RoomRepository roomRepository;
    private final StudentRepository studentRepository;

    @Override
    public RoomResResponseDto reserve(Long sno, Long rno, RoomResRequestDto roomResRequestDto) {
        Optional<Student> bySno = studentRepository.findById(sno);
        if(bySno.isEmpty()) return null;
        Optional<Room> byRno = roomRepository.findById(rno);
        if (byRno.isEmpty()) return null;
        RoomRes roomRes = toEntity(roomResRequestDto);
        Room room = byRno.get();
        roomRes.setRoom(room);
        room.setReserve(Boolean.TRUE);
        roomRes.setStudent(bySno.get());
        roomRepository.save(room);
        roomResRepository.save(roomRes);
        return toDto(roomRes);
    }


    public RoomRes toEntity(RoomResRequestDto roomResRequestDto) {
        return RoomRes.builder()
                .rrno(roomResRequestDto.getRrno())
                .creDate(roomResRequestDto.getCreDate())
                .room(roomResRequestDto.getRoom())
                .useTimes(roomResRequestDto.getUseTimes())
                .useDate(roomResRequestDto.getUseDate())
                .student(roomResRequestDto.getStudent())
                .build();
    }

    public RoomResResponseDto toDto(RoomRes roomRes) {
        return RoomResResponseDto.builder()
                .rrno(roomRes.getRrno())
                .roomName(roomRes.getRoom().getName())
                .studentName(roomRes.getStudent().getName())
                .useDate(roomRes.getUseDate())
                .creDate(roomRes.getCreDate())
                .useTimes(Collections.singletonList(roomRes.getUseTimes().toString()))
                .build();
    }


}
