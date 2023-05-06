package hallym.hashtag.domain.bookRes.service;

import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.abook.repostory.ABookRepository;
import hallym.hashtag.domain.bookRes.dto.BookResRequestDto;
import hallym.hashtag.domain.bookRes.dto.BookResResponseDto;
import hallym.hashtag.domain.bookRes.entity.BookRes;
import hallym.hashtag.domain.bookRes.repository.BookResRepository;
import hallym.hashtag.domain.student.entity.Student;
import hallym.hashtag.domain.student.repository.StudentRepository;
import hallym.hashtag.domain.user.entity.User;
import hallym.hashtag.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class BookResServicelmpl implements BookResService {
    private final BookResRepository bookResRepository;
    private final ABookRepository aBookRepository;
    private final UserRepository userRepository;

    @Override
    public BookResResponseDto reserve(Long ano, Long uno) { // 예약
        Optional<ABook> byAno = aBookRepository.findById(ano);
        if(byAno.isEmpty()) return null;
        Optional<User> byUno = userRepository.findById(uno);
        if(byUno.isEmpty()) return null;

        BookRes bookRes = BookRes.builder().user(byUno.get()).build();
        bookRes.setABook(byAno.get());

        ABook aBook = byAno.get();
        aBook.setReserveType(Boolean.TRUE); // 예약 중으로 저장

        aBookRepository.save(aBook);
        bookResRepository.save(bookRes);
        return toDto(bookRes);
    }

    @Override
    public String cancel(Long brno) { // 예약 취소
        Optional<BookRes> byBrno = bookResRepository.findById(brno);
        if (byBrno.isEmpty()) return "아이디가 존재하지 않습니다.";

        BookRes bookRes = byBrno.get();
        bookRes.setReserveType();

        ABook aBook = bookRes.getABook();
        aBook.setReserveType(Boolean.FALSE); // 예약 취소로 저장

        aBookRepository.save(aBook);
        bookResRepository.save(bookRes);
        return "취소되었습니다.";
    }

    @Override
    public List<BookResResponseDto> findByUser(Long uno) {  // 사용자별로 책 예약 현황 조회
        List<BookRes> bookResList = bookResRepository.findByUser_uno(uno);
        return bookResList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public BookResResponseDto toDto(BookRes bookRes) {
        return BookResResponseDto.builder()
                .brno(bookRes.getBrno())
                .creDate(bookRes.getCreDate())
                .bookName(bookRes.getABook().getBook().getTitle())
                .build();
    }
}
