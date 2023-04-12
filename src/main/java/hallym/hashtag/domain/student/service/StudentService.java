package hallym.hashtag.domain.student.service;

import hallym.hashtag.domain.student.dto.StudentRequestDto;
import hallym.hashtag.domain.student.dto.StudentResponseDto;

import java.util.List;

public interface StudentService {
    StudentResponseDto create(StudentRequestDto studentRequestDto);

    List<StudentResponseDto> findAllList();

    StudentResponseDto findByOne(Long sno);

    StudentResponseDto update(Long sno, StudentRequestDto studentRequestDto);
}
