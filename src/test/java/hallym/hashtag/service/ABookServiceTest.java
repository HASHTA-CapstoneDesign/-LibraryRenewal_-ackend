package hallym.hashtag.service;

import hallym.hashtag.domain.ABook.dto.ABookRequestDto;
import hallym.hashtag.domain.ABook.service.ABookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ABookServiceTest {
    @Autowired
    ABookService aBookService;

    @Test
    public void AbookCreate() {
        Long bno = 1L;
        ABookRequestDto aBookRequestDto = ABookRequestDto.builder()
                .tag("tag1").build();

        aBookService.create(bno, aBookRequestDto);
        System.out.println("----------저장 완료!----------");
    }
}
