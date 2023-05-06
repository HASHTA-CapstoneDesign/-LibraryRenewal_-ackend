package hallym.hashtag.domain.roomRes.repository;

import hallym.hashtag.domain.roomRes.entity.UseTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UseTimeRepository extends JpaRepository<UseTime, Long> {
}
