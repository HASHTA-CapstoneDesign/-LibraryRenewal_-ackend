package hallym.hashtag.repository;

import hallym.hashtag.domain.ABook.entity.ABook;
import hallym.hashtag.domain.ABook.repostory.ABookRepository;
import hallym.hashtag.domain.book.entity.Book;
import hallym.hashtag.domain.book.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ABookRepositoryTest {
    @Autowired
    ABookRepository aBookRepository;
    @Autowired
    BookRepository bookRepository;

    @Test
    public void testSave() {
        Optional<Book> byBno = bookRepository.findById(1L);
        ABook aBook = ABook.builder()
                .tag("gg")
                .book(byBno.get())
                .build();
        aBookRepository.save(aBook);
    }

    @Test
    public void testSetLoanType() {
        Optional<ABook> byAbno = aBookRepository.findById(2L);
        ABook aBook = byAbno.get();
        aBook.setLoanType(Boolean.FALSE);
        aBookRepository.save(aBook);
    }
}
