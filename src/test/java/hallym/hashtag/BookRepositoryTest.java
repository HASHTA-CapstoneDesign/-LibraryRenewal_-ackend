package hallym.hashtag;

import hallym.hashtag.domain.book.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    public void testFindByIsbn() {
        String isbn1 = "9788971220658";
        System.out.println(bookRepository.findByIsbn(isbn1));
    }
}
