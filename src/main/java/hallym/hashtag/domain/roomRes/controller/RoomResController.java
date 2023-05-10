package hallym.hashtag.domain.roomRes.controller;

import hallym.hashtag.domain.roomRes.dto.RoomResRequestDto;
import hallym.hashtag.domain.roomRes.dto.RoomResResponseDto;
import hallym.hashtag.domain.roomRes.service.RoomResService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/reserve/room")
public class RoomResController {
    private final RoomResService roomResService;

    @ApiOperation(value = "스터디룸 예약", notes = "스터시룸을 예약하는 api입니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uno", value = "유저 아이디(고유 식별 번호)", required = true, dataTypeClass = Long.class),
            @ApiImplicitParam(name = "rno", value = "시설 아이디(고유 식별 번호)", required = true, dataTypeClass = Long.class)
    })
    @PostMapping("{uno}/{rno}")
    public RoomResResponseDto reserve(@PathVariable(name = "uno") Long uno,
                                      @PathVariable(name = "rno") Long rno,
                                      @RequestBody RoomResRequestDto roomResRequestDto) {
        return roomResService.reserve(uno, rno, roomResRequestDto);
    }

    @ApiOperation(value = "스터디룸 예약 취소", notes = "스터시룸을 예약을 취소하는 api입니다.")
    @ApiImplicitParam(name = "rrno", value = "스터디룸 예약 아이디(고유 식별 번호)", required = true, dataTypeClass = Long.class)
    @PostMapping("{rrno}")
    public String cancel(@PathVariable(name = "rrno") Long rrno) {
        return roomResService.cancel(rrno);
    }
}
