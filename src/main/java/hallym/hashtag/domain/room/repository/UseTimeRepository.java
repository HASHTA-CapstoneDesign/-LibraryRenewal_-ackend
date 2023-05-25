package hallym.hashtag.domain.room.repository;

import hallym.hashtag.domain.room.entity.UseTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseTimeRepository extends JpaRepository<UseTime, Long> {
}
