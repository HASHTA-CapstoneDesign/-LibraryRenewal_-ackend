package hallym.hashtag.domain.roomRes.controller;

import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
import hallym.hashtag.domain.roomRes.dto.RoomResResponseDto;
import hallym.hashtag.domain.roomRes.service.RoomResService;
import hallym.hashtag.global.baseDto.PageRequestDto;
import hallym.hashtag.global.baseDto.PageResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/reserve/room")
public class RoomResController {
    private final RoomResService roomResService;

    @PostMapping("")
    public RoomResResponseDto reserve(@RequestBody RoomResRequestDto roomResRequestDto) {
        return roomResService.reserve(roomResRequestDto);
    }

    @PatchMapping("cancel/{rrno}")
    public RoomResResponseDto cancel(@PathVariable(name = "rrno") Long rrno) {
        return roomResService.cancel(rrno);
    }

    @GetMapping("{uno}")
    public PageResponseDto<RoomResResponseDto> findAllUno(@PathVariable("uno") Long uno, PageRequestDto pageRequestDto) {
        return roomResService.findAllUno(uno, pageRequestDto);
    }
}
