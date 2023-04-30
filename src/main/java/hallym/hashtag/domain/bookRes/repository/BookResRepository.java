package hallym.hashtag.domain.bookRes.repository;

import hallym.hashtag.domain.bookRes.entity.BookRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookResRepository extends JpaRepository<BookRes, Long> {
}
