package hallym.hashtag.repository;

import hallym.hashtag.domain.admin.entity.Admin;
import hallym.hashtag.domain.admin.repository.AdminRepository;
import hallym.hashtag.domain.notice.entity.Notice;
import hallym.hashtag.domain.notice.repository.NoticeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class NoticeRepositoryTest {
    @Autowired
    NoticeRepository noticeRepository;
    @Autowired
    AdminRepository adminRepository;

//    @Test
//    public void testSave() {
//        Optional<Admin> byAno = adminRepository.findById(1L);
//        Notice notice = Notice.builder()
//                .title("클라이언트의 가계도 그리기")
//                .content("클라이언트의 가계도는 이러하다.")
//                .(byAno.get()).build();
//        noticeRepository.save(notice);
//    }

    @Test
    public void testSearch() {
        String keyword = "이러하다";
        noticeRepository.findByTitleContainingOrContentContaining(keyword, keyword);
    }
}
