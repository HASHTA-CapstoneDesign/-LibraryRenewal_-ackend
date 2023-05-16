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

    @ApiOperation(value = "시설 작성")
    @PostMapping
    private RoomDto roomCreate(@RequestBody RoomDto roomDto) {
        return roomService.create(roomDto);
    }

    @ApiOperation(value = "시설 검색", notes = "시설 전체 조회 합니다." +
            "이미지가 추가 됩니다.")
    @GetMapping
    public List<RoomDto> roomSearch(@RequestParam(value = "keyword") String keyword) {
        return roomService.searchByAll(keyword);
    }

    @ApiOperation(value = "스터디룸 검색", notes = "스터디룸 조회 합니다." +
            "이미지가 추가 됩니다." +
            "스터디룸 예약을 따로 모으기 위해 만들어진 API입니다.")
    @GetMapping("study")
    public List<RoomDto> roomSearchByStudy() {
        return roomService.searchByStudy();
    }
}
