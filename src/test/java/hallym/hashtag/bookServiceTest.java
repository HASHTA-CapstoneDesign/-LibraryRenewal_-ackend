package hallym.hashtag;

import hallym.hashtag.domain.book.service.BookService;
import hallym.hashtag.domain.book.service.BookServicelmpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class bookServiceTest {
    @Autowired
    BookService bookService;
    @Autowired
    BookServicelmpl bookServicelmpl;

    @Test
    public void testFindByRecommend() throws IOException {
        System.out.println(bookService.findAllByRecommend());
    }

    @Test
    public void testFindAllByRecommend() throws IOException {
        System.out.println(bookService.findAllByRecommend());
    }
}
