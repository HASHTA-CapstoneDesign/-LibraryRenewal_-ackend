package hallym.hashtag.domain.notice.service;

import hallym.hashtag.domain.notice.entity.Notice;
import hallym.hashtag.domain.notice.entity.NoticeImage;
import hallym.hashtag.domain.notice.repository.NoticeImageRepository;
import hallym.hashtag.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class NoticeImageService {
    private final NoticeImageRepository noticeImageRepository;

    @Value(value = "${spring.file.name}")
    private String file;

    public byte[] findImage(Long nno) throws IOException {
        List<NoticeImage> byNino = noticeImageRepository.findAllByNotice_Nno(nno);
        if(byNino.isEmpty()) throw new RuntimeException("해당 글이 없습니다.");

        InputStream inputStream = new FileInputStream(file + byNino.get(0).getFileName());
        byte[] imageByteArray = IOUtils.toByteArray(inputStream);
        inputStream.close();

        return imageByteArray;
    }
}
