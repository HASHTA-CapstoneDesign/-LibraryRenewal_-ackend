package hallym.hashtag.domain.book.service;

import hallym.hashtag.domain.book.dto.BookDto;
import hallym.hashtag.domain.book.entity.Book;
import hallym.hashtag.domain.book.repository.BookRepository;
import hallym.hashtag.global.baseDto.PageRequestDto;
import hallym.hashtag.global.baseDto.PageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public PageResponseDto<BookDto> findAll(PageRequestDto pageRequestDto) {
        Pageable pageable = PageRequest.of(pageRequestDto.getPage() <=0? 0:
                        pageRequestDto.getPage()-1,
                pageRequestDto.getSize());

        Page<Book> bookList = bookRepository.findAll(pageable);

        List<BookDto> dtoList = bookList.getContent()
                .stream().map(this::toDto).collect(Collectors.toList());

        return PageResponseDto.<BookDto>withAll()
                .pageRequestDto(pageRequestDto)
                .dtoList(dtoList)
                .total((int)bookList.getTotalElements())
                .build();
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

    @Override
    public List<BookDto> findAllRestDateDesc() {
        List<Book> bookList = bookRepository.findAllRegDateDesc();
        return bookList.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findAllByLoanCount() {
        List<Book> bookList = bookRepository.findAllByLoanCount();
        return bookList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Book toEntity(BookDto bookDto) {
        return Book.builder()
                .bno(bookDto.getBno())
                .tag(bookDto.getTag())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .isbn(bookDto.getIsbn())
                .pudDate(bookDto.getPudDate())
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
                .build();
    }
}
