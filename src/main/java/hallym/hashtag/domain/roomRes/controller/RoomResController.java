package hallym.hashtag.domain.roomRes.controller;

import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
import hallym.hashtag.domain.roomRes.dto.RoomResResponseDto;
import hallym.hashtag.domain.roomRes.service.RoomResService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/reserve/room")
public class RoomResController {
    private final RoomResService roomResService;

    @PostMapping("{uno}/{rno}")
    public RoomResResponseDto roomResReserve(@PathVariable(name = "uno") Long uno,
                                             @PathVariable(name = "rno") Long rno,
                                             @RequestBody RoomResRequestDto roomResRequestDto) {
        return roomResService.reserve(uno, rno, roomResRequestDto);
    }
}
