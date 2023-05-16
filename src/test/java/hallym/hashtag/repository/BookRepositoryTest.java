package hallym.hashtag.repository;

import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.abook.repostory.ABookRepository;
import hallym.hashtag.domain.book.entity.Book;
import hallym.hashtag.domain.book.repository.BookRepository;
import hallym.hashtag.domain.loan.repostory.LoanRepository;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ABookRepository aBookRepository;
    @Autowired
    LoanRepository loanRepository;

    @Test
    public void testSave() {
        Book book = Book.builder()
                .tag(100L)
                .title("제목")
                .author("김미진")
                .isbn("1111")
                .pudDate("2001년 07월 21일")
                .build();
        bookRepository.save(book);

        System.out.println("----------저장 완료!----------");
    }

    @Test
    public void testFindAllRegDateDesc() {
        bookRepository.findAllRegDateDesc();
    }

    @Test
    public void testFindAllByLoanCount() {
        bookRepository.findAllByLoanCount();
    }

    @Test
    public void testSetBook() {
        Book book = Book.builder()
                .tag(100L)
                .title("제목")
                .author("김미진")
                .isbn("1111")
                .pudDate("2001년 07월 21일")
                .build();
        bookRepository.save(book);

        ABook aBook1 = ABook.builder()
                .tag("gg")
                .build();

        ABook aBook2 = ABook.builder()
                .tag("gg")
                .build();

        aBook1.setBook(book);
        aBook2.setBook(book);
        aBookRepository.save(aBook1);
        aBookRepository.save(aBook2);

        assertThat(book.getABooks().size()).isEqualTo(2);
    }
}
