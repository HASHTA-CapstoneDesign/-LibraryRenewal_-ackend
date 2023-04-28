package hallym.hashtag.domain.roomRes.service;

import hallym.hashtag.domain.roomRes.repository.RoomResRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class RoomResServicelmpl implements RoomResService {
    private final RoomResRepository roomResRepository;
}
