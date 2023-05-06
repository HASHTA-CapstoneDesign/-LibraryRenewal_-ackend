package hallym.hashtag.domain.bookRes.repository;

import hallym.hashtag.domain.bookRes.entity.BookRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookResRepository extends JpaRepository<BookRes, Long> {
    @Query("select b from BookRes b where b.user.uno=:uno order by b.brno desc ")
    List<BookRes> findByUser_uno(@Param("uno") Long uno);
}
