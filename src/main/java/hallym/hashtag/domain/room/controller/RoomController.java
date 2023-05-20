package hallym.hashtag.domain.room.controller;

import hallym.hashtag.domain.room.dto.RoomDto;
import hallym.hashtag.domain.room.service.RoomService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/room")
public class RoomController {
    private final RoomService roomService;
}
