package hallym.hashtag.domain.notice.repository;

import hallym.hashtag.domain.notice.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Query("select n from Notice n order by n.important desc, n.nno desc")
    Page<Notice> findByAll(Pageable pageable);

    @Query("select n from Notice n where n.title LIKE %:keyword% or n.content LIKE %:keyword% order by n.important desc , n.nno desc ")
    Page<Notice> search(@Param("keyword") String keyword, Pageable pageable);

    @Query("select n from Notice n where n.important=:important order by n.nno desc ")
    List<Notice> findAllByImportant(@Param("important") Boolean important);
}
