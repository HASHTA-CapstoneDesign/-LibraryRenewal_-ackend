package hallym.hashtag.service;

import hallym.hashtag.domain.notice.dto.NoticeRequestDto;
import hallym.hashtag.domain.notice.service.NoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NoticeServiceTest {
    @Autowired
    NoticeService noticeService;

    @Test
    public void testCreate() {
        Long ano = 1L;
        NoticeRequestDto noticeRequestDto = NoticeRequestDto.builder()
                .title("제목1")
                .content("내용")
                .important(Boolean.TRUE)
                .build();
        noticeService.create(ano, noticeRequestDto);
    }

    @Test
    public void testFindAll() {
        noticeService.findAll();
    }

    @Test
    public void testFindByOne() {
        Long nno = 1L;
        noticeService.findByOne(nno);
    }

    @Test
    public void testUpdate() {
        Long nno = 1L;
        NoticeRequestDto noticeRequestDto = NoticeRequestDto.builder()
                .title("수정 제목1")
                .content("수정 내용").build();
        noticeService.update(nno, noticeRequestDto);
    }

    @Test
    public void testDelete() {
        Long nno = 1L;
        noticeService.delete(nno);
    }

    @Test
    public void testSearch() {
        String keyword = "이러하다";
        noticeService.search(keyword);
    }
}
