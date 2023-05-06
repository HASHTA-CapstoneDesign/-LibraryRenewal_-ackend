package hallym.hashtag.domain.loan.service;

import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.abook.repostory.ABookRepository;
import hallym.hashtag.domain.book.entity.Book;
import hallym.hashtag.domain.book.repository.BookRepository;
import hallym.hashtag.domain.loan.dto.LoanResponseDto;
import hallym.hashtag.domain.loan.entity.Loan;
import hallym.hashtag.domain.loan.repostory.LoanRepository;
import hallym.hashtag.domain.user.entity.User;
import hallym.hashtag.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class LoanServicelmpl implements LoanService {
    private final ABookRepository aBookRepository;
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    @Override
    public LoanResponseDto create(Long uno, Long abno) { // 대출
        Optional<ABook> byAbno = aBookRepository.findById(abno);
        if(byAbno.isEmpty()) return null;

        Optional<User> byUno = userRepository.findById(uno);
        if(byUno.isEmpty()) return null;

        Loan loan = Loan.builder().retDate(LocalDate.now().plusDays(20))
                .user(byUno.get()).build(); // 반납 날짜 생성
        loan.setABook(byAbno.get());

        ABook aBook = byAbno.get();
        aBook.setLoanType(Boolean.TRUE); // 대출 여부 불가능 상태로 저장

        Book book = byAbno.get().getBook();
        book.updateLoanCounting(); // 대출 횟수 카운팅

        bookRepository.save(book);
        aBookRepository.save(aBook);
        loanRepository.save(loan);

        return toDto(loan);
    }

    @Override
    public LoanResponseDto extension(Long lno) { // 연장
        Optional<Loan> byLno = loanRepository.findById(lno);
        if(byLno.isEmpty()) return null;

        Loan updateLoan = byLno.get();
        updateLoan.setRetDate(byLno.get().getRetDate().plusDays(20)); // 연장한 날짜로 수정하여 저장

        loanRepository.save(updateLoan);
        return toDto(updateLoan);
    }

    @Override
    public LoanResponseDto returnBook(Long lno) { // 반납
        Optional<Loan> byLno = loanRepository.findById(lno);
        if(byLno.isEmpty()) return null;

        Loan updateLoan = byLno.get();
        updateLoan.setNowRetDate(); // 반납한 날짜 저장

        if(true == updateLoan.getRetDate().isAfter(updateLoan.getNowRetDate())) {
            updateLoan.setReturnType("정상반납");
        } else {
            updateLoan.setReturnType("연체반납");
        }

        Optional<ABook> byAbno = aBookRepository.findById(byLno.get().getABook().getAbno());
        if(byAbno.isEmpty()) return null;
        ABook aBook = byAbno.get();
        aBook.setLoanType(Boolean.FALSE); // 대출 여부 가능상태로 변환

        aBookRepository.save(aBook);
        loanRepository.save(updateLoan);
        return toDto(updateLoan);
    }

    @Override
    public List<LoanResponseDto> findAllByUser(Long uno) { //학생별로 자신이 대출한 책 내역 조회
        Optional<User> byUne = userRepository.findById(uno);
        if(byUne.isEmpty()) return null;

        List<Loan> loanList = loanRepository.findByUser_uno(uno); // 생성된 순으로 조회
        return loanList.stream().map(this::toDto).collect(Collectors.toList());
    }


    private LoanResponseDto toDto(Loan loan){
        return LoanResponseDto.builder()
                .lno(loan.getLno())
                .creDate(loan.getCreDate())
                .retDate(loan.getRetDate())
                .nowRetDate(loan.getNowRetDate())
                .bookName(loan.getABook().getBook().getTitle())
                .author(loan.getABook().getBook().getAuthor())
                .returnType(loan.getReturnType())
                .build();
    }

}
