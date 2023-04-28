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
//    private final ModelMapper modelMapper;

    @Override
    public StudentResponseDto create(StudentRequestDto studentRequestDto) {
        Student newStudent = toEntity(studentRequestDto);
        studentRepository.save(newStudent);
        return toDto(newStudent);
    }

    @Override
    public List<StudentResponseDto> findAllList() {
        List<Student> studentList = studentRepository.findAll();
        return studentList.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public StudentResponseDto findByOne(Long sno) {
        Optional<Student> bySno = studentRepository.findById(sno);
        if(bySno.isEmpty())
            return null;
        Student student = bySno.get();
        return toDto(student);
    }

    @Override
    public StudentResponseDto update(Long sno, StudentRequestDto studentRequestDto) {
        Optional<Student> bySno = studentRepository.findById(sno);
        if(bySno.isEmpty())
            return null;
        Student student = bySno.get();
        student.updateStudent(toEntity(studentRequestDto));
        studentRepository.save(student);
        return toDto(student);
    }

    @Override
    public StudentResponseDto updatePassword(Long sno, String password) {
        Optional<Student> bySno = studentRepository.findById(sno);
        if(bySno.isEmpty())
            return null;
        Student student = bySno.get();
        student.updatePassword(password);
        studentRepository.save(student);
        return toDto(student);
    }

    @Override
    public String delete(Long sno) {
        Optional<Student> bySno = studentRepository.findById(sno);
        if(bySno.isEmpty())
            return "ID가 없습니다.";
        studentRepository.deleteById(sno);
        return "삭제되었습니다.";
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
//        return modelMapper.map(studentRequestDto, Student.class);
    }

    public StudentResponseDto toDto(Student student) {
        return StudentResponseDto.builder()
                .sno(student.getSno())
                .name(student.getName())
                .cleanup(student.getCleanup())
                .build();
//        return modelMapper.map(student, StudentResponseDto.class);
    }

}
