package hallym.hashtag.domain.book.service;

import hallym.hashtag.domain.book.dto.BookDto;
import hallym.hashtag.domain.book.entity.Book;
import hallym.hashtag.domain.book.repository.BookRepository;
import hallym.hashtag.global.baseDto.PageRequestDto;
import hallym.hashtag.global.baseDto.PageResponseDto;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class BookServicelmpl implements BookService {
    private final BookRepository bookRepository;

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
    public List<BookDto> findAllRestDateDesc() {
        List<Book> bookList = bookRepository.findAllRegDateDesc();
        return bookList.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findAllByLoanCount() {
        List<Book> bookList = bookRepository.findAllByLoanCount();
        return bookList.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findAllByRecommend() throws IOException {
        List<Book> bookList = bookRepository.findAllByLoanCount();
        String isbn = bookList.get(0).getIsbn();
        String result = Jsoup.connect("http://127.0.0.1:5000/recommend/?input="+isbn).get().text();
        List<String> resultList = List.of(result.split(" "));
        List<Book> books = new ArrayList<>();
        for (int i = 1; i < 6; i=i+2) {
            Optional<Book> byIsbn = bookRepository.findByIsbn(resultList.get(i));
            if(byIsbn.isEmpty()) break;
            books.add(byIsbn.get());
        }
        return books.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public PageResponseDto<BookDto> search(String keyword, PageRequestDto pageRequestDto) {
        Pageable pageable = PageRequest.of(pageRequestDto.getPage() <=0? 0:
                        pageRequestDto.getPage()-1,
                pageRequestDto.getSize());

        Page<Book> bookList = bookRepository.search(keyword, pageable);

        List<BookDto> bookDtos = bookList.getContent()
                .stream().map(this::toDto).collect(Collectors.toList());


        return PageResponseDto.<BookDto>withAll()
                .pageRequestDto(pageRequestDto)
                .dtoList(bookDtos)
                .total((int)bookList.getTotalElements())
                .build();
    }

//    Jsoup.connect("http://34.64.172.201:5000/recommend/?input="+input).get().text();

    public BookDto toDto(Book book) {
        return BookDto.builder()
                .bno(book.getBno())
                .tag(book.getTag())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .pudDate(book.getPudDate())
                .image(book.getImage())
                .pud(book.getPud())
                .build();
    }
}
