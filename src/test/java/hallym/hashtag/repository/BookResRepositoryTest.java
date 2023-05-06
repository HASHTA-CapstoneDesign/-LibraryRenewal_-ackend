package hallym.hashtag.repository;

import hallym.hashtag.domain.bookRes.repository.BookResRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookResRepositoryTest {
    @Autowired
    BookResRepository bookResRepository;

    @Test
    public void testFindByUser_uno() {
        Long uno = 1L;
        bookResRepository.findByUser_uno(uno);
    }
}
