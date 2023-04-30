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
        Long sno = 1L;
        Long ano = 1L;

        bookResService.reserve(ano, sno);
    }

    @Test
    public void testCancel() {
        Long brno = 1L;
        bookResService.cancel(brno);
    }

    @Test
    public void testFindByStudent() {
        Long sno = 1L;
        bookResService.findByStudent(sno);
    }

    @Test
    public void testFindByAll() {
        bookResService.findByAll();
    }
}
