package hallym.hashtag.domain.abook.service;

import hallym.hashtag.domain.abook.dto.ABookRequestDto;
import hallym.hashtag.domain.abook.dto.ABookResponseDto;
import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.abook.repostory.ABookRepository;
import hallym.hashtag.domain.book.entity.Book;
import hallym.hashtag.domain.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class ABookServicelmpl implements ABookService {
    private final ABookRepository aBookRepository;
    private final BookRepository bookRepository;

    @Override
    public ABookResponseDto create(Long bno, ABookRequestDto aBookRequestDto) {
        Optional<Book> byId = bookRepository.findById(bno);
        if(byId.isEmpty()) return null;
        ABook newABook = toEntity(aBookRequestDto);
        newABook.setBook(byId.get());
        aBookRepository.save(newABook);
        return toDto(newABook);
    }

    @Override
    public List<ABookResponseDto> findAllByBook(Long bno) {
        Optional<Book> byBno = bookRepository.findById(bno);
        if(byBno.isEmpty()) return null;

        List<ABook> aBookList = aBookRepository.findByBook_bno(bno);

        return aBookList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public ABook toEntity(ABookRequestDto aBookRequestDto){
        return ABook.builder()
                .tag(aBookRequestDto.getTag())
                .build();
    }

    public ABookResponseDto toDto(ABook aBook){
        return ABookResponseDto.builder()
                .abno(aBook.getAbno())
                .loanType(aBook.isLoanType())
                .tag(aBook.getTag())
                .reserveType(aBook.isReserveType())
                .build();
    }
}
