package hallym.hashtag.domain.notice.repository;

import hallym.hashtag.domain.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findByTitleContainingOrContentContaining(String title, String Content);
}
