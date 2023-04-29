package hallym.hashtag.domain.room.controller;

import hallym.hashtag.domain.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("room")
public class RoomController {
    private final RoomService roomService;
}
