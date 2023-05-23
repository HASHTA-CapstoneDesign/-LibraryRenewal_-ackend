package hallym.hashtag.domain.notice.repository;

import hallym.hashtag.domain.notice.entity.NoticeImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeImageRepository extends JpaRepository<NoticeImage, Long> {
    @Query("select n from NoticeImage n where n.notice.nno=:nno")
    List<NoticeImage> findAllByNotice_Nno(@Param("nno") Long nno);
}
