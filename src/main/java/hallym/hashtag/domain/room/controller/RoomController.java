package hallym.hashtag.domain.room.controller;

import hallym.hashtag.domain.room.dto.RoomDto;
import hallym.hashtag.domain.room.entity.Floor;
import hallym.hashtag.domain.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/room")
public class RoomController {
    private final RoomService roomService;

    @GetMapping("")
    public List<RoomDto> findAll(@RequestParam(value = "floor") String floor,
                                 @RequestParam(value = "data") String data) {
        Floor newFloor = Floor.valueOf(floor);
        return roomService.findAll(newFloor, data);
    }
}
