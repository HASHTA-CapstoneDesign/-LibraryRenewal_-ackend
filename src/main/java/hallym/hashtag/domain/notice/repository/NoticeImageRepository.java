package hallym.hashtag.domain.notice.repository;

import hallym.hashtag.domain.notice.entity.NoticeImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeImageRepository extends JpaRepository<NoticeImage, Long> {
}
