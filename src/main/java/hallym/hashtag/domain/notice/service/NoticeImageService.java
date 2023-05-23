package hallym.hashtag.domain.notice.service;

import hallym.hashtag.domain.notice.entity.Notice;
import hallym.hashtag.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class NoticeImageService {
    private final NoticeRepository noticeRepository;

    @Value("${spring.file.name}")
    private String file;

    public byte[] findImage(Long nno) throws IOException {
        Optional<Notice> byNino = noticeRepository.findById(nno);
        InputStream imageStream = new FileInputStream(file + byNino.get().getImageFileName());
        byte[] imageByteArray = IOUtils.toByteArray(imageStream);
        imageStream.close();
        return imageByteArray;
    }
}
