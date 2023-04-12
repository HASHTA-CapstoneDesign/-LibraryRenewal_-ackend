package hallym.hashtag.repository;

import hallym.hashtag.domain.book.entity.Book;
import hallym.hashtag.domain.book.entity.BookType;
import hallym.hashtag.domain.book.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    public void testSave() {
        Book book = Book.builder()
                .tag(100L)
                .title("제목")
                .author("김미진")
                .isbn("1111")
                .pudDate("2001년 07월 21일")
                .bookPage(123L)
                .bookType(BookType.철학)
                .build();
        bookRepository.save(book);

        System.out.println("----------저장 완료!----------");
    }
}
