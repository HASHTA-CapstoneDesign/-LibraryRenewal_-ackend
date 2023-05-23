package hallym.hashtag.domain.room.repository;

import hallym.hashtag.domain.room.entity.Floor;
import hallym.hashtag.domain.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("select r from Room r where r.floor=:floor and r.useData=:useData")
    List<Room> findByFloorAndAndUseData(@Param("floor") Floor floor,@Param("useData") String useData);
}
