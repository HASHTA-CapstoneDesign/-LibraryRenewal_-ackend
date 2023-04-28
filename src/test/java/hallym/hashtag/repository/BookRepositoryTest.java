package hallym.hashtag.repository;

import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.abook.repostory.ABookRepository;
import hallym.hashtag.domain.book.entity.Book;
import hallym.hashtag.domain.book.entity.BookType;
import hallym.hashtag.domain.book.repository.BookRepository;
import hallym.hashtag.domain.loan.entity.Loan;
import hallym.hashtag.domain.loan.repostory.LoanRepository;
import hallym.hashtag.domain.student.entity.Student;
import hallym.hashtag.domain.student.repository.StudentRepository;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ABookRepository aBookRepository;
    @Autowired
    StudentRepository studentRepository;
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
                .bookPage(123L)
                .bookType(BookType.철학)
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
}
