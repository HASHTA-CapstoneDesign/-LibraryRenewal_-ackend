package hallym.hashtag.domain.roomRes.repository;

import hallym.hashtag.domain.roomRes.entity.RoomRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomResRepository extends JpaRepository<RoomRes, Long> {
    @Query("select r from RoomRes r where r.user.uno=:uno order by r.rrno desc ")
    List<RoomRes> FindByUser_uno(@Param("uno") Long uno);
}
