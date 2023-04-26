package hallym.hashtag.domain.abook.repostory;

import hallym.hashtag.domain.abook.entity.ABook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ABookRepository extends JpaRepository<ABook, Long> {

    @Query("select a from ABook a where a.book.bno=:bno")
    List<ABook> findByBook_bno(@Param("bno") Long bno);
}
