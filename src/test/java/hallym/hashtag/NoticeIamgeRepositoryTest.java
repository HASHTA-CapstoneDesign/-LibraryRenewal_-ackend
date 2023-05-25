package hallym.hashtag;

import hallym.hashtag.domain.notice.repository.NoticeImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NoticeIamgeRepositoryTest {
    @Autowired
    NoticeImageRepository noticeImageRepository;

    @Test
    public void testFindAllByNotice_Nno() {
        noticeImageRepository.findAllByNotice_Nno(1L);
    }
}
