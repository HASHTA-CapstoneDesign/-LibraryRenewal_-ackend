package hallym.hashtag.domain.book.service;

import hallym.hashtag.domain.book.dto.BookDto;
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
public class BookServicelmpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public BookDto create(BookDto bookDto) {
        Book newBook = toEntity(bookDto);
        bookRepository.save(newBook);
        return toDto(newBook);
    }

    @Override
    public List<BookDto> findAll() {
        List<Book> bookList = bookRepository.findAll();
        return bookList.stream().map(s -> toDto(s)).collect(Collectors.toList());
    }

    @Override
    public BookDto findByOne(Long bno) {
        Optional<Book> byBno = bookRepository.findById(bno);
        if(byBno.isEmpty())
            return null;
        Book book = byBno.get();
        return toDto(book);
    }

    @Override
    public BookDto update(Long bno, BookDto bookDto) {
        Optional<Book> byBno = bookRepository.findById(bno);
        if(byBno.isEmpty())
            return null;
        Book book = byBno.get();
        book.updateBook(toEntity(bookDto));
        bookRepository.save(book);
        return toDto(book);
    }

    @Override
    public String delete(Long bno) {
        Optional<Book> byBno = bookRepository.findById(bno);
        if(byBno.isEmpty())
            return "ID가 없습니다.";
        Book book = byBno.get();
        bookRepository.delete(book);
        return "삭제되었습니다.";
    }

    public Book toEntity(BookDto bookDto) {
        return Book.builder()
                .bno(bookDto.getBno())
                .tag(bookDto.getTag())
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
                .tag(book.getTag())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .pudDate(book.getPudDate())
                .bookPage(book.getBookPage())
                .build();
    }
}
