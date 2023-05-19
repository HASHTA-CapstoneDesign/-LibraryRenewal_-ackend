package hallym.hashtag.domain.book.repository;

import hallym.hashtag.domain.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b order by b.regDate desc ")
    List<Book> findAllRegDateDesc();

    @Query("select b from Book b order by b.loanCount desc")
    List<Book> findAllByLoanCount();

    Page<Book> findAll(Pageable pageable);

    @Query("select b from Book b where b.isbn=:isbn1")
    Optional<Book> findByIsbn(@Param("isbn1") String isbn1);
}
