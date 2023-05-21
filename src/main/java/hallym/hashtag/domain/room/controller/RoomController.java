package hallym.hashtag.domain.room.controller;

import hallym.hashtag.domain.room.dto.RoomDto;
import hallym.hashtag.domain.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/room")
public class RoomController {
    private final RoomService roomService;

    @GetMapping("list")
    public List<RoomDto> findAll() {
        return roomService.findAll();
    }
}
