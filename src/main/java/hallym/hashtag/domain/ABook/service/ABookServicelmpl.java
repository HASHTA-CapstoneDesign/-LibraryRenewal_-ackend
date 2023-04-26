package hallym.hashtag.domain.ABook.service;

import hallym.hashtag.domain.ABook.dto.ABookRequestDto;
import hallym.hashtag.domain.ABook.dto.ABookResponseDto;
import hallym.hashtag.domain.ABook.entity.ABook;
import hallym.hashtag.domain.ABook.repostory.ABookRepository;
import hallym.hashtag.domain.book.entity.Book;
import hallym.hashtag.domain.book.repository.BookRepository;
import hallym.hashtag.domain.loan.entity.Loan;
import hallym.hashtag.domain.loan.repostory.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class ABookServicelmpl implements ABookService {
    private final ABookRepository aBookRepository;
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;

    @Override
    public ABookResponseDto create(Long bno, ABookRequestDto aBookRequestDto) {
        Optional<Book> byId = bookRepository.findById(bno);
        aBookRequestDto.setBook(byId.get());
        ABook newABook = toEntity(aBookRequestDto);
        aBookRepository.save(newABook);
        return toDto(newABook);
    }

    @Override
    public ABookResponseDto checkOut(Long bno) {
        Optional<ABook> byAbno = aBookRepository.findById(bno);
        if(byAbno.isEmpty()) return null;

        ABook checkOutAbook = byAbno.get();

        List<Loan> loanList = loanRepository.findByABook_abno(bno);

        if(loanList.size() > 0) {
            checkOutAbook.setLoanType(Boolean.FALSE);
            aBookRepository.save(checkOutAbook);
        }

        return toDto(checkOutAbook);
    }

    public ABook toEntity(ABookRequestDto aBookRequestDto){
        return ABook.builder()
                .abno(aBookRequestDto.getAbno())
                .tag(aBookRequestDto.getTag())
                .book(aBookRequestDto.getBook()).build();
    }

    public ABookResponseDto toDto(ABook aBook){
        return ABookResponseDto.builder()
                .abno(aBook.getAbno())
                .tag(aBook.getTag()).build();
    }
}
