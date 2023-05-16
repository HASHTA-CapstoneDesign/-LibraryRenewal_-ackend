package hallym.hashtag.service;

import hallym.hashtag.domain.abook.dto.ABookRequestDto;
import hallym.hashtag.domain.abook.service.ABookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class ABookServiceTest {
    @Autowired
    ABookService aBookService;

    @Test
    public void ABookCreate() {
        Long bno = 2L;

        IntStream.rangeClosed(1,5).forEach(i -> {
            ABookRequestDto aBookRequestDto = ABookRequestDto.builder()
                    .tag("tag1").build();
            aBookService.create(bno, aBookRequestDto);
        });
        System.out.println("----------저장 완료!----------");
    }

    @Test
    public void ABookFindAllByBno() {
        Long bno = 1L;

        aBookService.findAllByBook(bno);
    }

}
