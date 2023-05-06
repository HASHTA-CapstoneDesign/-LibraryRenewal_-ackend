package hallym.hashtag.service;

import hallym.hashtag.domain.bookRes.service.BookResService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookResServiceTest {
    @Autowired
    BookResService bookResService;

    @Test
    public void testReserve() {
        Long uno = 1L;
        Long ano = 1L;

        bookResService.reserve(ano, uno);
    }

    @Test
    public void testCancel() {
        Long brno = 1L;
        bookResService.cancel(brno);
    }

    @Test
    public void testFindByStudent() {
        Long uno = 1L;
        bookResService.findByUser(uno);
    }
}
