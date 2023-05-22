package hallym.hashtag.domain.roomRes.repository;

import hallym.hashtag.domain.roomRes.entity.RoomRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomResRepository extends JpaRepository<RoomRes, Long> {
    @Query("select r from RoomRes r where r.user.uno=:uno order by r.creDate desc ")
    Page<RoomRes> findByUser_Uno(@Param("uno") Long uno, Pageable pageable);
}
