package hallym.hashtag.domain.roomRes.controller;

import hallym.hashtag.domain.roomRes.service.RoomResService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("reserve/room")
public class RoomResController {
    private final RoomResService roomResService;
}
