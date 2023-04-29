package hallym.hashtag.domain.room.repository;

import hallym.hashtag.domain.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByNameContaining(String name);

    List<Room> findAllByStudyRoom(boolean type);
}
