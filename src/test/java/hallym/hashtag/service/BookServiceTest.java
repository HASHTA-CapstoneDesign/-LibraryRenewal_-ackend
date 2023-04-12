package hallym.hashtag.service;

import hallym.hashtag.domain.book.dto.BookDto;
import hallym.hashtag.domain.book.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    BookService bookService;
    @Test
    public void bookCreate() {
        BookDto bookDto = BookDto.builder()
                .tag(100L)
                .title("제목")
                .author("김미진")
                .isbn("1111")
                .pudDate("2001년 07월 21일")
                .bookPage(123L)
                .build();
        bookService.create(bookDto);
        System.out.println("----------생성 완료!----------");
    }

    @Test
    public void bookFindAll() {
        bookService.findAll();
        System.out.println("----------조회 완료!----------");
    }

    @Test
    public void bookFindByOne() {
        Long bno = 1L;
        bookService.findByOne(bno);
        System.out.println("----------출력 완료----------");
    }

    @Test
    public void bookUpdate() {
        Long bno = 1L;
        BookDto bookDto = BookDto.builder()
                .title("수정")
                .author("김선아")
                .isbn("1111")
                .pudDate("2001년 05월 10일")
                .bookPage(100L)
                .build();

        bookService.update(bno, bookDto);
        System.out.println("----------수정 완료!----------");
    }

    @Test
    public void bookDelete() {
        Long bno = 1L;
        bookService.delete(bno);
        System.out.println("----------삭제 완료!----------");
    }
}
