package hallym.hashtag.domain.bookRes.service;

import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.abook.repostory.ABookRepository;
import hallym.hashtag.domain.bookRes.dto.BookResRequestDto;
import hallym.hashtag.domain.bookRes.dto.BookResResponseDto;
import hallym.hashtag.domain.bookRes.entity.BookRes;
import hallym.hashtag.domain.bookRes.repository.BookResRepository;
import hallym.hashtag.domain.student.entity.Student;
import hallym.hashtag.domain.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class BookResServicelmpl implements BookResService {
    private final BookResRepository bookResRepository;
    private final ABookRepository aBookRepository;
    private final StudentRepository studentRepository;

    @Override
    public BookResResponseDto reserve(Long ano, Long sno) {
        Optional<ABook> byAno = aBookRepository.findById(ano);
        if(byAno.isEmpty()) return null;
        Optional<Student> bySno = studentRepository.findById(sno);
        if(bySno.isEmpty()) return null;
        BookRes bookRes = new BookRes();
        bookRes.setABook(byAno.get());
        bookRes.setStudent(bySno.get());
        ABook aBook = byAno.get();
        aBook.setReserveType(Boolean.TRUE);
        aBookRepository.save(aBook);
        bookResRepository.save(bookRes);
        return toDto(bookRes);
    }

    @Override
    public String cancel(Long brno) {
        Optional<BookRes> byBrno = bookResRepository.findById(brno);
        if (byBrno.isEmpty()) return "아이디가 존재하지 않습니다.";
        BookRes bookRes = byBrno.get();
        ABook aBook = bookRes.getABook();
        aBook.setReserveType(Boolean.FALSE);
        aBookRepository.save(aBook);
        bookResRepository.delete(bookRes);
        return "취소되었습니다.";
    }

    public BookRes toEntity(BookResRequestDto bookResRequestDto) {
        return BookRes.builder()
                .brno(bookResRequestDto.getBrno())
                .creDate(bookResRequestDto.getCreDate())
                .aBook(bookResRequestDto.getABook())
                .student(bookResRequestDto.getStudent())
                .build();
    }

    public BookResResponseDto toDto(BookRes bookRes) {
        return BookResResponseDto.builder()
                .brno(bookRes.getBrno())
                .creDate(bookRes.getCreDate())
                .studentName(bookRes.getStudent().getName())
                .bookName(bookRes.getABook().getBook().getTitle())
                .build();
    }
}
