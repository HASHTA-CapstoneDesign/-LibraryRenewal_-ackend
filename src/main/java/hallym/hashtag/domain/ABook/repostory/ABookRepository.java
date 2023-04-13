package hallym.hashtag.domain.ABook.repostory;

import hallym.hashtag.domain.ABook.entity.ABook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ABookRepository extends JpaRepository<ABook, Long> {
}
