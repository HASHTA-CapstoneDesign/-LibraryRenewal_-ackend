package hallym.hashtag.domain.room.repository;

import hallym.hashtag.domain.room.entity.RoomUseTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomUseTimeRepository extends JpaRepository<RoomUseTime, Long> {
}
