package hallym.hashtag.domain.book.repository;

import hallym.hashtag.domain.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
