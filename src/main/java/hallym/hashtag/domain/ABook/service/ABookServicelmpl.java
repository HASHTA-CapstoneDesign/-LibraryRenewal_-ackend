package hallym.hashtag.domain.ABook.service;

import hallym.hashtag.domain.ABook.dto.ABookRequestDto;
import hallym.hashtag.domain.ABook.dto.ABookResponseDto;
import hallym.hashtag.domain.ABook.entity.ABook;
import hallym.hashtag.domain.ABook.repostory.ABookRepository;
import hallym.hashtag.domain.book.entity.Book;
import hallym.hashtag.domain.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class ABookServicelmpl implements ABookService {
    private final ABookRepository aBookRepository;
    private final BookRepository bookRepository;

    @Override
    public ABookResponseDto create(Long bno, ABookRequestDto aBookRequestDto) {
        Optional<Book> byID = bookRepository.findById(bno);
        aBookRequestDto.setBook(byID.get());
        ABook newABook = toEntity(aBookRequestDto);
        aBookRepository.save(newABook);
        return toDto(newABook);
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
