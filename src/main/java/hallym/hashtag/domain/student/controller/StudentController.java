package hallym.hashtag.domain.student.controller;

import hallym.hashtag.domain.student.dto.StudentRequestDto;
import hallym.hashtag.domain.student.dto.StudentResponseDto;
import hallym.hashtag.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("user/student")
public class StudentController {
    private final StudentService studentService;
    @PostMapping
    public StudentResponseDto studentCreate(@RequestBody StudentRequestDto studentRequestDto) {
        return studentService.create(studentRequestDto);
    }
    @GetMapping("list")
    public List<StudentResponseDto> studentFindAll() {
        return studentService.findAllList();
    }

    @GetMapping("{sno}")
    public StudentResponseDto studentFindByOne(@PathVariable("sno") Long sno) {
        return studentService.findByOne(sno);
    }

    @PutMapping("{sno}")
    public StudentResponseDto studentUpdate(@PathVariable(name = "sno") Long sno,
                                            @RequestBody StudentRequestDto studentRequestDto){
        return studentService.update(sno, studentRequestDto);
    }
}
