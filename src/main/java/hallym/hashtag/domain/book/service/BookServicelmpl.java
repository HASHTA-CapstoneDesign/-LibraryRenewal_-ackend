package hallym.hashtag.domain.book.service;

import hallym.hashtag.domain.book.dto.BookDto;
import hallym.hashtag.domain.book.entity.Book;
import hallym.hashtag.domain.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class BookServicelmpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public BookDto create(BookDto bookDto) {
        Book newBook = toEntity(bookDto);
        bookRepository.save(newBook);
        return toDto(newBook);
    }

    public Book toEntity(BookDto bookDto) {
        return Book.builder()
                .bno(bookDto.getBno())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .isbn(bookDto.getIsbn())
                .pudDate(bookDto.getPudDate())
                .bookPage(bookDto.getBookPage())
                .build();
    }

    public BookDto toDto(Book book) {
        return BookDto.builder()
                .bno(book.getBno())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .pudDate(book.getPudDate())
                .bookPage(book.getBookPage())
                .build();
    }
}
