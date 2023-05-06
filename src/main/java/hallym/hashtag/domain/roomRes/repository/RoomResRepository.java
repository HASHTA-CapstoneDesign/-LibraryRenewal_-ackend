package hallym.hashtag.domain.roomRes.repository;

import hallym.hashtag.domain.roomRes.entity.RoomRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomResRepository extends JpaRepository<RoomRes, Long> {
}
