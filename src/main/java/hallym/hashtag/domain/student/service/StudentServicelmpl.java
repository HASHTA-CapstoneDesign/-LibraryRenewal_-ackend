package hallym.hashtag.domain.student.service;

import hallym.hashtag.domain.student.dto.StudentRequestDto;
import hallym.hashtag.domain.student.dto.StudentResponseDto;
import hallym.hashtag.domain.student.entity.Student;
import hallym.hashtag.domain.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class StudentServicelmpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public StudentResponseDto create(StudentRequestDto studentRequestDto) {
        Student newStudent = toEntity(studentRequestDto);
        studentRepository.save(newStudent);
        return toDto(newStudent);
    }

    @Override
    public List<StudentResponseDto> findAllList() {
        List<Student> studentList = studentRepository.findAll();
        return studentList.stream().map(s -> toDto(s)).collect(Collectors.toList());
    }

    @Override
    public StudentResponseDto findByOne(Long sno) {
        Optional<Student> bySno = studentRepository.findById(sno);
        if(bySno.isEmpty())
            return null;
        Student student = bySno.get();
        return toDto(student);
    }

    public Student toEntity(StudentRequestDto studentRequestDto){
        return Student.builder()
                .sno(studentRequestDto.getSno())
                .name(studentRequestDto.getName())
                .phone(studentRequestDto.getPhone())
                .cleanup(studentRequestDto.getCleanup())
                .major(studentRequestDto.getMajor())
                .password(studentRequestDto.getPassword())
                .build();
    }

    public StudentResponseDto toDto(Student student) {
        return StudentResponseDto.builder()
                .sno(student.getSno())
                .name(student.getName())
                .cleanup(student.getCleanup())
                .build();
    }

}
