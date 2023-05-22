package hallym.hashtag.domain.roomRes.controller;

import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
import hallym.hashtag.domain.roomRes.dto.RoomResResponseDto;
import hallym.hashtag.domain.roomRes.service.RoomResService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/reserve/room")
public class RoomResController {
    private final RoomResService roomResService;

    @PostMapping("")
    public RoomResResponseDto reserve(@RequestBody RoomResRequestDto roomResRequestDto) {
        return roomResService.reserve(roomResRequestDto);
    }
}
