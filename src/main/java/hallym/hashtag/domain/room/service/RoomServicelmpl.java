package hallym.hashtag.domain.room.service;

import hallym.hashtag.domain.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class RoomServicelmpl implements RoomService{
    private final RoomRepository roomRepository;
}
