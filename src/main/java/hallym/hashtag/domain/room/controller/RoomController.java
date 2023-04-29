package hallym.hashtag.domain.room.controller;

import hallym.hashtag.domain.room.dto.RoomDto;
import hallym.hashtag.domain.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("room")
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    private RoomDto roomCreate(@RequestBody RoomDto roomDto) {
        return roomService.create(roomDto);
    }

    @GetMapping
    public List<RoomDto> roomSearch(@RequestParam(value = "keyword") String keyword) {
        return roomService.search(keyword);
    }
}
